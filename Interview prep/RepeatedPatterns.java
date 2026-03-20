// package Interview

// import javax.xml.crypto.dsig.spec.HMACParameterSpec;

// prep;

// public class RepeatedPatterns {

//    //1.Two SUm(Sorted Array)
// //    When?
// //    Sorted Arrray
// //    Pair Sum
// //    Remove duplicates
// //    Reverse array/string
// //    Time complexity: O(n)
// //    Space complexity: O(1)
//    public static int[] twoSum(int[] arr,int target){
//     int left=0;
//     int right=arr.length-1;

//     while(left<right){
//         int sum=arr[left]+arr[right];
//         if(sum==target){
//             return new int[]{left,right};
//         }
//         else if(sum<target){
//             left++;
//             right--;
//         }else{
//             right--; //we need to reduce the totoal sum that is why we nreduce the right pointer because it is the larger number which contributes more in the sum
//         }
//         }
//         return new int[]{-1,-1};
//     }

//     //2.Slding Window
//     // When?
//     // Subarray Problems
//     // Longest substring
//     // Max/Min length
//     // Fixed/variable window
//     // Time complexity: O(n)
//     // Space complexity: O(1) or O(k) depending on the problem

//     //Maximum sum subarray of size k
//     public static int maxSumSubarray(int[] arr,int n){
//         int maxSum=0;
//         int windowSum=0;
//         for(int i=0;i<arr.length;i++){
//             windowSum+=arr[i];
//             if(i>=n-1){
//                 maxSum=Math.max(maxSum, windowSum);
//                 windowSum-=arr[i-n+1];
//             }
//         }
//         return maxSum;
//     }

//     // Understand the goal:
//     // We want:
//     // A window of size k
//     // When a new element enters 
//     // The oldest element must leave
//     // That’s it.

// //     🔑 Sliding Window in one shot
// // At index i, the window ends at i
// // Window size = k
// // So the window starts at i - k + 1
// // That start element is the oldest / leftmost / “last from the first” one


//      //3.Longest substring without repeating characters
//      public static int length(String s){
//         Set<Character> set=new HashSet<>();
//         int left=0;
//         int maxLength=0;
//         for(int right=0;right<s.length();right++){
//             while(set.contains(s.charAt(right))){
//                 set.remove(s.charAt(right));
//                 left++;
//             }
//             set.add(s.charAt(right));
//             maxLength=Math.max(maxlength,right-left+1);
//         }
//         return maxLength;
        
//      }

//      //4. Reverse a string
//      public static void reverseString(char[] s){
//         int left=0;
//         int right=s.length-1;
//         while(left<right){
//             char temp=s[left];
//             s[left]=s[right];
//             s[right]=temp;
//             left++;
//             right--;
//         }
//      }

//      //5. Remove duplicates from sorted array
//      public static int removeDuplicates(int[] arr){
//         if(arr.length==0) return 0;
//         int uniqueIndex=1;
//         for(int i=1;i<arr.length;i++){
//             if(arr[i]!=arr[i-1]){
//                 arr[uniqueIndex]=arr[i];
//                 uniqueIndex++;
//             }
//         }
//         return uniqueIndex;
//      }
    

//      //6.HashMap->Valid Anagram
//     //  When?
//      //count elements
//      //duplicates
//      //anagram
//      //subarray sum

//      // Time complexity: O(n)
//      // Space complexity: O(n)
//     public static boolean isAnagram(String s,String t){
//         if(s.length()!=t.length()) return false;
//         int[] freq=new int[26];

//         for(char c:s.toCharArray()){
//             freq[c-'a']++;
//         }

//         for(char c:t.toCharArray()){
//             freq[c-'a']--;
//             if(freq[c-'a']<0){
//                 return false;
//             }
//         }
//         return true;
//     }
//     //what is an anagram?
//     // An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. For example, "listen" and "silent" are anagrams of each other because they contain the same letters in a different order.


//     //7. HashMap->Subarray sum equals k
//     // When?
//     // Subarray sum problems
//     // Time complexity: O(n)    
//     // Space complexity: O(n)
//     // public static int subarraySum(int[] arr,int k){
//     //     Map<Integer,Integer> map=new HashMap<>();

//     //binary search
//     // When?
//     // Sorted array
    

// } 

