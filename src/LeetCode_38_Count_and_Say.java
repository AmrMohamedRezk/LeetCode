
public class LeetCode_38_Count_and_Say {

    public static String countAndSay(int n) {
        String value = "1";
        if(n==1)
            return value;
        StringBuilder sb =null;
        for(int i=0;i<n-1;i++){
        	sb = new StringBuilder();
        	int currentCounter = 1;
        	int j=0;
        	for(j=1;j<value.length();j++){
        		if(value.charAt(j)!=value.charAt(j-1)){
        			sb.append(currentCounter);
        			sb.append(value.charAt(j-1));
        			currentCounter = 1;
        		}else{
        			currentCounter++;
        		}
        	}
        	sb.append(currentCounter);
        	sb.append(value.charAt(j-1));
        	value = sb.toString();
        }
    	return sb.toString();
    }
}
