package Assignment5;

import org.junit.validator.PublicClassValidator;

public class DessertShoppe {

	private float taxrate;
	private String name;
	private int sizeofname;
	private int sizeofcost;
	
	DessertShoppe(){
		taxrate=(float) 0.1;
		name="M & M Dessert Shoppe";
		sizeofname=30;
		sizeofcost=10;
	}
	public String cents2dollarsAndCentsmethod(int cost) {
		return String.valueOf((float)cost/100);
	}
	public String getName() {
		return name;
	}
	public int getSizeofname(){
		return sizeofname;
	}
	public int getSizeofcost() {
		return sizeofcost;
	}
	public float getTaxrate() {
		return taxrate;
	}
	
}
