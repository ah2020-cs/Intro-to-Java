package edu.nyu.cs9053.midterm.hierarchy;

public abstract class Student extends UniversityAffiliate {
	
	private boolean matriculated;
	
	public Student() {
		
	}
	
	public Student(String name, int age, boolean matriculated) {
		super(name,age);
		this.matriculated = matriculated;
	}
	
	public boolean isMatriculated() {
		return this.matriculated;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
