/*Write a Java program that implements a multi-thread application that has three threads. First thread generates random integer every 1 second and if the value is even, second thread computes the square of the number and prints. If the value is odd, the third thread will print the value of cube of the number.*/

class Test1 extends Thread
{
	int i;
	Test1(int i)
	{
		this.i=i;
	}
	public void run()
	{
		int square=i*i;
		System.out.println("The Thread "+i+" is EVEN and Square of "+i+" is "+square);
	}
}
class Test2 extends Thread
{
	int i;
	Test2(int i)
	{
		this.i=i;
	}
	public void run()
	{
		int cube=i*i*i;
		System.out.println("The Thread "+i+" is ODD and Cube of "+i+" is "+cube);	
	}
}
class MainMultiThread
{
	public static void main(String[] args)
	{
		for(int i=1;i<=10;i++)
		{
			Test1 t1 = new Test1(i);
			Test2 t2 = new Test2(i);
			System.out.println("Generated Number is "+i);
			if(i%2==0)
			{
				t1.start();
			}
			else
			{
				t2.start();
			}
			try
			{	
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);	
			}
		}
	}
}
