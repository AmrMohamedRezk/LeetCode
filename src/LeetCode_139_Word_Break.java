import java.util.Set;


public class LeetCode_139_Word_Break {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true; 
        for(int i=0; i<s.length(); i++){
            if(!canBreak[i]) 
                continue; 
            for(String currentWord: dict){
                int len = currentWord.length();
                int end = i + len;
                if(end > s.length())
                    continue;
                if(canBreak[end]) continue;
                if(s.substring(i, end).equals(currentWord)){
                    canBreak[end] = true;
                }
            }
        }
        return canBreak[s.length()];
    }
}
