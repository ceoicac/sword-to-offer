package title54;

/**
 * 题目：表示数值的字符串
 * 
 * 题目描述：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123",
 * "3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 */

public class Solution54 {
    public int i = 0;
    public boolean isNumeric(char[] str) {
        if(str == null){
            return false;
        }
        if(str[i] == '+' || str[i] == '-'){
            ++i;
        }
        if(i > str.length - 1){
            return false;
        }
        boolean numeric = true;
        scanDigits(str);
        if(i < str.length - 1){
            if(str[i] == '.'){
                i++;
                scanDigits(str);
                if(i <= (str.length -1) && (str[i] == 'e' || str[i] == 'E')){
                    numeric= isExponential(str);
                }
            }else if(str[i] == 'e' || str[i] == 'E'){
                numeric = isExponential(str);
            }else{
                numeric = false;
            }
        }
        return numeric && (i > str.length - 1);
    }
    public void scanDigits(char[] str){
        while(i <= (str.length -1) && str[i] >= '0' && str[i] <= '9'){
            i++;
        }
    }
    public boolean isExponential(char[] str){
        if(str[i] != 'e' && str[i] != 'E'){
            return false;
        }
        ++i;
        if(str[i] == '+' || str[i] == '-')
            ++i;
        if(i > str.length - 1){
            return false;
        }
        scanDigits(str);
        return (i > str.length - 1) ? true : false;
    }
}