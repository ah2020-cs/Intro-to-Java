package edu.nyu.cs9053.midterm.hierarchy;

public abstract class UniversityAffiliate {
	
	public String name;
	public int age;

	public UniversityAffiliate() {

	}

	public UniversityAffiliate(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
