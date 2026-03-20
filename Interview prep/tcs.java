import java.util.Scanner;
public class tcs {
    public static void main(String[] args){
        // Scanner sc=new Scanner(System.in);
        // ArrayList<Integer> arr=new ArrayList<>();
        // while(sc.hasNextInt()){
        //     arr.add(sc.nextInt());
        // }
        
        // for(int a:arr){
        //     System.out.println(a);
        // }


        // TAKING INPUT WHICH ARE COMMMA SEPERATED

        // Scanner sc=new Scanner(System.in);
        // String input=sc.nextLine();
        // if(input.startsWith("{") && input.endsWith("}")){
        //     input =input.substring(1,input.length()-1);
        // }
        // String[] str=input.split(",");
        // ArrayList<Integer> arr=new ArrayList<>();
        // for(String token:str){
        //     arr.add(Integer.parseInt(token));
        // }

        //to input string after integer

        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // sc.nextLine();
        // String s=sc.nextLine();
        // char ch=sc.next().charAt(0);
        // //the above code line fo code about takign char input means? 
        // // sc.next() reads the next token (word) from the input, and charAt(0) takes the first character of that token. So, if you input "hello", ch will be 'h'. If you input "a", ch will be 'a'. If you input "abc", ch will still be 'a' because it only takes the first character of the token.
        // System.out.println(S);



        //counting the number of hashes and stars in inout string
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int countHash=0;
        int countStar=0;
        for(char token:input.toCharArray()){
            if(token=="#"){
                countHash++;
            }
            else if(token=="*"){
                countStar++;

            }
        }
        System.out.println(countStar-countHash);
        //example:
        //input: ##**#*
        //output: 1
        //beacuase there are 4 stars and 3 hashes, so the difference is 1.


        }
}
