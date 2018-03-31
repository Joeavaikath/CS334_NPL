import java.util.Scanner;

public class lsrp
{
    public static int i , j , k , v;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the total number of nodes: ");
        v = scan.nextInt();

        int [][] C = new int [v][v];
        int [][] D = new int [2][v];

        System.out.println("Enter the the cost matrix: ");
        for(i=0 ; i<v ; i++)
            for(j=0 ; j<v ; j++)
                C[i][j] = scan.nextInt();

        System.out.println("Enter the source node: ");
        int u = scan.nextInt();

        D = Dijkstra(u , C);
        System.out.printf("\n\n ROUTING TABLE OF %c\n" , toChar(u));
        System.out.println("====================");
        System.out.println("TO\tDIST\tPRED");
        System.out.println("--------------------");
        for(i=0 ; i<v ; i++)
        {
            System.out.printf("%c\t%d\t%c\n" , toChar(i) , D[0][i] , toChar(D[1][i]));
        }
        System.out.println("\n");
    }

    public static int [][] Dijkstra(int u , int [][] C)
    {
        int [] s = new int [v];
        int [][] D = new int [2][v];
        int min;

        for(i=0 ; i<v ; i++)
        {
            s[i] = 0;
            D[0][i] = C[u][i];
            if(C[u][i] != 99)
                D[1][i] = u;
            else
                D[1][i] = -20;
        }
        s[u] = 1;
        D[0][u] = 0;
        D[1][u] = -20;
        min = 0;

        for(i=1 ; i<(v-1) ; i++)
        {
            for(j=0 ; j<v ; j++)
                if(s[j] == 0)
                    break;

            min = j;
            for(j=j+1 ; j<v ; j++)
                if((s[j] == 0) && (D[0][j] < D[0][min]))
                    min = j;

            s[min] = 1;

            for(k=0 ; k<v ; k++)
            {
                if((C[min][k] != 0) && (C[min][k] != 99) && (s[k] == 0))
                    if(D[0][k] > D[0][min] + C[min][k])
                    {
                        D[0][k] = D[0][min] + C[min][k];
                        D[1][k] = min;
                    }
            }
        }

        return D;
    }

    public static char toChar(int a)
    {
        return (char)(a+65);
    }
}
