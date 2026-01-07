import java.util.Scanner;
public class factorial{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number you want the factorial for: ");
        int x=sc.nextInt();
        System.out.println(factorial(x));

        
    }
    static int factorial(int x){
        if(x==0){
            return 1;
        }
        if(x==1){
            return 1;
        }
        return x*factorial(x-1);
    }
    
}