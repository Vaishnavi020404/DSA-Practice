// 5️⃣ Set Mismatch (LeetCode 645)
// Link: https://leetcode.com/problems/set-mismatch/
// Time Complexity: O(n)
// Space Complexity: O(1)

// What to Remember & Why:

// Mix of missing and duplicate number logic → Needs both in one sum.

// CorrectIndex = nums[i] - 1 → Same cyclic sort core idea.

// Careful while writing second loop → Don’t overwrite both values accidentally.

//This sum is a mix of 268 and 442(find the repeated one and the missing one)

import java.util.Arrays;
import java.util.Scanner;

public class SetMismatch {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements (numbers from 1 to n, with a few numberes repeated twice and a few mssing):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = findErrorNums(nums);

        System.out.println("The Numbers that have occured twice and are missing, are: " + Arrays.toString(result));
        }

        static int[] findErrorNums(int[] nums) {
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
        int j=0;
        int[] ans=new int[2];
        while(j<nums.length){
            if(nums[j]!=j+1){
                ans[0]=nums[j];
                ans[1]=j+1;            
                break;
            }
            j++;
        }
        return ans;
        
    }


    
}
