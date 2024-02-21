import java.util.*;
import java.io.*;
class empsalary
{
    String name;
    String empno;
    int basic;
     double da,hra,pf,gross,net;
    void input()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("enter name of the employee:");
        name=br.readLine();
        System.out.println("enter employee no.:");
        empno=br.readLine();
        System.out.println("enter the basic salary of employee:");
        basic=Integer.parseInt(br.readLine());
    }
    void cal()
    {
       
        da=basic * 0.3;
        hra=0.15*basic;
        pf=0.12*basic;
        gross=basic+da+hra;
        net=gross-pf;
    }
    void display()
    {
        System.out.println("name:"+name  + "\n"+" Basic " + basic + "\n"+" Net " + net);
    }
    public static void main(String args[]) throws IOException
    {
        empsalary obj=new empsalary();
        obj.input();
        obj.cal();
        obj.display();        
    }
}
