package edu.nyu.cs9053.midterm.hierarchy;

public abstract class Employee extends UniversityAffiliate {
	
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, double salary) {
		super(name,age);
		this.salary=salary;
	}
	
	public double getSalary() {
		return this.salary;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
