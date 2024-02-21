import java.io.*;
class ar1
{
public static void main(String ark[])throws IOException
{
int arr[][]=new int[3][3];
BufferedReader tani=new BufferedReader(new InputStreamReader(System.in));
for(int i=0;i<3;i++)
{
for(int j=0;j<3;j++)
{
System.out.println("Enter a number ");
arr[i][j]=Integer.parseInt(tani.readLine());
}
}
System.out.println("Display 2D array");
for(int i=0;i<3;i++)
{
System.out.println();
for(int j=0;j<3;j++)
{
System.out.print(arr[i][j]);
}
}
}
}