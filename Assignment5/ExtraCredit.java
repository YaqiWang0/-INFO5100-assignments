package Assignment5;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ExtraCredit {

	@Test
	public void test() {
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		int[] res1= {1,2,3,6,9,8,7,4,5};
		List<Integer> res=new ArrayList<>();
		res.add(1);
		res.add(2);
		res.add(3);
		res.add(6);
		res.add(9);
		res.add(8);
		res.add(7);
		res.add(4);
		res.add(5);
		assertEquals(spiralOrder(matrix), res);
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		 //write your code here
		  List<Integer> res=new ArrayList<>();
			if(matrix == null || matrix.length == 0)
		            return res;    
			int size=matrix.length*matrix[0].length;
			int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
			while(res.size()<size) {
				for(int j=left;j<=right;j++ ) {
					res.add(matrix[top][j]);
				}
				top++;
				if(res.size()<size)
				{for(int j=top;j<=bottom;j++) {
					res.add(matrix[j][right]);
				}
				right--;
				}
				if(res.size()<size) {
				for(int j=right;j>=left;j--) {
					res.add(matrix[bottom][j]);
				
				}
				bottom--;
				}
				if(res.size()<size) {
				for(int j=bottom;j>=top;j--) {
					res.add(matrix[j][left]);
				}
				left++;
				}
			}
	       
		return res;
}

}
