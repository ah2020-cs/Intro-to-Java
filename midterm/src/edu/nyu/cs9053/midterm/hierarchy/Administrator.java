package edu.nyu.cs9053.midterm.hierarchy;

public class Administrator extends Employee {
	
	public String title;
	
	public Administrator(){
		
	}
	
	public Administrator(String name, int age, double salary, String title) {
		super(name,age,salary);
		this.title=title;
	}
	
	public String getTitle() {
		return this.getClass().getSimpleName() + "- " + title;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Administrator newguy = new Administrator("Aakash", 20, 15000, "receptionist");
		System.out.println(newguy.getTitle());
		System.out.println(newguy.getAge());

	}

}
