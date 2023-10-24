package practice;

public class FindingDuplicateStrings {
	
	
	public static void main(String args[]) {
	
		String[] arr = new String[] {"kisti","malli","Kisti","rajiv","pandu","malli"};
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[i].equalsIgnoreCase(arr[j])) {
					
					System.out.println("duplicate element: "+arr[i]+" found at the position: "+ j);
				}
			}
		}
	}
	

}
