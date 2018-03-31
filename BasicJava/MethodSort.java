import java.util.*;
//Program to sort an array by passing it to a method

public class MethodSort
{
	public static void sort(int a[],int n)
	{
		int temp;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
					
		
	
	public static void main(String[] args)
	{
		Scanner obj = new Scanner(System.in);
		int n,a[]= new int[20];
		System.out.println("Enter the number of elements:");
		n = obj.nextInt();
		System.out.println("Enter the list of numbers to sort:");

		for(int i=0;i<n;i++)
			a[i] = obj.nextInt();

		sort(a,n);
		System.out.println("The sorted list is\n");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+",");

	}
}					
			