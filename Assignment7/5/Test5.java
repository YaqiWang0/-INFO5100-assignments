package Assignment7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test5 {

	@Test
	void test() {
		int[] num1= {1,3,5};
		int[] num2= {2,8};
		double res=3;
		Ass5 ass5=new Ass5();
		assertEquals(res, ass5.findMedianSortedArrays(num1, num2));
	}

}
