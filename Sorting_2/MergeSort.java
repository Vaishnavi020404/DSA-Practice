
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        mergeSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void mergeSort(int[] arr, int si, int ei) {
        divide(arr, si, ei);
    }
    public static void divide(int[] arr, int si, int ei) {
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        divide(arr, si, mid);
        divide(arr, mid+1,ei);
        conquer(arr, si, mid, ei);  

        
    }

    public static void conquer(int[] arr,int si,int mid,int ei){
        int merged[]=new int[ei-si+1];
        int idx1=si;
        int idx2=mid+1;

        int x=0;

        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2]){
                merged[x++]=arr[idx1++];
            }
            else{
                merged[x++]=arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++]=arr[idx1++];
        }
        while(idx2<=ei){
            merged[x++]=arr[idx2++];
        }
        for(int i=0,j=si;i<merged.length;i++,j++){
            arr[j]=merged[i];
        }

    }    
}

// Perfect! Let’s do a **dry run of your MergeSort code** on your array `{5, 3, 8, 4, 2}` using **your exact `divide` and `conquer` functions**. I’ll show **all steps, including `si`, `mid`, `ei`, idx1, idx2, merged[]**, so you can see exactly what’s happening.

// ---

// ## Initial Call

// ```java
// mergeSort(arr, 0, 4)
// ```

// * Calls: `divide(arr, 0, 4)`
// * `mid = 0 + (4-0)/2 = 2`
// * Split:

// ```
// Left: arr[0..2] = [5, 3, 8]
// Right: arr[3..4] = [4, 2]
// ```

// ---

// ## Step 1: Divide Left `[5, 3, 8]`

// * Call: `divide(arr, 0, 2)`
// * `mid = 0 + (2-0)/2 = 1`
// * Split:

// ```
// Left: arr[0..1] = [5, 3]
// Right: arr[2..2] = [8]
// ```

// ---

// ### Step 1a: Divide `[5, 3]`

// * Call: `divide(arr, 0, 1)`
// * `mid = 0 + (1-0)/2 = 0`
// * Split: `[5]` and `[3]` → base case (single elements)

// ---

// ### Step 1b: Conquer `[5]` and `[3]`

// **Call:** `conquer(arr, 0, 0, 1)`

// * `idx1 = si = 0` → 5
// * `idx2 = mid+1 = 1` → 3
// * `merged[] = new int[2] = [ , ]`

// **Step-by-step merge:**

// 1. Compare arr[idx1] vs arr[idx2]: 5 vs 3 → 3 is smaller → `merged[0] = 3`, idx2++ → 2, x++ → 1
// 2. Leftover from left: idx1=0 ≤ mid=0 → `merged[1] = 5`, idx1++ → 1, x++ → 2
// 3. Copy back: `arr[0] = 3`, `arr[1] = 5`

// ✅ Result: `[3, 5, 8, 4, 2]`

// ---

// ### Step 1c: Conquer `[3, 5]` and `[8]`

// **Call:** `conquer(arr, 0, 1, 2)`

// * `idx1 = 0` → 3
// * `idx2 = 2` → 8
// * `merged[] = new int[3] = [ , , ]`

// **Step-by-step:**

// 1. Compare 3 vs 8 → 3 ≤ 8 → merged[0] = 3, idx1++ → 1, x=1
// 2. Compare 5 vs 8 → 5 ≤ 8 → merged[1] = 5, idx1++ → 2, x=2
// 3. Leftover from right: idx2=2 ≤ ei=2 → merged[2] = 8, idx2++ → 3
// 4. Copy back: arr[0..2] = [3, 5, 8]

// ✅ Result: `[3, 5, 8, 4, 2]`

// ---

// ## Step 2: Divide Right `[4, 2]`

// * Call: `divide(arr, 3, 4)`
// * `mid = 3 + (4-3)/2 = 3`
// * Split: `[4]` and `[2]` → base case

// ---

// ### Step 2a: Conquer `[4]` and `[2]`

// **Call:** `conquer(arr, 3, 3, 4)`

// * `idx1 = 3` → 4
// * `idx2 = 4` → 2
// * `merged[] = [ , ]`

// **Step-by-step:**

// 1. Compare 4 vs 2 → 2 smaller → merged[0] = 2, idx2++ → 5, x=1
// 2. Leftover from left: idx1=3 ≤ mid=3 → merged[1] = 4, idx1++ → 4
// 3. Copy back: arr[3..4] = [2, 4]

// ✅ Result: `[3, 5, 8, 2, 4]`

// ---

// ## Step 3: Conquer `[3, 5, 8]` and `[2, 4]`

// **Call:** `conquer(arr, 0, 2, 4)`

// * `idx1 = 0` → 3
// * `idx2 = 3` → 2
// * `merged[] = new int[5] = [ , , , , ]`

// **Step-by-step:**

// 1. Compare 3 vs 2 → 2 smaller → merged[0] = 2, idx2=4, x=1
// 2. Compare 3 vs 4 → 3 ≤ 4 → merged[1] = 3, idx1=1, x=2
// 3. Compare 5 vs 4 → 4 smaller → merged[2] = 4, idx2=5, x=3
// 4. Leftover from left: idx1=1 ≤ mid=2 → merged[3] = 5, idx1=2, x=4 → merged[4] = 8, idx1=3
// 5. Copy back: arr[0..4] = `[2, 3, 4, 5, 8]`

// ✅ Fully sorted!

// ---

// ### ✅ Final Array

// ```
// [2, 3, 4, 5, 8]
// ```

// ---

// 💡 **Key points to remember from dry run**

// 1. `si`, `mid`, `ei` define the **current segment to merge**.
// 2. `idx1 = si` → left half start, stops at `mid`
// 3. `idx2 = mid+1` → right half start, stops at `ei`
// 4. `merged[]` temporarily holds sorted numbers
// 5. Copy back to `arr[si..ei]` → now this part is sorted


