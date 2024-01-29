import java.util.Scanner;
public class primeorcomposite {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=scanner.nextInt();
        if(num<2){
            System.out.println(num+"is neither prime nor composite");
            return;
        }
        boolean Prime=true;
        for(int i=2; i<=num/2; i++){
            if(num%i==0){
                Prime=false;
                break;
            }
        }
        if(Prime){
            System.out.println(num+"is a prime number");
        }
        else{
            System.out.println(num+"is a composite number");
        }
    }
}