public class StringRecursion {
    public static void main(String[] args){
        System.out.println(skip2("baccad"));

    }
    //method 1:with 2 inputs(a processed and an unprocessed string)
//    static String skip1(String p,String up){
//        if(up.isEmpty()) {
//            return p;
//        }
//
//        char ch=up.charAt(0);
//        if(ch=='a'){
//            return skip1(p,up.substring(1));
//        }else{
//            return skip1(p+ch,up.substring(1));
//        }
//
//
//    }
    //method 2:with only 1 input(an unprocessed string)
    static String skip2(String up){
        if(up.isEmpty()){
            return " ";
        }
        char ch=up.charAt(0);
        if(ch!='a'){
            return ch+skip2(up.substring(1));
        }else{
            return ""+skip2(up.substring(1));
        }
    }


}
