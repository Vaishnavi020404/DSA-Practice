// package Patterns;

public class Main {
    public static void main(String[] args) {
        System.out.println("Design Patterns in Java: ");
        System.out.println();
        pattern1(5);
        System.out.println();
        pattern2(5);
        System.out.println();
        pattern3(5);
        System.out.println();
        pattern4(5);
        System.out.println();
        pattern5(5);
        System.out.println();
        pattern6(5);
        System.out.println();
        pattern7(5);
        System.out.println();
        pattern8(5);
        System.out.println("");
        pattern9(4);


    }

    static void pattern1(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // or 
    // static void pattern4(int n){
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=n-i+1;j++){
    //             System.out.print("* ");
    //         }
    //         System.out.println();
    //     }
    // }
 
     
    static void pattern4(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }


        static void pattern5(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n-1;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    } 

    // static void pattern6(int n){
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=i;j++){
    //             System.out.print(i+" ");
    //         }
    //         System.out.println();
    //     }
    //     for(int i=n-1;i>=1;i--){
    //         for(int j=1;j<=i;j++){
    //             System.out.print(i+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // or
    static void pattern6(int n){
    for(int i = 1; i <= 2*n - 1; i++) {
    int num = i <= n ? i : 2*n - i;
    for(int j = 1; j <= num; j++) {
        System.out.print(j + " ");
    }
    System.out.println();
    }
    }


    static void pattern7(int n){
        for(int i=1;i<=2*n-1;i++){
            int num=i<=n?i:2*n-i;
            int numofspaces=n-num;
            for(int j=1;j<=numofspaces;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=num;j++){
                System.out.print("* ");
            }
            System.out.println();   
        }
    }


    static void pattern8(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            for(int j=2;j<=i;j++){
                System.out.print(j+" ");
            }

            System.out.println();
        }

        for(int i=n-1;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            for(int j=2;j<=i;j++){
                System.out.print(j+" ");
            }

            System.out.println();
        }
    }

    static void pattern9(int n){
        int og_n=n;
        n=2*n;
        for(int row=1;row<n;row++){
            for(int col=1;col<n;col++){
                int atEveryIndex=Math.min(Math.min(n-col,col),Math.min(n-row,row));
                System.out.print(atEveryIndex+" ");

                // System.out.print(og_n-atEveryIndex+" ");    
            }
            System.out.println();
        }

        System.out.println();
                for(int row=1;row<n;row++){
            for(int col=1;col<n;col++){
                int atEveryIndex=Math.min(Math.min(n-col,col),Math.min(n-row,row));
                // System.out.print(atEveryIndex+" ");
                
                System.out.print(og_n-atEveryIndex+1+" ");    
            }
            System.out.println();
        }
    }





    
}
