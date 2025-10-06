import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("Enter the number of unsorted array elements: ");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // arr=SelectionSort(arr);
        arr=SelectionSortRecursive(arr, n);

        System.out.println("Sorted array elements: "+ Arrays.toString(arr));

    }
    // static int[] SelectionSort(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         int minIndex=i;
    //         for(int j=i+1;j<=n-1;j++){
    //             if(arr[j]<arr[minIndex]){
    //                 minIndex=j;
    //             }
    //         }
    //         if(minIndex!=i){
    //             int temp=arr[i];
    //             arr[i]=arr[minIndex];
    //             arr[minIndex]=temp;
    //         }
    //     }
    //     return arr;
    // }

    static int[] SelectionSortRecursive(int[] arr, int n) {
    // Base case: If the array size is 1, it's already sorted
    if (n == 1) {
        return arr;
    }

    // One pass of bubble sort. After this pass, the largest element is moved to the end.
    for (int i = 0; i < n - 1; i++) {
    
    int minIndex=i;
    for(int j=i+1;j<=n-1;j++){
        if(arr[j]<arr[minIndex]){
            minIndex=j;
        }
    }
    if(minIndex!=i){
        int temp=arr[i];
        arr[i]=arr[minIndex];
        arr[minIndex]=temp;
    }

    
    }            // Recursive call for the remaining array
    return SelectionSortRecursive(arr, n - 1);
    }
}
