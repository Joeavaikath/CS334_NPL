import java.util.*;
public class Fibonacci
{
	public static void main(String[] args)
	{
		int a,b,n,temp;
		a=0;
		b=1;
		System.out.print("\nEnter the number of elements:");
		Scanner obj=new Scanner(System.in);
		n = obj.nextInt();
		
		if(n == 1)
		{
			System.out.print(0);
		}
		else if(n ==2)
		{
			System.out.print("0,1");
		}
		else
		{
			System.out.print("0,1,");
			for(int i=2;i<n;i++)
			{
				temp=b;
				b+=a;
				a=temp;
				System.out.print(b+",");
			}
		}
	}
}
						
				