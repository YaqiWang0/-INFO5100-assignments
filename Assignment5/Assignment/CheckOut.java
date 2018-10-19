package Assignment5;

import java.math.BigDecimal;
import java.util.Vector;

public class CheckOut {

	private Vector<DessertItem> dessert=new Vector<>();
	
	public CheckOut() {
	}
	
	
	public int numberOfItems() {
		return dessert.size();
	}
	public void enterItem(DessertItem item) {
		dessert.add(item);
	}
	public void clear() {
		dessert.clear();
	}
	public int totalCost() {
		int res=0;
		for(int i=0;i<dessert.size();i++) {
			res=res+dessert.get(i).getCost();
		}
		return res;
	}
	public int totalTax() {
		DessertShoppe constant=new DessertShoppe();
		float temp=totalCost()*constant.getTaxrate();
		BigDecimal b0 = new BigDecimal(temp);
		int res=b0.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		return res;
	}
	public String toString() {
		DessertShoppe cons=new DessertShoppe();
		String s="";
		s=s+heading(s, cons);
		    for(int i=0;i<dessert.size();i++) {
		    	
		    		String name=dessert.get(i).getName();
		    		if(dessert.get(i).toString()!=null)
		    		s=cut(dessert.get(i).toString(), s, cons)+"\n";
		    		s=cut(name, s, cons);
		    		s=s+String.format("%"+cons.getSizeofcost()+"s", cons.cents2dollarsAndCentsmethod(dessert.get(i).getCost()))+"\n";
		    	
		    }
		s=s+"\n"+String.format("%-"+cons.getSizeofname()+"s", "Tax")+String.format("%"+cons.getSizeofcost()+"s",cons.cents2dollarsAndCentsmethod(totalTax()))+"\n";   
		s=s+"\n"+String.format("%-"+cons.getSizeofname()+"s", "TotalCost")+String.format("%"+cons.getSizeofcost()+"s",cons.cents2dollarsAndCentsmethod(totalCost()))+"\n";   
		return s+"\n";
		//return String.format("%1$70s", raw);
		
	}
	
	
	public String heading(String res,DessertShoppe cons) {
		 String s = cons.getName();
	    byte[] b = s.getBytes();
	    byte[] c = new byte[cons.getSizeofname()+cons.getSizeofcost()];
	    for (int i = 0; i<c.length; i++) {
	    	if(i>=(cons.getSizeofcost()+cons.getSizeofname()-b.length)/2&&i<(cons.getSizeofcost()+cons.getSizeofname()-b.length)/2+b.length)
	    		c[i]=b[i-(cons.getSizeofcost()+cons.getSizeofname()-b.length)/2];
	    	else c[i]=' ';
	    }
	    res = res+"\n"+new String(c);
	    res=res+"\n";
	    for (int i = 0; i<c.length; i++) {
	    	if(i>=(cons.getSizeofcost()+cons.getSizeofname()-b.length)/2&&i<(cons.getSizeofcost()+cons.getSizeofname()-b.length)/2+b.length)
	    		c[i]='-';
	    	else c[i]=' ';
	    }
	    res = res+new String(c);
	    res=res+"\n"+"\n";
	    return res;
	}
	
	
	public String cut(String name,String s,DessertShoppe cons) {
		if (name==null)
		return s;
		while(name.length()>cons.getSizeofname()) {
			s=s+String.format("%-"+cons.getSizeofname()+"s",name.substring(0,cons.getSizeofname()+1))+"\n";
			name=name.substring(cons.getSizeofname(),name.length());
		}
		s=s+String.format("%-"+cons.getSizeofname()+"s",name);
		return s;
	}
}
