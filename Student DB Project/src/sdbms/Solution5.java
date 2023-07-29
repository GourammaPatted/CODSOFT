package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution5 {
	public static void main(String[] args) {
		System.out.println("Welcome to Student Database Management System");

		Scanner sc=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImpl();

		while(true) {
			System.out.println("1:Add Student\n2:Display Student\n3:Display All Student\n4:Remove Student");
			System.out.println("5:Remove All Students\n6:Update Student\n7:Count Students \n8:Sort Students");
			System.out.println("9:Get Student With HighestMarks\n10:Get Student With LowestMarks\n11:EXIT\n:Enter Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudents();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudents();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();;
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("THANK YOU !!");
				System.exit(0);
			default:
				try {
					String msg="Invalid Choice, Kindly enter valid choice";
					throw new InvalidChoiceException(msg);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("=========================");
			}
		}
	}
}
