// Find All Disappeared Numbers (LeetCode 448)
// Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Time Complexity: O(n)
// Space Complexity: O(1) (excluding output list)

// What to Remember & Why:

// Array has numbers from 1 to n → That’s why correctIndex = nums[i] - 1.

// No nums[i] < nums.length check needed → Values guaranteed in range.

// nums[j] != j + 1 → Missing numbers appear where this condition is true after sorting.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisappearedNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of array (n): ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements (numbers from 1 to n, missing one number):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("The Disappeared Numbers are " + findDisappearedNumbers(nums));
    
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
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
                //if the correct number is not present then that means some other duplicate number is present.for eg:if 5 is the length of the array,if 6 is not present at 5th index then 2,3,1 or 4 must be present(eg:[1,2,3,4,3])
                //this is the opposite case of finding duplicate numbers(problem no.287) because here we find what is missing and in 287,we find which numbers caused the actual value to be missing i.e.;the the duplicate or extra values.
                ans.add(j+1);
                j++;
            }else{
                j++;
            }
        }
        return ans;
    }
    

}
