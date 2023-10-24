package practice;

public class StringFormatter {
	
	
		public static void main(String args[]){
			
			StringFormatter sF = new StringFormatter();
			
			sF.reverse();
			
			String str = "my name is krishna";
		    String words[]=str.split("\\s");  
		    String capitalizeWord="";  
		    for(String w:words){  
		        String first=w.substring(0,1);  
		        String afterfirst=w.substring(1);  
		        capitalizeWord += first.toUpperCase()+afterfirst+" ";  
		    }  
		    
		    System.out.println(capitalizeWord);
		    
		}  
		
		public void reverse() {
			
			StringBuffer sb = new StringBuffer("krishna");
			
			sb.reverse();
			
			System.out.println(sb);
		}
	 

}
