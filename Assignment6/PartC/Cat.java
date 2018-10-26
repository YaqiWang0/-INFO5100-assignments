package Assignment6;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
class datenotmatched extends ArrayIndexOutOfBoundsException {

}
public class Cat extends Pet implements Boardable {

	private String hairLength;
	
	private Date BoardingStartDate=null;
	private Date BoardingEndDate=null;
	public Cat (String name, String ownerName, String color, String hairLength) {
		super(name, ownerName, color);
		this.hairLength=hairLength;
	}
	
	public String getHairLength() {
		return hairLength;
	}
	
	public String toString() {
		String res="CAT:\n";
		res=getPetName()+" owned by "+getOwnerName()+"\n";
		res=res+"Color:"+getColor()+"\n";
		res=res+"Sex:"+getSex()+"\n";
		res=res+"Hair:"+getHairLength();
		return res;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setBoardStart(int month, int day, int year) throws datenotmatched{
		// TODO Auto-generated method stub
		 datenotmatched a=new  datenotmatched();
		if(month<1||month>12) {
			System.out.println("month should between 1 to 12");
			throw a;
		}
		if(day<1||day>31) {
			System.out.println("day should between 1 to 31");
			throw a;
		}
			
		String y=String.valueOf(year);
		if(!y.matches("\\d{4}"))
		{
			System.out.println("year need to be a four digit number");
			throw a;
		}
			
		BoardingStartDate=new Date(year, month, day);
			

	}

	@SuppressWarnings("deprecation")
	@Override
	public void setBoardEnd(int month, int day, int year)throws datenotmatched {
		// TODO Auto-generated method stub
		 datenotmatched a=new  datenotmatched();
		if(month<1||month>12) {
			System.out.println("month should between 1 to 12");
			throw a;
		}
		if(day<1||day>31) {
			System.out.println("day should between 1 to 31");
			throw a;
		}
			
		String y=String.valueOf(year);
		if(!y.matches("\\d{4}"))
		{
			System.out.println("year need to be a four digit number");
			throw a;
		}
		BoardingEndDate=new Date(year, month, day);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean boarding(int month, int day, int year)throws datenotmatched {
		
		 datenotmatched a=new  datenotmatched();
		if(month<1||month>12) {
			System.out.println("month should between 1 to 12");
			throw a;
		}
		if(day<1||day>31) {
			System.out.println("day should between 1 to 31");
			throw a;
		}
			
		String y=String.valueOf(year);
		if(!y.matches("\\d{4}"))
		{
			System.out.println("year need to be a four digit number");
			throw a;
		}
		Date now=new Date(year, month, day);
		if(BoardingEndDate==null&&BoardingStartDate==null)
			return true;
		if(BoardingEndDate==null)
			return !now.before(BoardingStartDate);
		if(BoardingStartDate==null)
			return !now.after(BoardingEndDate);
		if(now.after(BoardingEndDate)==true||now.before(BoardingStartDate)==true)
			return false;
		return true;
	}

}
