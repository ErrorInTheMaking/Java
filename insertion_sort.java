public class insertion_sort {
	public void insertionsort(int arr[]) {
		for(int i = 1; i < arr.length; ++i) {			//For loop from 1 to length
			int j = i;
			while(j > 0 && arr[j-1] > arr[j]) {		//Check if previous index is greater than current 
				int temp = arr[j];			//Swap
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				--j;					//Decrease j after swapping
			}
		}
	}
	
	public static void main(String[] args) {
		insertion_sort is = new insertion_sort();		//Make new object insertion_sort
		int arr[] = new int[10];
																	
		for(int i = 0;  i < arr.length; ++i)			//Fill array with random integers(0-99)
			arr[i] = (int)(Math.random()*100);
		
		System.out.print("Before insertion sort: ");
		for(int i = 0;  i < arr.length; ++i)			//Print before sorting
			System.out.print(arr[i] + " ");
		System.out.println();
			
		is.insertionsort(arr);					//Apply insertion sort
		
		System.out.print("After insertion sort: ");		//Print after sorting
		for(int i = 0;  i < arr.length; ++i)
			System.out.print(arr[i] + " ");
		
	}
}
