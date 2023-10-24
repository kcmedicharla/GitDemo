package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SortingNumbers {
	
	public void NaturalOrder() {

		int[] arr = new int[] {1,2,3,8,2,8,7};

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

		/*
		for(int i=0;i<arr.length;i++) {

			System.out.println(arr[i]);
		}*/

	}
	
	public void DecendingOrder() {
		
		Integer[] arra = {1,2,3,8,4,9,7};
		
		Arrays.sort(arra, Collections.reverseOrder());
		
		System.out.println(Arrays.toString(arra));
	}

	public static void main(String args[]) {

		SortingNumbers sN = new SortingNumbers();
		
		sN.NaturalOrder();
		
		sN.DecendingOrder();
		
	}

}
