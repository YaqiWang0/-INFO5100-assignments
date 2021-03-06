/**
 * Assignment for your lecture 2. Please finish all the questions under 'Assignment'
 * Please try to think the extra credit question. 
 * The deadline of this assignment is 09/21/2018 23:59 PST.
 * Please feel free to contact Amanda and Zane for any questions.
 */

public class Employee {
	 String name;
	    int age;
	    Gender gender;
	    double salary;// salary per month

	    // Constructor. Please set all the data in constructor.
	    public Employee(String name, int age, Gender gender, double salary) {
	    	this.name=name;
	    	this.age=age;
	    	this.gender=gender;
	    	this.salary=salary;
	    	//write your code here
	    }
	    
	    // Getter for `name`. Return the current `name` data
	    public String getName() {
	    		
	    	return name;//write your code here
	    }

	    // Setter for `name`. Set `name` data
	    public void setName(String name) {
	    		this.name=name;//write your code here
	    
	    }
	    public void raiseSalary(double byPercent) {
	    	this.salary=byPercent*salary;
	    }
}





enum Gender {
    MALE,
    FEMALE;
}

public class Assignment2 {
	// Assignment

	
	
	/**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public static double socialSecurityTax(Employee employee) {
       if(employee.salary<=8900)
    	   return 0.062*8900*12;
       else
    	   return 106800*0.062;
        
    	
    	
    	
    	//write your code here
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
    	double Coverage;
        //write your code here
    	if(employee.age<35){
    		Coverage=0.03*employee.salary;
    	}
    	else if(employee.age>=35&&employee.age<=50) {
    		Coverage=0.04*employee.salary;
    	}
    	else if(employee.age>50&&employee.age<60) {
    		Coverage=0.05*employee.salary;
    	}
    	else
    		Coverage=0.06*employee.salary;
    	return Coverage;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public static void sortSalary(Employee e1, Employee e2, Employee e3) {
    	double[] salary=new double[3];
    	String[] name=new String[3];
    	salary[0]=e1.salary;
    	salary[1]=e2.salary;
    	salary[2]=e3.salary;
    	name[0]=e1.name;
    	name[1]=e2.name;
    	name[2]=e3.name;
    	String tempname=new String();
    	Double tempsalary;
    	if(salary[0]>salary[1]){
    		tempsalary=salary[0];salary[0]=salary[1];salary[1]=tempsalary;
    		tempname=name[0];name[0]=name[1];name[1]=tempname;
    		}
        if(salary[0]>salary[2]){
        	tempsalary=salary[0];salary[0]=salary[2];salary[2]=tempsalary;
        	tempname=name[0];name[0]=name[2];name[2]=tempname;
        	}
        if(salary[1]>salary[2]){
        	tempsalary=salary[1];salary[1]=salary[2];salary[2]=tempsalary;
        	tempname=name[1];name[1]=name[2];name[2]=tempname;
        	}
        System.out.println(name[0]+name[1]+name[2]);
    	
    	//write your code here
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        //write your code here
    	employee.raiseSalary(3.0);
    	
    }


    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     x and y are formal parameter that will release the memory space after
      the function runs out,they are the pointer that point at the real memory space of objects.
     this function will not change the value in the memory.That why there is no change after swap();
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Employee a = new Employee("Jenny", 20, Gender.FEMALE, 9000);
	        Employee b = new Employee("John", 30, Gender.MALE, 2500);
	       // Employee c=new Employee("Joy", 30, Gender.MALE, 1900);
	        //sortSalary( a,  b, c);
	        //double salary=socialSecurityTax(a);
	        //System.out.println(salary);
	        System.out.println("Before: a=" + a.getName());
	        System.out.println("Before: b=" + b.getName());
	        swap(a, b);
	        System.out.println("After: a=" + a.getName());
	        System.out.println("After: b=" + b.getName());
	}
    public static void swap(Employee x, Employee y) {
        Employee temp= x;
        x = y;
        y = temp;
    }
	
}
