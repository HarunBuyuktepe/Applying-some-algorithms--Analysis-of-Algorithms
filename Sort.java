package cse2036;

public class Sort extends main {
	
	public static int counter = 0;
	
	static int InsertationSort(int arr[],int k)
	 {
	     int n = arr.length;
	     for (int i=1; i<n; ++i)
	     {
	         int key = arr[i];
	         int j = i-1;

	         /* Move elements of arr[0..i-1], that are
	            greater than key, to one position ahead
	            of their current position */
	         while (j>=0 && arr[j] > key){
	        	 counter++;
	             arr[j+1] = arr[j];
	             j = j-1;
	         }
	         arr[j+1] = key;
	     }
		return arr[k];
	     
	     
	 }

	
static void merge(int arr[], int l, int m, int r)
	{
    	// Find sizes of two subarrays to be merged
    	int n1 = m - l + 1;
    	int n2 = r - m;

    	/* Create temp arrays */
    	int L[] = new int [n1];
    	int R[] = new int [n2];

    	/*Copy data to temp arrays*/
    	for (int i=0; i<n1; ++i)
        	L[i] = arr[l + i];
    	for (int j=0; j<n2; ++j)
    		R[j] = arr[m + 1+ j];


    	/* Merge the temp arrays */

    	// Initial indexes of first and second subarrays
    	int i = 0, j = 0;

    	// Initial index of merged subarray array
    	int k = l;
    	while (i < n1 && j < n2)
    	{
        	if (L[i] <= R[j])
        	{
            	arr[k] = L[i];
            	i++;
        	}
        	else
        	{
            	arr[k] = R[j];
            	j++;
        	}
        	k++;
    	}

    	/* Copy remaining elements of L[] if any */
    	while (i < n1)
    	{
        	arr[k] = L[i];
        	i++;
        	k++;
    	}

    	/* Copy remaining elements of R[] if any */
    	while (j < n2)
    	{
        	arr[k] = R[j];
        	j++;
        	k++;
    	}
	}

// Main function that sorts arr[l..r] using
// merge()
	static int Mergesort(int arr[], int l, int r,int k)
	{
		if (l < r)
		{
			// Find the middle point
			int m = (l+r)/2;
			counter++;
			// Sort first and second halves
			Mergesort(arr, l, m,k);
			Mergesort(arr , m+1, r,k);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
		return arr[k];
	}
	
	
	public static int QuickSelect(int[] array, int left, int right, int n) {
		if (left == right) { // If the list contains only one element,
			return array[left]; // return that element
		}
		
		// select a pivotIndex between left and right
		int pivotIndex = left;
		pivotIndex = partition(array, left, right, pivotIndex);
		// The pivot is in its final sorted position
		if (n == pivotIndex) {
			return array[n];
		} else if (n < pivotIndex) {
			return QuickSelect(array, left, pivotIndex - 1, n);
		} else {
			return QuickSelect(array, pivotIndex + 1, right, n);
		}
	}
	
	private static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right); // move pivot to end
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			counter++;
			if(array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex); // Move pivot to its final place
		return storeIndex;
	}
	
	private static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	

	public static void recQuickSort(int[] intArray, int left, int right,int k) {
	    int size = right - left + 1;
	    if (size <= 3){
	    	manualSort(intArray, left, right);counter++;
	    }
	    else {
	    	counter++;
	      int median = medianOf3(intArray, left, right);
	      if(median==intArray[k]){
	    	  counter++;
	    	  return;
	      }
	      int partition = partitionIt(intArray, left, right, median);
	      recQuickSort(intArray, left, partition - 1,k);
	      recQuickSort(intArray, partition + 1, right,k);
	    }
	  }

	  public static int medianOf3(int[] intArray, int left, int right) {
	    int center = (left + right) / 2;

	    if (intArray[left] > intArray[center]){
	    	swap(intArray, left, center);counter++;
	    }
	    if (intArray[left] > intArray[right]){
	    	swap(intArray, left, right);counter++;
	    }
	    if (intArray[center] > intArray[right]){
	    	swap(intArray, center, right);counter++;
	    }
	    swap(intArray, center, right - 1);
	    return intArray[right - 1];
	  }

	  

	  public static int partitionIt(int[] intArray, int left, int right, int pivot) {
	    int leftPtr = left;
	    int rightPtr = right - 1;

	    while (true) {
	      while (intArray[++leftPtr] < pivot)
	        ;
	      while (intArray[--rightPtr] > pivot)
	        ;
	      if (leftPtr >= rightPtr)
	        break;
	      else
	        swap(intArray, leftPtr, rightPtr);
	    }
	    swap(intArray, leftPtr, right - 1);
	    return leftPtr;
	  }

	  public static void manualSort(int[] intArray, int left, int right) {
		  counter++;
		  int size = right - left + 1;
	    if (size <= 1){
	    	counter++;
	      return;
	    }
	    if (size == 2) {
	      if (intArray[left] > intArray[right])
	        swap(intArray, left, right);counter++;
	      return;
	    } else {
	    	counter++;
	      if (intArray[left] > intArray[right - 1])
	        swap(intArray, left, right - 1);
	      if (intArray[left] > intArray[right])counter++;
	        swap(intArray, left, right);
	      if (intArray[right - 1] > intArray[right])counter++;
	        swap(intArray, right - 1, right);
	    }
	  }

	 
}
