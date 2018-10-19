package Assignment5;

import java.math.BigDecimal;

public class Cookie extends DessertItem {

	private int number;
	private int  priceperdozen;
	
	public Cookie() {
		// TODO Auto-generated constructor stub
	}

	public Cookie(String name,int number,int priceperdozen) {
		super(name);
		this.number=number;
		this.priceperdozen=priceperdozen;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		float temp=(float)number/12*priceperdozen;
		BigDecimal b0 = new BigDecimal(temp);
		int res=b0.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		return res;
	}
	public String toString() {
		DessertShoppe cons=new DessertShoppe();
		return String.valueOf(number)+" @ "+cons.cents2dollarsAndCentsmethod(priceperdozen)+" /dz.";
	}

}
