import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class LeetCode_71_Simplify_Path {
    public static String simplifyPath(String path) {
     StringBuilder sb = new StringBuilder();
     sb.append('/');
     StringTokenizer st = new StringTokenizer(path,"/");
     Deque<String> directories = new LinkedList<String>();
     while(st.hasMoreTokens()){
    	 String currentDirectory = st.nextToken();
    	 if(currentDirectory!=null && !currentDirectory.equals("")){
    		 if(currentDirectory.equals("."))
    			 continue;
    		 if(currentDirectory.equals("..")){
    			 if(!directories.isEmpty())
    				 directories.pop();
    			 continue;
    		 }
    		 directories.push(currentDirectory);
    	 }
     }
     while(!directories.isEmpty()){
    	 sb.append(directories.pollLast());
    	 if(!directories.isEmpty())
    		 sb.append('/');
     }
     return sb.toString();
    }
    public static void main(String[] args) {
		simplifyPath("/../");
	}
}
