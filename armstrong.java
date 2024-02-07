import java.util.Scanner;
public class armstrong{
    public static void main(String args[]) {
        System.out.println("Please enter 3 digit number:");
        int number = new Scanner(System.in).nextInt();
        if(isArmStrong(number)){
            System.out.println("Number : " + number 
                   + " is an Armstrong number");
        }else{
            System.out.println("Number : " + number
                      + " is not an Armstrong number");
        }
    
    }
    private static boolean isArmStrong(int number) {
        int result = 0;
        int num = number;
        while(number != 0){
            int remainder = number%10;
            result += remainder*remainder*remainder;
            number = number/10;
        }
        if(num == result){
            return true;
        }
      
        return false;
    } 
  
}
