
public class LeetCode_135_Candy {
	public static int candy(int[] ratings) {
		 int[] candies=new int[ratings.length];
	        // every child should has at least one candy
	        for (int i=0; i<candies.length; i++){
	            candies[i]=1;
	        }
	        // if child i has rating higher than i-1, which should 1 bigger than its left neighbour
	        for (int i=1; i<ratings.length; i++){
	            if (ratings[i]>ratings[i-1]){
	                candies[i]=candies[i-1]+1;
	            }
	        }
	        // if child i has rating higher than its right neighbour, but the candies array did not 
	        // represented this situation correctly, then correct it.
	        
	        for (int i=ratings.length-2; i>=0; i--){
	            if (ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]){
	                candies[i]=candies[i+1]+1;
	            }
	        }
	        
	        int total=0;
	        // calculate the total candies needed
	        for (int i=0; i<candies.length; i++){
	            total+=candies[i];
	        }
	        
	        return total;
	        }
	public static void main(String[] args) {
		System.out.println(candy(new int []{1,3,5}));
	}
}
