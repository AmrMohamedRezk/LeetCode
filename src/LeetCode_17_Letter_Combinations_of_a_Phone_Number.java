import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_17_Letter_Combinations_of_a_Phone_Number {
	   public List<String> letterCombinations(String digits) {
	        HashMap<Character,char []> map = new HashMap<Character, char[]>();
	        map.put('2', new char[]{'a','b','c'});
	        map.put('3', new char[]{'d','e','f'});
	        map.put('4', new char[]{'g','h','i'});
	        map.put('5', new char[]{'j','k','l'});
	        map.put('6', new char[]{'m','n','o'});
	        map.put('7', new char[]{'p','q','r','s'});
	        map.put('8', new char[]{'t','u','v'});
	        map.put('9', new char[]{'w','x','y','z'});
	        List<String> result = new ArrayList<String>();
	        letterCombinations(digits, 0, "", result,map);
	        return result;
	    }
	    
	    private void letterCombinations(String digits,int index,String current,List<String> result,HashMap<Character,char []> map){
	    	if(index == digits.length())
	    	{
	    		result.add(current);
	    		return;
	    	}
	    	char currentDigit = digits.charAt(index);
	    	for(char c: map.get(currentDigit)){
	    		letterCombinations(digits, index+1, current+c, result, map);
	    	}
	    }	
	    
}
