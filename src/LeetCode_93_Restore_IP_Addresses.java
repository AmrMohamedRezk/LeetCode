import java.util.ArrayList;
import java.util.List;

public class LeetCode_93_Restore_IP_Addresses {
	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		restoreIpAddresses(s, 0, 0, result, "");
		return result;
	}

	private static void restoreIpAddresses(String s, int start, int index,
			List<String> result, String current) {
		if (index == 3) {
			if(start<s.length()&&s.length()-start<=3&&Integer.valueOf(s.substring(start, s.length()))<=255){
			String ip = current + "." + Integer.valueOf(s.substring(start, s.length()));
				if(ip.length()==s.length()+3)
					result.add(ip);
				else
					return;
			}
			else
				return;
		} else {
			for (int i = start; i < s.length(); i++) {
				int currentNumber = Integer.valueOf(s.substring(start, i + 1));
				if (currentNumber <= 255) {
						String optional = (index==0) ? "":".";
						restoreIpAddresses(s, i + 1, index + 1, result, current
								+ optional + currentNumber);
					}
					else
						break;
			}
		}
	}
	public static void main(String[] args) {
		restoreIpAddresses("010010");
	}
}
