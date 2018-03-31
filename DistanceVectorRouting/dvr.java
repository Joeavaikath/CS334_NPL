import java.util.Scanner;

public class dvr
{
	public static void main(String[] args)
	{
		int i , j , k , min;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the total number of nodes: ");
		int v = scan.nextInt();

		int [][] C = new int [v][v];
		int [][] R = new int [v][v];
		int [][] N = new int [v][v];

		System.out.println("Enter the cost matrix: ");
		for(i=0 ; i<v ; i++)
			for(j=0 ; j<v ; j++)
			{
				C[i][j] = scan.nextInt();
				R[i][j] = C[i][j];
				N[i][j] = j;
			}

		for(i=0 ; i<v ; i++)
		{
			for(j=0 ; j<v ; j++)
			{
				for(k=0 ; k<v ; k++)
				{
					min = R[i][k] + R[k][j];
					if(R[i][j] > min)
					{
						R[i][j] = min;
						N[i][j] = k;
					}
				}
			}
		}

		for(i=0 ; i<v ; i++)
		{
			System.out.printf("\n\n ROUTING TABLE OF %c\n" , toChar(i,99));
			System.out.println("====================");
			System.out.println("TO\tCOST\tNEXT");
			System.out.println("--------------------");
			for(j=0 ; j<v ; j++)
			{
				System.out.printf("%c\t%d\t%c\n" , toChar(j,99) , R[j][i] , toChar(N[j][i] , i));
			}
		}
		System.out.println("\n");
	}

	public static char toChar(int a , int b)
	{
		if (a != b)
			return (char)(a+65);
		else
			return '-';
	}
}


