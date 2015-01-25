
public class LeetCode_Roman_To_Integer {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int num = 0;
        int priority = -1;
        int temp = 0;
        for(char c : s.toCharArray()){
        	if(priority(c)<=priority||priority==-1) {
        		num+=temp;
        		priority = priority(c);
        	}else{
        		num -=temp;
        	}
        	temp=romanMap.get(c);
        }
       num+=temp;
        return num;
    }
    private int priority(char c){
    	if(c=='I')
    		return 0;
    	if(c=='V')
    		return 1;
    	if(c=='X')
    		return 2;
    	if(c=='L')
    		return 3;
    	if(c=='C')
    		return 4;
    	if(c=='D')
    		return 5;
    	if(c=='M')
    		return 6;
    	return -1;
    }

}
