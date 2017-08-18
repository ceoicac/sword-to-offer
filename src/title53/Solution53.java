package title53;

/**
 * 题目：正则表达式匹配
 * 
 * 题目描述：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 */

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