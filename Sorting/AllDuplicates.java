// 4️⃣ Find All Duplicates in an Array (LeetCode 442)
// Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/
// Time Complexity: O(n)
// Space Complexity: O(1) (excluding output list)

// What to Remember & Why:

// Array has numbers from 1 to n → Same range logic as disappeared numbers.

// nums[j] != j + 1 → Identifies duplicates after cyclic sort.

// Return all out-of-place numbers → Leftovers = duplicates.



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements (numbers from 1 to n, with one or more number repeated):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("The Duplicated Numbers are: " + findDuplicates(nums));
    }
        
    static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if (nums[i]!=nums[correctIndex]){
                int temp=nums[i];
                nums[i]=nums[correctIndex];
                nums[correctIndex]=temp;
            }else{
                i++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        int j=0;
        while(j<nums.length){
            if(nums[j]!=j+1){
                ans.add(nums[j]);
            }
            j++;
        }
        return ans;
        
    }

    
}
