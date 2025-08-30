// 217. Contains Duplicate  
// 30/8/25
// https://leetcode.com/problems/contains-duplicate/  
// Tag: Hashing/Set  
// Approach: Use HashSet to check duplicates(HashMap can also be used but is less optimized)  
// Time: O(n), Space: O(n)
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Contains_Duplicates{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the  array size of numbers with a few duplicates: ");
        int n=sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
     
        boolean res1=containsduplicatesusingHashSet(arr);
        boolean res2=containsduplicatesusingHashMap(arr);

        System.out.println("Result of Approach 1: "+res1+"\nResult of Approach 2: "+res2);
    }
    //Approach 1:Using HashMap for keeping track of values and their count
    static boolean containsduplicatesusingHashMap(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            // get current count, default = 0
            int count = map.getOrDefault(num, 0);
            if (count >= 1) {
                return true; // already seen once before → duplicate
            }
            map.put(num, count + 1); // increase count
        }

        return false;
    }

    //Approach 2:Using HashSet
    static boolean containsduplicatesusingHashSet(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for(int num :nums){

            if(set.contains(num)){
                return true; //duplicate found
            }
            set.add(num);
        }
        return false;
    }
}
