package title65;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目：滑动窗口的最大值
 * 
 * 题目描述： 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 *        那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， 
 *        {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

public class Solution65 {
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(num == null || size < 0 || size > num.length){
            return result;
        }
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for(int i = 0;i < size;++i){
            while(!ll.isEmpty() && num[i] >= num[ll.getLast()]){
                ll.removeLast();
            }
            ll.addLast(i);
        }
        for(int i = size ; i < num.length;++i){
            result.add(num[ll.getFirst()]);
            while(!ll.isEmpty() && num[i] >= num[ll.getLast()]){
                ll.removeLast();
            }
            if(!ll.isEmpty() && (i - size) >= ll.getFirst()){
                ll.removeFirst();
            }
            ll.addLast(i);
        }
        //System.out.println(ll.getFirst());
        //System.out.println(num[ll.getFirst()]);
        result.add(num[ll.getFirst()]);
        return result;
    }
}
