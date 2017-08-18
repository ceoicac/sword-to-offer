package title36;

/**
 * 题目：数组中的逆序对
 * 
 * 题目描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
 * 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 */

public class Solution36 {
    public int InversePairs(int [] array) {
        if(array == null || array.length < 0){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0;i < array.length;++i){
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length - 1);
        return count;
    }
    
    public int InversePairsCore(int[] array,int[] copy,int start,int end){
        if(start == end){
            copy[start] = array[start];
            return 0;
        }
        int length = (end - start)/2;
        int left = InversePairsCore(copy,array,start,start + length);
        int right = InversePairsCore(copy,array,start + length + 1,end);
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j > start + length){
            if(array[i] > array[j]){
                copy[indexCopy--] = array[i--];
                count += j - start - length;
                if(count > 1000000007){
                    count %= 1000000007;
                }
            }else{
                copy[indexCopy--] = array[j--];
            }
        }
        for(;i >= start;--i){
            copy[indexCopy--] = array[i];
        }
        for(;j >= start + length + 1;--j){
            copy[indexCopy--] = array[j];
        }
        return ((left + right) % 1000000007 + count % 1000000007);
        
    }
}  