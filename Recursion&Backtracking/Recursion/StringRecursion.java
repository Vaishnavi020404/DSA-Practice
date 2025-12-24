//This code demonstrates two recursive methods to skip characters in a string, with main method example. Includes both processed/unprocessed and single input approaches.
//Introduced the skip3 method to recursively remove all occurrences of a given substring from the input string. Updated the main method to demonstrate skip3 with an example.
public class StringRecursion {
    public static void main(String[] args){
//        System.out.println(skip2("baccad"));
        String result=skip3("I am a overthinking diva overthinking.","overthinking");
        result=result.replaceAll("\\s+\\.",".").replaceAll("\\s+"," ").trim();
        System.out.println(result);

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

    static String skip3(String up,String removee){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(up.startsWith(removee)){
            return ""+skip3(up.substring(removee.length()),removee);
        }else{
            return ch+skip3(up.substring(1),removee);
        }

    }

}
