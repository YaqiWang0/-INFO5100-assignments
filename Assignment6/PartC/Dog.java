package Assignment6;

import java.util.Date;

import org.junit.platform.commons.util.ToStringBuilder;
class datenotmatch extends ArrayIndexOutOfBoundsException {

}
public class Dog extends Pet implements Boardable {

	private String size;
	private Date BoardingStartDate;
	private Date BoardingEndDate;
	
	public Dog (String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size=size;
	}
	
	public String getSize() {
		return size;
	}
	
	public String toString() {
		String res="DOG:\n";
		res=getPetName()+" owned by "+getOwnerName()+"\n";
		res=res+"Color:"+getColor()+"\n";
		res=res+"Sex:"+getSex()+"\n";
		res=res+"Size:"+getSize();
		return res;
	}
	@Override
	public void setBoardStart(int month, int day, int year) throws datenotmatch{
		// TODO Auto-generated method stub
		datenotmatch a=new datenotmatch();
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

	@Override
	public void setBoardEnd(int month, int day, int year) throws datenotmatch{
		datenotmatch a=new datenotmatch();
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

	@Override
	public boolean boarding(int month, int day, int year) throws datenotmatch {
		// TODO Auto-generated method stub
		datenotmatch a=new datenotmatch();
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


