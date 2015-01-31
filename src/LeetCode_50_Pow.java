
public class LeetCode_50_Pow {
    public static double pow(double x, int n) {
    	if(n<0){
    		return calPow(1/x,-n);
    	}else
    		return calPow(x,n);
    }
    private static double calPow(double x, int n){
    	if(n==0)
    		return 1;
    	if(n==1)
    		return x;
    	double result = pow(x,n/2);
    	if(n%2==1)
    		return x*result*result;
    	else
    		return result*result;
    }
    public static void main(String[] args) {
	System.out.println(pow(34.00515, -3));	
	}
}
