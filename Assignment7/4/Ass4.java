package Assignment7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ass4 {
	
public static void main(String[] args) {
	Interval[] test=new Interval[4];
	test[1]=new Interval(1,3);
	test[2]=new Interval(2,6);
	test[3]=new Interval(15,18);
	test[0]=new Interval(8,10);
	
	List<Interval> test1=new ArrayList<>();
	test1.add(test[0]);
	test1.add(test[1]);
	test1.add(test[2]);
	test1.add(test[3]);
	
	
	List<Interval> res=merge(test1);
	for(Interval a:res) {
		System.out.println(a.start+""+"  "+a.end+"");
	}
	
}
	 public static  List<Interval> merge(List<Interval> intervals) {
		 intervals.sort(new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					// TODO Auto-generated method stub
					return o1.start-o2.start;
				}
		    	 
		    	   
			});
		       List<Interval> res=new ArrayList<>();
		       if(intervals.size()==0)
		    	   return res;
		       Interval temp=intervals.get(0);
		       for(int i=1;i<intervals.size();i++){
		    	   if(intervals.get(i).start<=temp.end)
		    		   temp.end=Math.max(temp.end,intervals.get(i).end);
		    	   else {
		    		   res.add(temp);
		    		   temp=intervals.get(i);
		    	   }
		       }
	       
		    	   res.add(temp);
		       return res;
}
}
 class Interval{
	   int start;
  int end;
		 Interval() { start = 0; end = 0; }
	  Interval(int s, int e) { start = s; end = e; }
		  }
	 
