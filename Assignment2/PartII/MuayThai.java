import java.util.Scanner;

public class MuayThai {

	public static int getMinWeight(int weight) {
		// this takes a weight and returns the "min weight" for the
		// weight class
		 if (weight>=0 && weight<112) {
			 return 0;
		 }
		 else if (weight>=112 && weight<115) {
			 return 112;
		 }
		 else if (weight>=115 && weight<118) {
			 return 115;
		 }
		 else if (weight>=118 && weight<122) {
			 return 118;
		 }
		 else if (weight>=122 && weight<126) {
			 return 122;
		 }
		 else if (weight>=126 && weight<130) {
			 return 126;
		 }
		 else if (weight>=130 && weight<135) {
			 return 130;
		 }
		 else if (weight>=135 && weight<140) {
			 return 135;
		 }
		 else if (weight>=140 && weight<147) {
			 return 140;
		 }
		 else if (weight>=147 && weight<154) {
			 return 147;
		 }
		 else if (weight>=154 && weight<160) {
			 return 154;
		 }
		 else if (weight>=160 && weight<167) {
			 return 167;
		 }
		 else if (weight>=167 && weight<175) {
			 return 167;
		 }
		 else if (weight>=175 && weight<183) {
			 return 175;
		 }
		 else if (weight>=183 && weight<190) {
			 return 183;
		 }
		 else if (weight>=190 && weight<220) {
			 return 190;
		 }
		 return 220;
	}
	
	public static String getWeightClass(int weight) {
		
		String weightClass = null;
		// use a switch statement to assign the correct
		// value to weightClass and return the result
		
		switch (weight){
			case 0:
				weightClass = "Flyweight";
				break;
			case 112:
				weightClass = "Super Flyweight";
				break;
			case 115:
				weightClass = "Bantamweight";
				break;
			case 118:
				weightClass = "Super Bantamweight";
				break;
			case 122:
				weightClass = "Featherweight";
				break;
			case 126:
				weightClass = "Super Featherweight";
				break;
			case 130:
				weightClass = "Lightweight";
				break;
			case 135:
				weightClass = "Super Lightweight";
				break;
			case 140:
				weightClass = "Welterweight";
				break;
			case 147:
				weightClass = "Super Welterweight";
				break;
			case 154:
				weightClass = "Middleweight";
				break;
			case 160:
				weightClass = "Super Middleweight";
				break;
			case 167:
				weightClass = "Light Heavyweight";
				break;
			case 175:
				weightClass = "Super Light Heavyweight";
				break;
			case 183:
				weightClass = "Cruiserweight";
				break;
			case 190:
				weightClass = "Heavyweight";
				break;
			case 220:
				weightClass = "Super Heavyweight";
				break;
		}
		
		return weightClass;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input weight in pounds: ");
		int pounds = in.nextInt();
		
		// if pounds is greater than zero
		if (pounds>0) {
		System.out.print("Weight class for " + pounds + " is: ");
		System.out.println(getWeightClass(getMinWeight(pounds)));
		}
		// if for some reason you put in a negative number of pounds:
		else {
		System.out.println("Invalid weight value");
		}
		in.close();
	}
}
