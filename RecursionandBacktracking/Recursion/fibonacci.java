import java.util.Scanner;

public class fibonacci {
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range for the fibonacci you want: ");
        int x=sc.nextInt();
        for(int i=0;i<x;i++){
            System.out.println(fibonacci(i));
        }
                
    }
    static int fibonacci(int x){
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }
        return fibonacci(x-1)+fibonacci(x-2);
    }
    
}
