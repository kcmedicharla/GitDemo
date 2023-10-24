package practice;

import java.util.Arrays;

public class SortingNumbersWithLoop {
	
	public void NaturalOrder() {
		
		int[] arr = new int[] {1,2,3,8,2,8,7};
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=i+1;j<arr.length;j++) {
				
				int tmp=0;
				
				if(arr[i]>arr[j]) {
					
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void DecendingOrder() {
		
		int[] arr = new int[] {1,2,3,8,2,8,7};
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=i+1;j<arr.length;j++) {
				
				int tmp=0;
				
				if(arr[i]<arr[j]) {
					
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String args[]) {
		
		SortingNumbersWithLoop sNL = new SortingNumbersWithLoop();
		
		sNL.NaturalOrder();
		
		sNL.DecendingOrder();
		
	}

}
