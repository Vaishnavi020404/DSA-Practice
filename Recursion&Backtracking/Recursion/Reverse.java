public class Reverse {
    public static void main(String[] args){
        rev1(321);
        System.out.println(sum);
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





}
