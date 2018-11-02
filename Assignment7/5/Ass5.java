package Assignment7;

public class Ass5 {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	       // add your code here
		 int index1=0;
		 int index2=0;
		 int temp=0;
		 int pre=0;
		 while(index1+index2<(nums1.length+nums2.length)/2+1) {
			 pre=temp;
			 if(index1<nums1.length&&index2<nums2.length) {
			 if(nums1[index1]<nums2[index2]) {
				 
				 temp=nums1[index1];
				 index1++;
				 
			 }
			 else {
				 
				 temp=nums2[index2];
				 index2++;
				 }
		 }
			 else if(index1<nums1.length) {
				 
				 temp=nums1[index1];
				 index1++;
			 }
			 else {
				
				 temp=nums2[index2];
				 index2++;
			}
		 }
		 if((index1+index2-1)*2==nums1.length+nums2.length)

			return (double)(pre+temp)/2;
		 else
			 return temp;
		
	    }
}
