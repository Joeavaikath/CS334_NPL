import java.util.*;
//Program to print the factorial of a number

public class Factorial
{
	public static void main(String[] args)
	{
		Scanner obj = new Scanner(System.in);
		int a,prod=1;
		System.out.println("Enter the number to find factorial of:");
		a = obj.nextInt();
		if(a == 0)
			System.out.println(1);
		for(int i=1;i<=a;i++)
			prod *=i;
		System.out.println(prod);
	}
}			