import java.util.*;
//Program to check if the string is a palindrome
public class Palindrome
{
        public static void main(String[] args)
        {
                int flag=0;
                Scanner obj = new Scanner(System.in);
                String word;
                System.out.println("Enter the string:");
                word=obj.next();
                int n = word.length();
                int j=n-1;
                for(int i=0;i<n;i++)
                {
                        if(word.charAt(i)!=word.charAt(j))
                        {       flag=1;
                                break;
                        }
                        j--;
                }
                if(flag == 1)
                        System.out.println("\nNot a palindrome");
                else
                        System.out.println("\nIt is a palindrome");
        }
}
