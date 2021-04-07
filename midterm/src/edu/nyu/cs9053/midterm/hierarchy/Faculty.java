package edu.nyu.cs9053.midterm.hierarchy;

public abstract class Faculty extends UniversityAffiliate {
	
	private boolean tenured;
	private boolean adjunct;
	
	public Faculty() {
		
	}
	
	public Faculty(String name, int age, boolean tenured, boolean adjunct) {
		super(name,age);
		this.tenured=tenured;
		this.adjunct=adjunct;
	}
	
	public boolean isTenured() {
		return this.tenured;
	}
	
	public boolean isAdjunct() {
		return this.adjunct;
	}
	
	public static boolean equals(Faculty f1, Faculty f2) {
		return f1.getAge()==(f2.getAge()) && f1.isAdjunct()==(f2.isAdjunct()) 
				&& f1.isTenured()==(f2.isTenured());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
