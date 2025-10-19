public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Binary Search Implementation");
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int target=7;       
        System.out.println("Target found at index: " + binarySearch(arr, target));
        int result = binaryRecursion(arr, 0, arr.length - 1, target);
        System.out.println("using recursion,the target is found at: " + result);
    }

    //without recursion
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    // using recursion

    static int binaryRecursion(int[] arr,int start,int end,int target){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]<target){
            return binaryRecursion(arr, mid+1, end, target);
        }
        else{
            
            return binaryRecursion(arr, start, mid-1, target);
        }
    }

            //you dont need return if u use void.
}
