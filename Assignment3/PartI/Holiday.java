
public class Holiday {
	private String name;
	private int day;
	private String month;
	
	public Holiday(String name1, int day1, String month1) {
		name = name1;
		day = day1;
		month = month1;
	}
	
	public static boolean isSameMonth(Holiday h1, Holiday h2) {
		
		if (h1.month == h2.month) {
			return true;
		}
		return false;
	}
	
	public static double avgDate(Holiday[] holidays) {
	
		double avg = 0;
		
		for (int i=0; i<holidays.length; i++) {
			avg+=holidays[i].day;
		}
		avg /= holidays.length;
		return avg;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public String getMonth() {
		return this.month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String toString() {
		return this.name+": "+this.month+" "+this.day;
	}
	
	public static void main(String[] args) {
		
		Holiday[] holidays = new Holiday[5];
		holidays[0] = new Holiday("May Day", 1, "May");
		
		holidays[1] = new Holiday("June Day", 2, "June");
		holidays[2] = new Holiday("July Day", 3, "July");
		holidays[3] = new Holiday("Aug. Day", 4, "August");
		holidays[4] = new Holiday("Sept. Day", 5, "September");
		
		
		System.out.println(holidays[1]);
		System.out.println(avgDate(holidays));
		
		System.out.println(holidays[3].toString());
		
		holidays[3].setDay(1);
		System.out.println(holidays[3]);
		
		//new Holiday("Birthday", 8, "February");
		
		System.out.println(isSameMonth(holidays[0],holidays[1]));
		
		
		
		
	}
}
