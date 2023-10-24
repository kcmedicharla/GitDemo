package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindingDuplicatesInList {
	
	public void raw() {
		
		List<String> list = new ArrayList<String>();
		
		List<String> list1 = new ArrayList<String>();
		
		String [] arr = new String[] {"kisti", "malli", "rajiv", "kisti", "pandu", "kisti"};
		
		list.addAll(Arrays.asList(arr));
		
		list1.addAll(list);
		
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		
		for(String sSet: set) {
			
			list.remove(sSet);
		}
		
		for(String sList: list) {
			
			System.out.println(sList);
		}
	}
	
	public void usingContains() {
		
		List<String> list = new ArrayList<String>();
		
		List<String> dup = new ArrayList<String>();
		
		String [] arr = new String[] {"kisti", "malli", "rajiv", "kisti", "pandu", "kisti"};
		
		list.addAll(Arrays.asList(arr));
		
		Set<String> setN = new HashSet<String>();
		
		for(String sN : list) {
			
			if(setN.contains(sN)) {
				
				dup.add(sN);
				
			}else {
				
				setN.add(sN);
			}
		}
		
		//System.out.println(dup.toString());
		
		//Collections.sort(list);
		
		System.out.println(list.toString());
		
		list.sort(Collections.reverseOrder());
		
		System.out.println(list.toString());
	}
	
	public static void main(String args[]) {
		
		FindingDuplicatesInList fin = new FindingDuplicatesInList();
		
		fin.usingContains();
		
		//fin.raw();
		
	}

}
