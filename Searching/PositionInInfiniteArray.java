//  Problem: Position of an Element in an Infinite Sorted Array
// You are given a sorted array of unknown (infinite) size, and you need to search for a target element’s position.

// Since the size is unknown and potentially infinite, you cannot directly apply binary search on the full array.
// Instead, you first need to find a search range where the target could exist using exponential expansion, and then apply binary search within that range.

// Goal:
// Return the index of the target element if found, otherwise return -1.

public class PositionInInfiniteArray {
    public static void main(String[] args){
        int[] nums = {1, 3, 5, 7, 9,10,13,17,19,22,25,27};
        int target = 22;
        System.out.println(infinitearray(nums, target)); // Output: 9

    }
    static int infinitearray(int[] nums,int target){
        int start = 0, end = 1;

        // Exponential window expansion
        while (end < nums.length && target > nums[end]) {
            int temp = end + 1;
            // Double the window size
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return binarysearch(nums,target,start,end);
    }
    static int binarysearch(int[] nums,int target,int start,int end){
        while(start<=end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
            }
            return -1;
            }

    
}
