
public class LeetCode_44_Wildcard_Matching {
	public static boolean isMatch(String s, String p) {
		int sIndex = 0;
		int pIndex = 0;
		int sStar = -1;
		int pStar = -1;
		while(sIndex<s.length()){
			if(pIndex<p.length()&&p.charAt(pIndex)=='*'){
				sStar = sIndex;
				pStar = pIndex;
				pIndex++;
				continue;
			}
			if(pIndex<p.length()&&(p.charAt(pIndex)=='?'||s.charAt(sIndex)==p.charAt(pIndex)))
			{
				sIndex++;
				pIndex++;
				continue;
			}
			if(pStar!=-1){
				pIndex = pStar+1;
				sIndex=sStar+1;
				sStar++;
				continue;
			}
			return false;
		}
		while(pIndex<p.length()&&p.charAt(pIndex)=='*')
			pIndex++;
		return pIndex==p.length();
	}

	public static boolean isMatch2(String s, String p) {
		return isMatch2(s,0,p,0);
	}
	public static boolean isMatch2(String s, int index1,String p,int index2){
		if(index1==s.length()&&index2==p.length())
			return true;
		if(index1<s.length()&&index2<p.length()&&p.charAt(index2)!='*'){
			// case ?
			if(p.charAt(index2)=='?')
				return isMatch2(s, index1+1, p, index2+1);
			if(s.charAt(index1)==p.charAt(index2))
				return isMatch2(s, index1+1, p, index2+1);
		}else if(index2<p.length()){
			// case *
			//match nothing
			int i = 0;
			while(index1+i<=s.length()){
				if(isMatch2(s, index1+i, p, index2+1))
					return true;
				i++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("c","*?*"));
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa","*"));
		System.out.println(isMatch("aa","a*"));
		System.out.println(isMatch("ab","a?"));
		System.out.println(isMatch("aab","c*a*b"));

	}
}
