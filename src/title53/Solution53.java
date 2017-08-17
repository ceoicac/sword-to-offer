package title53;

public class Solution53 {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
            return false;
        }
        return matchCore(str,pattern,0,0);
    }
    
    public boolean matchCore(char[] str,char[] pattern,int i,int j){
        if(i > str.length - 1 && j > pattern.length - 1){
            return true;
        }
        if(i <= str.length - 1 && j > pattern.length - 1){
            return false;
        }
        if(pattern.length - 1 > j+1 && pattern[j + 1] == '*'){
            if(pattern[j] == str[i] || (pattern[j] == '.' && i <= str.length - 1)){
                return matchCore(str,pattern,i+1,j+2) || matchCore(str,pattern,i+1,j) 
                    || matchCore(str,pattern,i,j+2);
            }else{
                return matchCore(str,pattern,i,j+2);
            }
        }
        if(str[i] == pattern[j] || (pattern[j] == '.' && i <= str.length - 1))
            return matchCore(str,pattern,i + 1,j + 1);
        return false;
    }
}