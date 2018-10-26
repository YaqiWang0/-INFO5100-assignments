package Assignment6;

import java.util.Scanner;
class notmatched extends ArrayIndexOutOfBoundsException {

}
public class Pet {
	private String PetName;
	private String OwnerName;
	private String Color;
	protected int sex;
	
	
	public static final int MALE=1;
	public static final int FEMALE=2;
	public static final int SPAYED=3;
	public static final int NEUTERED=4;
	
	public Pet (String name, String ownerName, String color) {
		this.PetName=name;
		this.OwnerName=ownerName;
		this.Color=color;
	}
	
	public String getPetName() {
		return PetName;
	}
	
	public String getOwnerName() {
		return OwnerName;
	}
	
	public String getColor() {
		return Color;
	}
	
	public void setSex(int sexid) throws notmatched{
			notmatched e=new notmatched();
				if (sexid<1||sexid>4) {
					System.out.println("Please enter a number between 1 and 4");
					throw e;
				}
				else
					sex=sexid;

			}
	
	public String getSex() {
		String res="";
		switch (sex) {
		case MALE:
			res= "MALE";
			break;
		case FEMALE:
			res="FEMALE";
			break;
		case SPAYED:
			res="SPAYED";
			break;
		case NEUTERED:
			res="NEUTERED";
			break;
		}
		return res;

		}
	public String toString() {
		String res="";
		res=PetName+" owned by "+OwnerName+"\n";
		res=res+"Color:"+Color+"\n";
		res=res+"Sex:"+getSex();
		return res;
		
		
	}
		
	}
	

	


