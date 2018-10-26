package Assignment6;

public class PartC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//test cat
		
		Cat miao=new Cat("dummy", "Emma", "white", "Short");
		//miao.setSex(7);
		//throws exception that Please enter a number between 1 and 4
		
		miao.setSex(2);
		System.out.println(miao);
		
		miao.setBoardStart(11, 21, 2018);
		miao.setBoardEnd(12, 26, 2018);
		System.out.println(miao.boarding(12, 1, 2018));//true;
		
		miao.setBoardStart(11, 21, 2018);
		miao.setBoardEnd(11, 26, 2018);
		System.out.println(miao.boarding(12, 1, 2018));//false;
		
		//miao.setBoardStart(11, 21, 201);throws exception that year need to be a four digit number;
		//miao.setBoardStart(13, 21, 2018);throws exception that month should between 1 to 12;
		//miao.setBoardStart(11, 56, 2018);throws exception that day should between 1 to 31
		miao.setBoardStart(11, 21, 2018);
		miao.setBoardEnd(12, 26, 2018);
		System.out.println(miao.boarding(12, 1, 2018));
//test dog		
		Dog puppy=new Dog("puff", "Emma", "black","Medium" );
		System.out.println(puppy);
		//dog is same as cat;and Pet's methods such as setsex has been tested above;
		
		
		
		
		
	
		
	}

}
