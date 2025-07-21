
public class Floor{
    public static void main(String[] args) {
        int[] arr = {1,2,5,6,8,9,11,13,15,18};
        int target = 10;
        int result = search(arr, target);
        System.out.println(result);
    }
    public static int search(int[] arr, int target) {
        int start=0;
        int end = arr.length - 1;

        if(target>=arr[arr.length-1]){
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return arr[start];


    }

}