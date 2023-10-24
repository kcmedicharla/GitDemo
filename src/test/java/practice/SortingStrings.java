package practice;

import java.util.Arrays;
import java.util.Collections;

public class SortingStrings {

	public void NaturalOrder() {

		String[] arr = new String[] {"kasti","malli","kisti","rajiv","pandu","malli"};

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

	}

	public void DecendingOrder() {

		String[] arr = new String[] {"kasti","malli","kisti","rajiv","pandu","malli"};

		Arrays.sort(arr, Collections.reverseOrder());

		System.out.println(Arrays.toString(arr));	

	}

	public static void main(String args[]) {

		SortingStrings sS = new SortingStrings();

		sS.NaturalOrder();

		sS.DecendingOrder();

	}
}


