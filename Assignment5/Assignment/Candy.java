package Assignment5;

import java.math.BigDecimal;

public class Candy extends DessertItem {

	private double weight;
	private int priceperpound;



	
	public Candy(String name, double d, int priceperpound) {
		// TODO Auto-generated constructor stub
		super(name);
		this.weight=d;
		this.priceperpound=priceperpound;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		float temp=(float)weight*priceperpound;
		BigDecimal b0 = new BigDecimal(temp);
		int res=b0.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		return res;
		
	}
	public String toString() {
		DessertShoppe cons=new DessertShoppe();
		return String.valueOf(weight)+" lbs. @ "+cons.cents2dollarsAndCentsmethod(priceperpound)+" /lb.";
	}

}
