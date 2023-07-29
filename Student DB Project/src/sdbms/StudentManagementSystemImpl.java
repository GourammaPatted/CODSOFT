package sdbms;

import java.util.*;

import customSorting.SortingStudentByAge;
import customSorting.SortingStudentById;
import customSorting.SortingStudentByMarks;
import customSorting.SortingStudentByName;
import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem {
	Scanner sc=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>();


	@Override
	public void addStudent() {
		System.out.println("Enter student age");
		int age=sc.nextInt();
		System.out.println("Enter student name");
		String name=sc.nextLine();
		System.out.println("Enter student marks");
		int marks=sc.nextInt();

		Student s1=new Student(age, name, marks);
		db.put(s1.getId(), s1);
		System.out.println("Student record inserted successfully");
		System.out.println("Student ID is:"+s1.getId());

	}
	@Override
	public void displayStudent() {
		String id=sc.nextLine().toUpperCase();
		if(db.containsKey(id)) {   //checking if id is present or not
			Student std=db.get(id);
			System.out.println("ID:"+std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
		}
		else {
			try {
				String msg="Student with the ID "+id+" is not Found!!!!";
				throw new StudentNotFoundException(msg);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudents() {
		if(db.size()!=0) {
			System.out.println("Students Details are as follows: ");
			System.out.println("------------------------");
			Set<String>keys=db.keySet();
			for(String key:keys) {
				Student std=db.get(key);
				System.out.println(std);
				//System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="Students records are empty, there is nothing to display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent() {
		System.out.println("Enter student id");
		String id=sc.nextLine().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student record found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("student record deleted successfully");
		}
		else {
			try {
				String message="Student id not found!!!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudents() {
		if(db.size()!=0) {
			System.out.println("Students records available"+db.size());
			db.clear();
			System.out.println("All students records deleted successfully");
			System.out.println("Students records available"+db.size());
		}
		else {
			try {
				String message="Student database is empty, Nothing to delete";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent() {
		String id=sc.nextLine().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update age\n2:Update Name\n3:Update Marks\n:Enter choice");
			int choice=sc.nextInt();
			switch(choice) {

			case 1:
				System.out.println("Enter age");
				int age=sc.nextInt();
				std.setAge(age);   //std.setAge(sc.nextInt());
				break;
			case 2:
				System.out.println("enter name");
				String name=sc.nextLine();
				std.setName(name);
				break;
			case 3:
				System.out.println("Enter marks");
				int marks=sc.nextInt();
				std.setMarks(marks);
				break;
			default:
				try {
					String message="Invalid choice please enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="Invalid id please enter correct id";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudent() {
		System.out.println("Number of Student records ="+db.size());
	}
	@Override
	public void sortStudent() {
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			System.out.println("1:Sort by Id\n2:Sort by Age\n3:Sort by name\n4:Sort by Marks");
			System.out.println("Enter the choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				Collections.sort(list,new SortingStudentById());
				display(list);
				break;

			case 2:
				Collections.sort(list,new SortingStudentByAge());
				display(list);
				break;

			case 3:
				Collections.sort(list,new SortingStudentByName());
				display(list);
				break;

			case 4:
				Collections.sort(list,new SortingStudentByMarks());
				display(list);
				break;
			default:
				try {
					String message="Invalid choice please enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
			else {
				try {
					String message="no sufficient records to compare";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());

				}
			}
		}
		private static void display(List <Student> list) {
			for(Student s:list) {
				System.out.println(s);
			}	
		}

		@Override
		public void getStudentWithHighestMarks() {
			if(db.size()>=2) {
				Set<String> keys=db.keySet();
				List<Student> list=new ArrayList<Student>();
				for(String key:keys) {
					list.add(db.get(key));
				}
				Collections.sort(list,new SortingStudentByMarks());
				System.out.println(list.size()-1);
			}
			else {
				try {
					String message="No sufficient student record to compare";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		@Override
		public void getStudentWithLowestMarks() {
			if(db.size()>=2) {
				Set<String> keys=db.keySet();
				List<Student> list=new ArrayList<Student>();
				for(String key:keys) {
					list.add(db.get(key));
				}
				Collections.sort(list,new SortingStudentByMarks());
				System.out.println(list.get(0));
			}
			else {
				try {
					String message="no sufficient student records to compare";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
