import java.io.Serializable;

public class TreeHashTable implements Serializable{

	// Constructor
	TreeHashTable() {

	}

	// maps a key (assumes the course crn is an integer number) to a slot in the
	// table, returns integer (hash value).
	public int hashFunc(int key) {
		return 0;
	}
	
	//======================================================================================

	// inserts a course to the table.
	public void addCourse(Course c) {

	}

	// returns a course, the course that its CRN=k, or returns null if no such
	// course
	public Course search(int k) { //
		Course result = null;

		return result;
	}

	// It registers a student s in the course that its CRN=k.
	public void addStudent(int k, Student s) {

		// Case1: no course with CRN(k) -> throw exception

		// Case2: course is full -> add to waitingList

		// Case3: course not full -> add to enrolled
	}

	// it removes student with id=s from the course that its CRN=k.
	public void dropStudent(int k, int s) {

		// if: no course with CRN(k) or no student with id(s) -> throw exception

		// if: there's students in waitingList -> move one to enrolled

	}

	// increase the capacity of the course with CRN=k by the value of r
	public void raiseCapacity(int k, int r) {

		// if: no course with CRN(k) -> throw exception

		// if: there's students in waitingList -> move them to enrolled

		// Case1: waiting > r -> move r to enrolled
		// Case2: waiting <= r -> move all of them to enrolled

	}

	// prints the students who are enrolled in the course that has CRN=k
	// use IN-ORDER approach
	public void printStudents(int k) {

		// if: no course with CRN(k) -> throw exception

	}
	
	//returns an array (not arrayList) of all courses that student with id=s is enrolled in
	//use the search in each tree to search for student through all trees in the table
	public Course[] studentEnrolled(int s) {
		Course[] result = null;
		//if: no student with id(s) in table -> throw exception
		
		return result;
	}

}
