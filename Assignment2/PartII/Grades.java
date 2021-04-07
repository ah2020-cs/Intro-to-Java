import java.util.Scanner;

public class Grades {

	public static String letterGrade(float score) {
		
		
		//String grade;
		
		if (score>=90 && score<=100) {
			String grade = "A";
			return grade;
		}
		else if (score>=80 && score<=89) {
			String grade = "B";
			return grade;
		}
		else if (score>=70 && score<=79) {
			String grade = "C";
			return grade;
		}
		else if (score>=60 && score<=69) {
			String grade = "D";
			return grade;
		}
		else {
			return "F";
		}
		
	}
	
	public static void main(String[] args) {
		
		/* you probably want to use user input for the
		 * score using Scanner because you will have to convert
		 * a command line argument to a float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "score" variable
		 * to whatever you want in the code, and that's fine too
		 */
		
		
		System.out.print("Enter your score: ");
		Scanner in = new Scanner(System.in);
		int score = (int) in.nextFloat();
		
		String grade = letterGrade(score);
		
		// if the grade is not null print this out:
		if (score>=0 && score<=100) {
			System.out.println("The grade for a score of " + score + " is " + grade);
		}
		// if the grade is null, print this out:
		else if (score<0 | score>100) {
			System.out.println("Invalid score!");
		}
		in.close();
		
	}
}
