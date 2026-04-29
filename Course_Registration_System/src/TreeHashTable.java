
import java.io.Serializable;

public class TreeHashTable implements Serializable {

	private Course[] table;
	private int size;
	private Course defunct;

	public TreeHashTable(int size) {
		this.size = size;
		table = new Course[size];
		defunct = new Course(-1, null, 0);
	}

	public TreeHashTable() {
		// TODO Auto-generated constructor stub
	}

	public Course[] getTable() {
		return table;
	}

	public int getSize() {
		return size;
	}

	private int hash(int crn) {
		return crn % size;
	}

	public boolean isFull() {
		for (int i = 0; i < size; i++) {
			if (table[i] == null || table[i] == defunct)
				return false;
		}
		return true;
	}

	public void addCourse(Course c) {
		if (search(c.getCRN()) != null) {
			System.out.println("This CRN is already used. Try another one.");
			return;
		}

		if (isFull()) {
			System.out.println("Table is full. Cannot add more courses.");
			return;
		}

		int hashVal = hash(c.getCRN());

		while (table[hashVal] != null && table[hashVal] != defunct) {
			hashVal = (hashVal + 1) % size;
		}

		table[hashVal] = c;
		System.out.println("Course added successfully.");
	}

	public Course search(int crn) {
		int hashVal = hash(crn);
		int start = hashVal;

		while (table[hashVal] != null) {

			if (table[hashVal] != defunct && table[hashVal].getCRN() == crn) {
				return table[hashVal];
			}

			hashVal = (hashVal + 1) % size;

			if (hashVal == start)
				break;
		}

		return null;
	}

	public void addStudent(int crn, Student s) {
		Course course = search(crn);

		if (course == null) {
			throw new IllegalArgumentException("Course not found.");
		}

		if (course.getEnrolled().search(s.getId()) != null) {
			System.out.println("Student already enrolled.");
			return;
		}

		if (course.getEnrolledCount() >= course.getCapacity()) {
			course.getWaitingList().enqueue(s);
			System.out.println("Course full. Added to waiting list.");
		} else {
			course.enrollStudent(s);
			System.out.println("Student enrolled successfully.");
		}
	}

	public void dropStudent(int crn, int studentId) throws IllegalArgumentException{
		Course course = search(crn);

		if (course == null) {
			throw new IllegalArgumentException("Course not found.");
		}

		if (course.getEnrolled().search(studentId) == null) {
			throw new IllegalArgumentException("Student not found in this course.");
		}

		course.dropStudent(studentId);

		if (!course.getWaitingList().isEmpty()) {
			course.enrollStudent(course.getWaitingList().dequeue());
		}

		System.out.println("Student dropped successfully.");
	}

	public void raiseCapacity(int crn, int r) {
		// TODO Auto-generated method stub
		
	}

	public void printStudents(int crn) {
		// TODO Auto-generated method stub
		
	}
}
