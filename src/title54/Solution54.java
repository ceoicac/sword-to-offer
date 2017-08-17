package title54;

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