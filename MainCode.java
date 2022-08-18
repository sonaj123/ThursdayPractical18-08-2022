/*Devise a Java program with three thread synchronization(thread-1 to generate prime numbers,thread-2 to generate 11 multiplication table andthread-3 to print the sequence 3,6,18,72…..)Use both synchronized / joint () methods2.*/

class TestThread
{ 
	synchronized void primeNumbers(int number)
	{
		int count=0;
		if(number>1)
		{
			count++;
			for(int i=2;i<=number/2;i++)
			{
				if(number%i==0)
				{
					count++;
				}
			}			
		}
		if(count>0)
		{
			System.out.println("The Number "+number+" is not prime");
		}
		else
		{
			System.out.println("The Number "+number+" is prime");
		}
	}  
	synchronized void Table(int n)
	{
		int mul;
		for(int i=1;i<=10;i++)
		{
			mul=n*i;
			System.out.println("11 * "+i+" ="+mul);
		}
	}
	synchronized void sequence(int num)
	{
		for(int i=1;i<=10;i++)
		{
			num=num*i;
			System.out.println(num);
		}
	}
}
class ThreadSample1 extends Thread
{
	TestThread t;
	ThreadSample1(TestThread t)
	{
		this.t=t;
	}
	public void run()
	{
		t.primeNumbers(12);
	}
}
class ThreadSample2 extends Thread
{
	TestThread t;
	ThreadSample2(TestThread t)
	{
		this.t=t;
	}
	public void run()
	{
		t.Table(11);
	}
}
class ThreadSample3 extends Thread
{
	TestThread t;
	ThreadSample3(TestThread t)
	{
		this.t=t;
	}
	public void run()
	{
		t.sequence(3);
	}
}
public class MainCode
{
	public static void main(String[] args)
	{
		TestThread obj = new TestThread();
		ThreadSample1 obj1 = new ThreadSample1(obj);
		ThreadSample2 obj2 = new ThreadSample2(obj);
		ThreadSample3 obj3 = new ThreadSample3(obj);
		obj1.start();
		obj2.start();
		obj3.start();
	}
}