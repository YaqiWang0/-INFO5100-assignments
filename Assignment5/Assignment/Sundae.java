package Assignment5;

import java.math.BigDecimal;

import org.junit.experimental.theories.Theories;

public class Sundae extends IceCream {

	
	private String nameoftopping;
	private float costoftopping;
	public Sundae(String nameofIceCream, float costoficecream,String nameoftopping,float costoftopping) {
		super(nameofIceCream, costoficecream);
	
		this.costoftopping=costoftopping;
		this.nameoftopping=nameoftopping;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getCost() {
	
		// TODO Auto-generated method stub
		//float temp=this.cost+this.costoftopping;
		
		BigDecimal b0 = new BigDecimal(super.getCost()+costoftopping);
		int res=b0.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		return res;
	}
	public String toString() {
		return nameoftopping+" with";
	}

}
