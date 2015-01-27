import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode_56_Merge_Intervals {
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
    public static List<Interval> merge(List<Interval> intervals) {  
    	List<Interval> result = new ArrayList<Interval>();
    	if(intervals==null || intervals.size()==0)
    		return result;
    	Collections.sort(intervals,new Comparator<Interval>() {
    		@Override
    		public int compare(Interval o1, Interval o2) {
    			return o1.start-o2.start;
    		}
    	});
    	Interval current = intervals.get(0);
    	for(int i=1;i<intervals.size();i++)
    	{
    		if(intersect(current, intervals.get(i))){
    			current = mergeIntervals(current, intervals.get(i));
    		}else{
    			result.add(current);
    			current = intervals.get(i);
    		}
    	}
    	result.add(current);
        return result;
    }
    
    private static boolean intersect(Interval first,Interval second){
    	if(first.end >= second.start && first.start <= second.end)
    		return true;
    	else
    		return false;
    }
    private static Interval mergeIntervals(Interval first,Interval second){
    	Interval merged = new Interval();
    	merged.start = Math.min(first.start, second.start);
    	merged.end = Math.max(first.end, second.end);
    	return merged;
    }
    
    public static void main(String[] args) {
		Interval first = new Interval(1, 5);
		Interval second = new Interval(2, 7);
		Interval third = new Interval(3, 10);
		Interval fourth = new Interval(4, 18);
		List<Interval> test = new ArrayList<Interval>();
		test.add(first);
		test.add(second);
		test.add(third);
		test.add(fourth);
		merge(test);
	}
}
