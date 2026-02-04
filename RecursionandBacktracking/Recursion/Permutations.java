import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        // permutations("", "diva");
        // System.out.println(permutationsList("","diva"));
        System.out.println(permutationsCount("","abc"));

    }
    static void permutations(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        // Why <= and not <? inthe for loop condition
// Because you can insert a character at EVERY position including the END.
        for (int i=0;i<=p.length();i++){
            char ch=up.charAt(0);
            String left=p.substring(0,i);
            String right=p.substring(i,p.length());
            permutations(left+ch+right,up.substring(1));
        }
    }

       static int permutationsCount(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;

        for (int i=0;i<=p.length();i++){
            char ch=up.charAt(0);
            String left=p.substring(0,i);
            String right=p.substring(i,p.length());
            count=count+permutationsCount(left+ch+right,up.substring(1));
        }
        return count;
    }
        static ArrayList<String> permutationsList(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }       

        ArrayList<String> finalans =new ArrayList<>();

        for (int i=0;i<=p.length();i++){
            char ch=up.charAt(0);
            String left=p.substring(0,i);
            String right=p.substring(i,p.length());
            finalans.addAll(permutationsList(left+ch+right,up.substring(1)));
        }

        return finalans;
    }
    
}

// You split p, so loop based on p.length().hence p.length in the for loop condition

// WHY YOU DON'T SPLIT up:
// WHAT up REPRESENTS:
// up = Characters you HAVEN'T PLACED YET
// It's like a bag of unused letters.

// WHAT p REPRESENTS:
// p = The partial answer you're BUILDING
// It's the string you're constructing piece by piece.

// permutations("", "abc")
// p="", up="abc", ch='a'
// i can be: 0 (because p.length()=0, so i<=0 means just i=0)
// │
// └─── i=0: left="", right=""
//      Result: "" + 'a' + "" = "a"
//      │
//      └─── permutations("a", "bc")
//           p="a", up="bc", ch='b'
//           i can be: 0,1 (because p.length()=1, so i<=1)
//           │
//           ├─── i=0: left="", right="a"
//           │    Result: "" + 'b' + "a" = "ba"
//           │    │
//           │    └─── permutations("ba", "c")
//           │         p="ba", up="c", ch='c'
//           │         i can be: 0,1,2 (because p.length()=2, so i<=2)
//           │         │
//           │         ├─── i=0: left="", right="ba"
//           │         │    Result: "" + 'c' + "ba" = "cba"
//           │         │    └─── permutations("cba", "") → PRINT "cba" ✓
//           │         │
//           │         ├─── i=1: left="b", right="a"
//           │         │    Result: "b" + 'c' + "a" = "bca"
//           │         │    └─── permutations("bca", "") → PRINT "bca" ✓
//           │         │
//           │         └─── i=2: left="ba", right=""
//           │              Result: "ba" + 'c' + "" = "bac"
//           │              └─── permutations("bac", "") → PRINT "bac" ✓
//           │
//           └─── i=1: left="a", right=""
//                Result: "a" + 'b' + "" = "ab"
//                │
//                └─── permutations("ab", "c")
//                     p="ab", up="c", ch='c'
//                     i can be: 0,1,2 (because p.length()=2, so i<=2)
//                     │
//                     ├─── i=0: left="", right="ab"
//                     │    Result: "" + 'c' + "ab" = "cab"
//                     │    └─── permutations("cab", "") → PRINT "cab" ✓
//                     │
//                     ├─── i=1: left="a", right="b"
//                     │    Result: "a" + 'c' + "b" = "acb"
//                     │    └─── permutations("acb", "") → PRINT "acb" ✓
//                     │
//                     └─── i=2: left="ab", right=""
//                          Result: "ab" + 'c' + "" = "abc"
//                          └─── permutations("abc", "") → PRINT "abc" ✓




// How It Works:
// Instead of printing each permutation when you find it, you collect them all in a list and return them.

// Base Case:
// When no more characters left to process:

// Create a new list
// Put the completed permutation in it
// Return that list (with one item)


// Recursive Case:
// Create an empty list to collect ALL results.
// Then loop through all positions:

// Make recursive call for each position
// That call returns a LIST of permutations
// Add ALL those permutations to your collection list
// Continue for all positions

// After the loop, your list has ALL permutations from ALL branches.
// Return that complete list.