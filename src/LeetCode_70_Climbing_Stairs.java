
public class LeetCode_70_Climbing_Stairs {
    public static int climbStairs(int n) {
     if(n<=0)
    	 return 0;
     int first = 0;
     int second = 1;
     for(int i=0;i<n;i++){
    	 int result = first+second;
    	 first = second;
    	 second = result;
     }
     return second;
    }
    public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}
}
