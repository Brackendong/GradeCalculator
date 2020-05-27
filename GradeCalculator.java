/*
* GradeCalculator.java
* Author: JiaoAng Dong
* Submission Date: 9/2/2019
*
* Purpose: Given the the weight and scores of each 
* part of the grade. the system calculates if you 
* will receive the desired letter grade, or how much
* one need to score to reach the desired grade.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		String letter = "";
		System.out.println("Grading Scale:");
		System.out.println("A\t 90-100");
		System.out.println("B\t 80-89");
		System.out.println("C\t 70-79");
		System.out.println("D\t 60-69");
		System.out.println("F\t below 60");
		System.out.println("What letter grade do you want to achieve for the course?");
		letter = keyboard.next();
		if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("b")
				|| letter.equalsIgnoreCase("c")|| letter.equalsIgnoreCase("d")
				|| letter.equalsIgnoreCase("f")) 
		{}
		else	
		{System.out.println("Input Error");
		 System.exit(0);
		}
		// prints out the grade scale and input error if anything else is entered.		
		System.out.println("Enter Percentage Weights:");
		System.out.print("Exam 1:\t\t");
		double exam1weig = keyboard.nextDouble();
		System.out.print("Exam 2:\t\t");
		double exam2weig = keyboard.nextDouble();
		System.out.print("Final Exam:\t");
		double finalexamweig = keyboard.nextDouble();
		System.out.print("Labs:\t\t");
		double labsweig = keyboard.nextDouble();
		System.out.print("Projects:\t");
		double projectsweig = keyboard.nextDouble();
		System.out.print("Participation:\t");
		double participationweig = keyboard.nextDouble();
		System.out.print("Quizzes:\t");
		double quizzesweig = keyboard.nextDouble();
		
		double totalweight = exam1weig + exam2weig + finalexamweig +
				labsweig + projectsweig + participationweig + quizzesweig ;
		if (totalweight != 100) {
			System.out.println("Weights don’t add up to 100, program exiting...");
			System.exit(0);}
		
		// take input of all the weights of the grade. will exit if total weight is
		// not 100
		
		double exam1, exam2, finalexam, lab, project, participation, quiz;
		
		System.out.println("Enter your scores out of a 100");
		
		System.out.print("Do you know your Exam 1 score?");
		String exam1yesno = keyboard.next();
		if (exam1yesno.equalsIgnoreCase("y") || exam1yesno.equalsIgnoreCase("yes")) {
		System.out.print("Score recived on exam 1:");
		exam1 = keyboard.nextDouble();
		System.out.print("Do you know your Exam 2 score?");
		String exam2yesno = keyboard.next();
		 if (exam2yesno.equalsIgnoreCase("y") || exam2yesno.equalsIgnoreCase("yes")) {
			 System.out.print("Score recived on exam 2:");
			 exam2 = keyboard.nextDouble();
		     System.out.print("Do you know your Final Exam score?");
			 String exam3yesno = keyboard.next();
			 if (exam3yesno.equalsIgnoreCase("y") || exam3yesno.equalsIgnoreCase("yes")) {
				 System.out.print("Score recived on final exam:");
				 finalexam = keyboard.nextDouble();}
			 
			 else {
				 finalexam = 0;
				 finalexamweig = 0;
			 }
		 }			 
		 else {
			exam2 = 0;
			finalexam = 0;
			exam2weig = 0;
			finalexamweig = 0;
		 }
		}
		else { 
			exam1 = 0;
			exam2 = 0;
			finalexam = 0;
			exam1weig = 0;
			exam2weig = 0;
			finalexamweig = 0;
		}
	
		// nested if statements for the 3 test, will not proceed if no test 1 or 2.
		// setting the weight and score of n/a grades to zero

		System.out.print("Do you know your lab average?");
		String labyesno = keyboard.next();
		if (labyesno.equalsIgnoreCase("y") || labyesno.equalsIgnoreCase("yes")) {
		System.out.print("Average Lab Grade:");
		lab = keyboard.nextDouble();}
		else { lab = 0;
		       labsweig = 0;}
					 
		
		System.out.print("Do you know your project average?");
		String projectyesno = keyboard.next();
		if (projectyesno.equalsIgnoreCase("y") || projectyesno.equalsIgnoreCase("yes")) {
		System.out.print("Average Project Grade:");
		project = keyboard.nextDouble();}
		else { project = 0;
		       projectsweig = 0; }	
		
		System.out.print("Do you know your participation average?");
		String participationyesno = keyboard.next();
		if (participationyesno.equalsIgnoreCase("y") || participationyesno.equalsIgnoreCase("yes")) {
		System.out.print("Average Participation Grade:");
		participation = keyboard.nextDouble();}
		else { participation = 0;
		       participationweig = 0;}
		
		System.out.print("Do you know your quiz average?");
		String quizyesno = keyboard.next();
		if (quizyesno.equalsIgnoreCase("y") || quizyesno.equalsIgnoreCase("yes")) {
		System.out.print("Average Quiz Grade:");
		quiz = keyboard.nextDouble();}
		else { quiz = 0 ;
		       quizzesweig = 0;}	
        
		// takes input of all the other portions of the grade, will make score 
		// and weight zero if the score is n/a

		double part1 = (exam1*exam1weig)+(exam2*exam2weig)+(finalexam*finalexamweig)+(lab*labsweig)
				        + (project*projectsweig) + (participation * participationweig)+(quiz*quizzesweig);
		double totalknownweight = exam1weig + exam2weig + finalexamweig + labsweig + projectsweig + participationweig + quizzesweig;
		double currentscore = part1 / totalknownweight;
		 
		// the equation for the current score
		
		String finalletter = "";
		double finaloverallscore = 0;
		if (currentscore >= 90 && currentscore <= 100) {
			finalletter = "A";
		}
		else if (currentscore >= 80 && currentscore <= 89) {
			finalletter = "B";
		}
		else if (currentscore >= 70 && currentscore <= 79) {
			finalletter = "C";
		}
		else if (currentscore >= 60 && currentscore <= 69) {
			finalletter = "D";
		}
		else if (currentscore <= 60) {
			finalletter = "F";
		}
		
		// if statements for the new letter grade from the new grade score.
		
		
		
		if (letter.equalsIgnoreCase("a")) {
			finaloverallscore = 90;
		}
		if (letter.equalsIgnoreCase("b")) {
		    finaloverallscore = 80;
		}
		if (letter.equalsIgnoreCase("c")) {
			finaloverallscore = 70;
		}
		if (letter.equalsIgnoreCase("d")) {
			finaloverallscore = 60;
		}
		if (letter.equalsIgnoreCase("f")) {
			finaloverallscore = 0;
		}
		
		// the min score for the desired letters
		
		double avgtofinalletter ;
		
		if (totalknownweight == 100) {
			avgtofinalletter = 0; }
		
		avgtofinalletter = (100 * finaloverallscore - part1) / (100-totalknownweight);
		
		// finds out how much one need to reach the desired letter 
		
		System.out.println("Current Grade Score:" + Math.ceil(currentscore));
		System.out.println("Your current grade letter is a " + finalletter);
		
		// prints out new grade and letter
		
		if (avgtofinalletter <= 100 && avgtofinalletter >= 0) {
			System.out.println("You have to score an average greater than or equal to " + Math.ceil(avgtofinalletter) +
					" in the remaining grade items to receive an " + letter + " in the course");
		}
	
		else if ( avgtofinalletter > 100 ) {
			System.out.print("Sorry, you cannot receive an " + letter + " in the course");}
	
	    else if ( finalletter.equals(letter) && totalknownweight == 100 ) {
	    	System.out.print("You will receive at least a " + letter + " no matter what");}
	    	
	    else if (avgtofinalletter <= 0) {
			System.out.println("Congratulations! You received the " + letter + " that you wanted!");}
	    
	    // statements on how high the remaining scores needed to be to reach the desired letter
		
		
		keyboard.close();
	
	}
}


