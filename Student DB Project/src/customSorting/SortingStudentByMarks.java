package customSorting;

import java.util.Comparator;

import sdbms.Student;

public class SortingStudentByMarks  implements Comparator<Student>{
	@Override
	public int compare(Student x,Student y) {
		return x.getMarks()-y.getMarks();
}
}