public class Count {

    public static void main(String[] args){
        System.out.println(countzero(256000));
    }

    static int countzero(int n){
        int c=0;
        return helper(n, c);
    }

    private static int helper(int n,int c){
        if(n==0){
            return c;
        }
        int rem=n%10;
        if(rem==0){
            return helper(n/10,++c);
            //not c++ coz then You are passing the old value of c, not the incremented one.
        }
        else{
            return helper(n/10,c);
        }
    }


}

//Number: 520
//
//Step 1
//
//n = 520 → last digit 0 → count +1
//Now call helper(52, c)
//
//Step 2
//
//n = 52 → last digit 2 → no count
//Call helper(5, c)
//
//Step 3
//
//n = 5 → last digit 5 → no count
//Call helper(0, c)
//
//Step 4
//
//n = 0 → STOP, return c
