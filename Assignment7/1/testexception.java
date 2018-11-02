package Assignment7;

import javax.swing.DefaultBoundedRangeModel;

class MyIndexOutOfBoundException extends Exception{
	int lowerBound;
	int upperBound;
	int index;
	
	public MyIndexOutOfBoundException(int index) {
		// TODO Auto-generated constructor stub
		this.index=index;
		lowerBound=0;
		upperBound=10;
	}
	public String toString() {
		return "Error Message: Index: "+String.valueOf(index)+", but Lower bound: "+String.valueOf(lowerBound)+", Upper bound: "+String.valueOf(upperBound);
		
	}
	
	
}
public class testexception {
	public static void demo(int index)throws MyIndexOutOfBoundException {
		if(index<0||index>10) {
		
				throw new MyIndexOutOfBoundException(index);
			
		}
		
	}

	public static void main(String[] args) throws MyIndexOutOfBoundException{
		// TODO Auto-generated method stub
		demo(11);

	}

}
