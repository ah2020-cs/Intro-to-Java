package edu.nyu.cs9053.midterm.hierarchy;

public class Staff extends Employee {
	
	public String title;
	
	public Staff(){
		
	}
	
	public Staff(String name, int age, double salary, String title) {
		super(name,age,salary);
		this.title=title;
	}
	
	public String getTitle() {
		return this.getClass().getSimpleName() + "- " + title;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Staff newguy = new Staff("Aakash", 25, 10000, "receptionist");
		System.out.println(newguy.getTitle());
		System.out.println(newguy.getAge());
		

	}

}
