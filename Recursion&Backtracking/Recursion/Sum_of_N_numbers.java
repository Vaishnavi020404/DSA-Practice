import java.util.Scanner;

public class Sum_of_N_numbers {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number to print the sum of numbers till that number: ");
        int x=sc.nextInt();
        System.out.println(sumofNnumbers(x));                
    }
    static int sumofNnumbers(int x){
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }

        int sum=x;
        return sum+sumofNnumbers(x-1);
    }
}
