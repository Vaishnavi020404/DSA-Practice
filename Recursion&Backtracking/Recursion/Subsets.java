public class Subsets {

   public static void main(String[] args) {
       subseq("", "abc");
   }

   // string version
   static void subseq(String p, String up) {
       if (up.isEmpty()) {
           System.out.println(p);
           return;
       }
       char ch = up.charAt(0);
       subseq(p + ch, up.substring(1));
       subseq(p, up.substring(1));

//            OR
//            subseq(p, up.substring(1));
//            subseq(p + ch, up.substring(1));

   }}
//
//
//}
// How the empty subsequence is created
//Start with:
//subseq("", "abc");
//
//Now imagine the path where you always skip characters:
//Skip 'a' → p = "", up = "bc"
//Skip 'b' → p = "", up = "c"
//Skip 'c' → p = "", up = ""
//At this point:
//        if (up.isEmpty()) {
//        System.out.println(p); // p = ""
//}
//p is still "" → this is the empty subsequence.
//
//So it prints a blank line.