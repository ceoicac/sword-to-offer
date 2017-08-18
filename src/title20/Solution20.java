package title20;

/**
 * 题目：顺时针打印矩阵
 * 
 * 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;
public class Solution20 {
	ArrayList<Integer> ret = new ArrayList<Integer>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
           return ret;
       }
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while(cols > start * 2 && rows > start * 2){
        	PrintMatrixInCircle(matrix,cols,rows,start);
        	++start;
        }
        return ret;
    }
    public void PrintMatrixInCircle(int[][] matrix,int cols,int rows,int start){
    	int endX = cols - 1 - start;
    	int endY = rows - 1 - start;
    	for(int i = start; i <= endX;++i){
    		ret.add(matrix[start][i]);
    	}
    	if(start < endY){
    		for(int i = start + 1;i <= endY;++i){
        		ret.add(matrix[i][endX]);
        	}
    	}
    	if(start < endX && start < endY){
    		for(int i = endX - 1;i >= start; --i){
    			ret.add(matrix[endY][i]);
    		}
    	}
    	if(start < endX && start < endY - 1){
    		for(int i = endY - 1; i >= start + 1; --i){
    			ret.add(matrix[i][start]);
    		}
    	}
    }
}