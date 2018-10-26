package Assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartB {

	@Test
	void test() {
		CheckingAccount test=new CheckingAccount("Emma", "Wang", 200);
		assertEquals(test.DebitTransaction(110), 80);
		assertEquals(test.CreditTransaction(5), 75);
		assertEquals(test.CreditTransaction(100),175);
		
	}

}
