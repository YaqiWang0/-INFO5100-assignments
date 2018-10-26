package Assignment6;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.ArrayList;

import org.junit.platform.commons.util.ToStringBuilder;

public class Mreview implements Comparable<Mreview> {
	
	 private String title;   // title of the movie
	 private ArrayList<Integer> ratings; // list of ratings stored in a Store object

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Mreview test=new Mreview("Kill Bill");
		test.addRating(4);
		test.addRating(6);
		test.addRating(8);
		System.out.println(test);
		
	}
	public Mreview() {
		title="";
		ratings=new ArrayList<>();
	}
	public Mreview(java.lang.String ttl) {
		title=ttl;
		ratings=new ArrayList<>();
	}
	public Mreview(java.lang.String ttl,int firstRating) {
		title=ttl;
		ratings=new ArrayList<>();
		ratings.add(firstRating);
	}
	
	public java.lang.String getTitle(){
		return title;
	}
	
	public  void addRating(int r) {
		ratings.add(r);
	}
	
	public double aveRating() {
		int sum=0;
		for(int c:ratings) {
			sum=sum+c;
		}
		double a=sum/ratings.size();
		return a;
	}
	
	public int numRatings() {
		return ratings.size();
	}
	
	public boolean equals(java.lang.Object obj) {
		Mreview compare=(Mreview) obj;
		return title.equals(compare.title);
	}
	
	public java.lang.String toString(){
		String s="";
	s=s+title+",average "+String.valueOf(aveRating())+" out of "+String.valueOf(numRatings())+" ratings";
	return s;
	}
	
	@Override
	public int compareTo(Mreview o) {
		// TODO Auto-generated method stub
		return title.compareTo(o.title);
	}

}
