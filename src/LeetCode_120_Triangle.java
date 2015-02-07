import java.util.ArrayList;
import java.util.List;


public class LeetCode_120_Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
    	for(int i=triangle.size()-2;i>=0;i--){
    		for(int j=0;j<triangle.get(i).size();j++){
    			triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
    		}
    	}
    	return triangle.get(0).get(0);
    }

	public static void main(String[] args) {
		List<Integer> levelOne = new ArrayList<Integer>();
		levelOne.add(2);
		
		List<Integer> levelTwo = new ArrayList<Integer>();
		levelTwo.add(3);
		levelTwo.add(4);
		
		List<Integer> levelThree = new ArrayList<Integer>();
		levelThree.add(6);
		levelThree.add(5);
		levelThree.add(7);
		
		List<Integer> levelFour = new ArrayList<Integer>();
		levelFour.add(4);
		levelFour.add(1);
		levelFour.add(8);
		levelFour.add(3);
			
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(levelOne);
		triangle.add(levelTwo);
		triangle.add(levelThree);
		triangle.add(levelFour);
		
		System.out.println(minimumTotal(triangle));
	}
}
