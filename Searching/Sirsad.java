import java.util.Scanner;

public class Sirsad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements (may contain duplicates):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter target element to search:");
        int target = sc.nextInt();

        int index = search(nums, target);
        System.out.println("Index of target: " + index);
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);

        // If array is not rotated
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // If pivot is found, check both subarrays
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    public static int findPivotWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) return mid;
            if (mid > start && nums[mid] < nums[mid - 1]) return mid - 1;

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if (start < end && nums[start] > nums[start + 1]) return start;
                start++;

                if (end > start && nums[end - 1] > nums[end]) return end - 1;
                end--;
            } else if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
