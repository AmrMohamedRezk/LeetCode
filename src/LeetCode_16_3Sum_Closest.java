import java.util.Arrays;

public class LeetCode_16_3Sum_Closest {

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for(int i=0;i<num.length;i++){
			int start = i+1;
			int end = num.length-1;
			while(start<end){
				int total = num[i]+num[start]+num[end];
				if(total==target)
					return total;
				else if(total>target){
				    if((total-target)<min){
				        min = total-target;
				        answer = total;
				    }
					end--;
				}else{
				    if((target-total)<min){
				        min = target-total;
				        answer = total;
				    }
					start++;
				}
			}
		}
		return answer;
	}
}
