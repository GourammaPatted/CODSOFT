package sdbms;

public class Student {
private String id;
private int age;
private String name;
private int marks;

static int count=100;
public Student(int age,String name,int marks) {
	this.id="JSP"+count;
	this.age=age;
	this.name=name;
	this.marks=marks;
	count++;
}
public void setAge(int age) {
	this.age=age;
}
public void setName(String name) {
	this.name=name;
}
public void setMarks(int marks) {
	this.marks=marks;
}

public int getAge() {
	return age;
}
public String getName() {
	return name;
}
public int getMarks() {
	return marks;
}
public String getId() {
	return id;
}
public String toString() {
	return "[Id:"+id+" Age:"+age+" Name:"+name+" Marks:"+marks+"]";
}
}
