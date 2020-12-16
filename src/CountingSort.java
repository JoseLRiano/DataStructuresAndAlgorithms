import java.util.*;

public class CountingSort {

	void sort(char arr[]) {
		int n = arr.length;
		
		// The outpot character array that will have sorted arr
		char output[] = new char[n];
		
		//Create a count array to store count of individual
		// charactes and initialize count array as 0
		int count[] = new int[256];
		for(int i = 0; i < 256; ++i) {
			count[i] = 0;
		}
		
		//store count of each character 
		for(int i =0; i < n; ++i) 
			++count[arr[i]];
		
		// Change count[i] so that count[i] now contains actual
		// position of this charater in output array
		for(int i = 1; i <= 255; ++i)
			count[i] += count[i -1];
		
		// Built the output character array 
		// to make it stable we are operating in reverse order
		for(int i = n-1; i >= 0; i--) {
			output[count[arr[i]] -1] = arr[i];
			--count[arr[i]];
		}
		
		//Copy the output array to arr, so that arr now
		// contains sorted characters
		for(int i =0; i < n; ++i) {
			arr[i] = output[i];
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingSort one = new CountingSort();
		
		char arr[] = {'g','e','e','k','s','f','o','r','g','e','e','k','s'};
		
		one.sort(arr);
		
		System.out.println("Sorted character array is ");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
