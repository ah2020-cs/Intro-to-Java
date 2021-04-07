package edu.nyu.cs9053.midterm.hierarchy;

public class Professor extends Faculty {
	
	public Professor() {
		
	}
	
	public Professor(String name, int age, boolean tenured, boolean adjunct) {
		super(name,age, tenured, adjunct);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Professor prof1 = new Professor("Aakash", 20, true, false);
		System.out.println(prof1.getName()+" is "+prof1.getAge());
		//System.out.println(prof1.isTenured());
		
		Professor prof2 = new Professor("Aakash", 20, true, false);
		
		System.out.println(Faculty.equals(prof1, prof2));
		

	}

}
