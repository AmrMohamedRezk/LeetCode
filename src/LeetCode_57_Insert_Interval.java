import java.util.ArrayList;
import java.util.List;


public class LeetCode_57_Insert_Interval {
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

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0)
			return result;
		Interval current =null;
		int start = 0;
		boolean newProcessed = false;
		if(intervals.get(0).start<newInterval.start){
			start = 1;
			current = intervals.get(0);
		}else{
			start = 0;
			current = newInterval;
			newProcessed=true;
		}
		for (int i = start; i < intervals.size();) {
			Interval next = null;
			if(!newProcessed&&intervals.get(i).start > newInterval.start){
				next = newInterval;
				newProcessed=true;
			}else{
				next = intervals.get(i++);
			}
			if (intersect(current, next)) {
				current = merge(current, next);
			} else {
				result.add(current);
				current = next;
			}
		}
		if(!newProcessed){
			if(intersect(current, newInterval))
				result.add(merge(current, newInterval));
			else
			{
				result.add(current);
				result.add(newInterval);
			}
		}else
			result.add(current);
		return result;
	}

	private static boolean intersect(Interval first, Interval second) {
		return first.end >= second.start && first.start <= second.end;
	}

	private static Interval merge(Interval first, Interval second) {
		return new Interval(Math.min(first.start, second.start), Math.max(
				first.end, second.end));
	}
	public static void main(String[] args) {
		Interval first = new Interval(1, 5);
		Interval second = new Interval(2, 7);
//		Interval third = new Interval(6, 7);
//		Interval fourth = new Interval(8, 10);
//		Interval fifth = new Interval(12, 16);
//		Interval sixth = new Interval(4, 9);
		List<Interval> test = new ArrayList<Interval>();
		test.add(first);
//		test.add(second);
//		test.add(third);
//		test.add(fourth);
//		test.add(fifth);
		insert(test,second);

	}
}
