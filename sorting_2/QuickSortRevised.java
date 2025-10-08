public class QuickSortRevised {
    public static void main(String[] args){
        int[] arr={5,3,6,9,5,2,1,4,8,7};

        quicksort(arr,0,arr.length-1);
        for(int num:arr){
            System.out.print(num+" ");
        }

    }

    static int quicksort(int[] arr,int low,int high){
        if(low>=high) return -1;
        int pivot=partition(arr,low,high);
        quicksort(arr,low,pivot-1);
        quicksort(arr,pivot+1,high);
        return pivot;


        // or 

        // if(low<high){
        //     int pivot=partition(arr,low,high);
        //     quicksort(arr,low,pivot-1);
        //     quicksort(arr,pivot+1,high);
        // }
    }

    static int partition(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low;
        int j=high;

        while(i<j){
            while(i<high && arr[i]<=pivot) i++;
            while(j>low && arr[j]>pivot) j--;
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

//         When moving i → while (arr[i] <= pivot && i < high)
// → to stop i from going off the array.

// When moving j → while (arr[j] > pivot && j > low)
// → to stop j from going off the array.

// Before swapping → if (i < j)
// → to stop a bad swap if they’ve crossed.

        int temp=arr[low];
        arr[low]=arr[j];    
        arr[j]=temp;
        return j;
    }
}


// Why it feels like repetition

// #1 (if (low < high))
// → recursion guard: don’t quicksort empty or 1-element subarrays.

// #2 (while (i < j))
// → main partition loop: keep moving i/j until they meet or cross.

// #3 (i < high)
// → boundary guard: don’t let i walk off the array.

// #4 (j > low)
// → boundary guard: don’t let j walk off the array.

// #5 (if (i < j))
// → swap guard: only swap if pointers haven’t crossed after moving.