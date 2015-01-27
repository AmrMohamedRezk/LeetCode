import java.util.StringTokenizer;


public class LeetCode_165_Compare_Version_Numbers {
    public static int compareVersion(String version1, String version2) {
    	StringTokenizer st1 = new StringTokenizer(version1,".");
    	StringTokenizer st2 = new StringTokenizer(version2,".");
    	while(st1.hasMoreTokens() && st2.hasMoreTokens()){
    		int first = Integer.valueOf(st1.nextToken());
    		int second = Integer.valueOf(st2.nextToken());
    		if(first>second){
    			return 1;
    		}else if(second>first){
    			return -1;
    		}
    	}
    	if(!st1.hasMoreTokens()&&!st2.hasMoreTokens())
    		return 0;
    	while(st1.hasMoreTokens()){
    		if(Integer.valueOf(st1.nextToken())!=0)
    			return 1;
    	}
    	while(st2.hasMoreTokens()){
    		if(Integer.valueOf(st2.nextToken())!=0)
    			return -1;
    		
    	}
    	return 0;
    }
    public static void main(String[] args) {
		System.out.println(compareVersion("1","1.1"));
	}

}
