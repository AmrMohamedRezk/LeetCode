
public class LeetCode_69_Sqrt {
	public int sqrt(int x) {
		double start = 1;
		double result = start * start;
		do {
			start = (start + x / start) / 2.0;
			result = start * start;
		} while ((result - x) > 0.0001);
		return (int) start;
	}
}
