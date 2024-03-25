import java.util.Scanner;  
public class DiamondPattern  
{  
public static void main(String args[])  
{  
int n, i, j, m = 1;  
System.out.print("Enter the number of rows you want to print: ");  
Scanner sc = new Scanner(System.in);  
n = sc.nextInt();  
m = n - 1;  
for (j = 1; j<= n; j++)  
{  
for (i = 1; i<= m; i++)  
{  
System.out.print(" ");  
}  
m--;  
for (i = 1; i <= 2 * j - 1; i++)  
{  
System.out.print("*");  
}  
System.out.println("");  
}  
m = 1;  
for (j = 1; j<= n - 1; j++)  
{  
for (i = 1; i<= m; i++)  
{  
System.out.print(" ");  
}  
m++;  
for (i = 1; i<= 2 * (n - j) - 1; i++)  
{  
System.out.print("*");  
}  
System.out.println("");  
}  
}  
}  