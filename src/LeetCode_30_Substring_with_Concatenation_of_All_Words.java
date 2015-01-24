import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_30_Substring_with_Concatenation_of_All_Words {
	public static List<Integer> findSubstring(String S, String[] L) {
		if (S == null || L == null || L.length == 0)
			return null;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int totalCharacter = L[0].length() * L.length;
		int wordLength = L[0].length();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i <= S.length() - totalCharacter;) {
			map.clear();
			resetMap(map, L);
			int counter = doCheck(i, wordLength, L.length, S, map);
			if (counter == L.length) {
				result.add(i);
			} 
				i++;
		}
		return result;
	}

	private static void resetMap(HashMap<String, Integer> map, String[] array) {
		for (String s : array) {
			if (map.containsKey(s))
				map.put(s, map.get(s) + 1);
			else
				map.put(s, 1);
		}
	}

	private static int doCheck(int i, int wordLength, int max, String s,
			HashMap<String, Integer> map) {
		int result = 0;
		int currentIndex = i;
		String currentSubstring = s.substring(currentIndex, currentIndex
				+ wordLength);
		while (currentIndex + wordLength <= s.length()
				&& map.containsKey(currentSubstring)
				&& map.get(currentSubstring) > 0) {
			result++;
			if (result == max)
				break;
			map.put(currentSubstring, map.get(currentSubstring) - 1);
			currentIndex += wordLength;
			currentSubstring = s.substring(currentIndex, currentIndex
					+ wordLength);
		}
		return result;
	}

	public static void main(String[] args) {
//		String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//		findSubstring(s, new String[] { "dhvf", "sind", "ffsl", "yekr", "zwzq",
//				"kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo",
//				"gdcj", "lnle", "sefg", "vimw", "bxcb" });
		 findSubstring("aaaaaaaa", new String[] { "aa", "aa","aa" });
	}

}
