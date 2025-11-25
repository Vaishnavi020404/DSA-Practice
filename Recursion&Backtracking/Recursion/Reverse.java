public class Reverse {
    public static void main(String[] args){
        rev1(321);
        System.out.println(sum);
        System.out.println(rev2(654));
        System.out.println(palindrome(456));

//        rev2(123);
    }

//    static int sum=0;
//    static void rev1(int n){
//        if(n==0){
//            return ;
//        }
//        int remainder=n%10;
//        sum=sum*10+remainder;
//        rev1(n/10);
//
//    }

    //way 1
    static int sum=0;
    static int rev1(int n){
        if(n==0){
            return 0;
        }
        int remainder=n%10;
        sum=sum*10+remainder;
        rev1(n/10);
        return sum;
    }


    //way 2
    static int rev2(int n){
        //sometimes we need some addtional variables in the arguement,in that case,make another function
        int digits=(int)(Math.log10(n))+1;
        return helper(n,digits);
    }

    private static int helper(int n,int digits){
        if(n%10==0){
            return n;
        }
        int rem=n%10;
        return rem*(int)(Math.pow(10,digits-1))+helper(n/10,digits-1);

    }

    static boolean palindrome(int n){
        return n==rev1(n);
    }

}
//Suppose n = 4567
//Math.log10(4567)
//≈ 3.659…
//(int) 3.659…
//becomes 3 (decimal part removed)
//   3 + 1 = 4
//So the number 4567 has 4 digits.
//Why this works
//Because:
//Any 4-digit number is between 10³ and 10⁴
//log₁₀ of any number in that range is between 3 and 4
//Taking the integer part gives you (digits – 1)
//Adding 1 finishes the count.