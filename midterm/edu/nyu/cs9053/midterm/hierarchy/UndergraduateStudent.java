package edu.nyu.cs9053.midterm.hierarchy;

public class UndergraduateStudent extends Student {
	
	public UndergraduateStudent() {
		
	}
	
	public UndergraduateStudent(String name, int age, boolean matriculated) {
		super(name,age, matriculated);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new UndergraduateStudent("Aakash", 25, false);
		System.out.println(s1.getName());

	}

}
