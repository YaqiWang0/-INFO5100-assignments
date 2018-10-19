package Assignment5;

import java.math.BigDecimal;

public class IceCream extends DessertItem {
	protected float cost;
	
	public IceCream(String name,float cost) {
		super(name);
		this.cost=cost;
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		float temp=cost;
		BigDecimal b0 = new BigDecimal(temp);
		int res=b0.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		return res;
		
	}
	public String toString() {
		return null;
	}

}
