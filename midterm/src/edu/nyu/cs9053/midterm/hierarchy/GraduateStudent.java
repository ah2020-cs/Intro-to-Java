package edu.nyu.cs9053.midterm.hierarchy;

public class GraduateStudent extends Student{
	
	public GraduateStudent() {
		
	}
	
	public GraduateStudent (String name, int age, boolean matriculated) {
		super(name,age, matriculated);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new GraduateStudent("Aakash", 25, true);
		System.out.println(s1.isMatriculated());

	}

}
