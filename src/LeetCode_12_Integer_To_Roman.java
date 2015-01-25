import java.util.HashMap;


public class LeetCode_12_Integer_To_Roman {
	public String intToRoman(int num) {
		HashMap<Integer, String> romanMap = new HashMap<Integer, String>();
		romanMap.put(1000, "M");
		romanMap.put(900, "CM");
		romanMap.put(500, "D");
		romanMap.put(400, "CD");
		romanMap.put(100, "C");
		romanMap.put(90, "XC");
		romanMap.put(50, "L");
		romanMap.put(40, "XL");
		romanMap.put(10, "X");
		romanMap.put(9, "IX");
		romanMap.put(5, "V");
		romanMap.put(4, "IV");
		romanMap.put(1, "I");
		int [] array = new int[] {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			int nearestIndex = findNearest(array,num);
			sb.append(romanMap.get(array[nearestIndex]));
			num-=array[nearestIndex];
		}
		return sb.toString();
	}

	private int findNearest(int[] array, int num) {
		int start = 0;
		int end = array.length-1;
		while(start<=end){
			int mid = start+(end-start)/2;
			if(start == end)
				return start;
			if(array[mid]<=num && array[mid+1]>num)
				return mid;
			else if(array[mid]<num)
				start =mid+1;
			else 
				end = mid-1;
		}
		return -1;
	}

}
