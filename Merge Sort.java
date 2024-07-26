class Solution {
    // Method to perform merge sort on the array from index i to j
    public void mergeSort(int i, int j, int[] arr) {
        // Base case: if the array segment has one or no elements, it is already sorted
        if (i >= j) return;

        // Calculate the mid-point of the current segment
        int mid = (i + j) / 2;
        
        // Recursively sort the left half
        mergeSort(i, mid, arr);
        
        // Recursively sort the right half
        mergeSort(mid + 1, j, arr);
        
        // Merge the two sorted halves
        merge(arr, i, mid, j);
    }

    // Method to merge two sorted halves of the array
    public void merge(int[] arr, int l, int m, int r) {
        // Create a list to store the merged result
        ArrayList<Integer> list = new ArrayList<>();
        int low = l;
        int high = m + 1;

        // Merge elements from both halves into the list in sorted order
        while (low <= m && high <= r) {
            if (arr[low] > arr[high]) {
                list.add(arr[high]);
                high++;
            } else {
                list.add(arr[low]);
                low++;
            }
        }

        // If there are remaining elements in the left half, add them to the list
        while (low <= m) {
            list.add(arr[low]);
            low++;
        }

        // If there are remaining elements in the right half, add them to the list
        while (high <= r) {
            list.add(arr[high]);
            high++;
        }

        // Copy the merged elements back into the original array
        int i = l;
        for (int a : list) {
            arr[i] = a;
            i++;
        }
    }

    // Method to sort the entire array using merge sort
    public int[] sortArray(int[] nums) {
        // Call mergeSort on the entire array
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }
}

// Time complexity: O(n log n)
// Space complexity: O(n)
