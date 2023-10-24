package practice;

public class FindingDuplicateNumbers {
	
	
	public static void main(String args[]) {
	
		int[] arr = new int[] {1,2,3,8,2,8,7};
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[i]==arr[j]) {
					
					System.out.println("duplicate element: "+arr[i]+" found at the position: "+ j);
				}
			}
		}
	}
	

}
