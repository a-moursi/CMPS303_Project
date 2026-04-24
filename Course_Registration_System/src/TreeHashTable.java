
import java.io.Serializable;

public class TreeHashTable implements Serializable{

    private Course[] table;
    private int tableSize;
    private static final Course DELETED = new Course(-1, "DELETED", 0);
=======
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
>>>>>>> branch 'main' of https://github.com/a-moursi/CMPS303_Project.git


    public TreeHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.table = new Course[tableSize];
    }


    private int hashFunction(int crn) {
        return crn % tableSize;
    }


    public void addCourse(Course c) {
        int index = hashFunction(c.getCRN());
        int i = 0;

        while (i < tableSize) {
            int probeIndex = (index + i) % tableSize;

            if (table[probeIndex] == null || table[probeIndex] == DELETED) {
                table[probeIndex] = c;
                return;
            }
            i++;
        }

        System.out.println("Hash table is full. Cannot add course.");
    }


    public Course search(int k) {
        int index = hashFunction(k);
        int i = 0;

        while (i < tableSize) {
            int probeIndex = (index + i) % tableSize;

            if (table[probeIndex] == null) return null;

            if (table[probeIndex] != DELETED && table[probeIndex].getCRN() == k)
                return table[probeIndex];

            i++;
        }

        return null;
    }


    public void addStudent(int k, Student s) throws RegistrationException {
        Course course = search(k);

        if (course == null)
            throw new RegistrationException("No course found with CRN: " + k);

        if (course.getEnrolled().size() >= course.getCapacity()) {
            course.getWaitingList().enqueue(s);
            System.out.println(s.getName() + " added to waiting list for course " + course.getCourseName());

        } else {
            course.getEnrolled().insert(s);
            System.out.println(s.getName() + " enrolled in course " + course.getCourseName());
        }
    }


    public void dropStudent(int c, int s) throws RegistrationException {
        Course course = search(c);

        if (course == null)
            throw new RegistrationException("No course found with CRN: " + c);

        Student found = course.getEnrolled().search(s);

        if (found == null)
            throw new RegistrationException("No student with id=" + s + " enrolled in course CRN=" + c);

        course.getEnrolled().delete(s);
        System.out.println("Student id=" + s + " dropped from course " + course.getCourseName());

        if (!course.getWaitingList().isEmpty()) {
            Student promoted = course.getWaitingList().dequeue();
            course.getEnrolled().insert(promoted);
            System.out.println(promoted.getName() + " moved from waiting list to enrolled.");
        }
    }


    public void raiseCapacity(int c, int r) throws RegistrationException {
        Course course = search(c);

        if (course == null)
            throw new RegistrationException("No course found with CRN: " + c);

        course.setCapacity(course.getCapacity() + r);
        System.out.println("Capacity of course " + course.getCourseName() + " raised to " + course.getCapacity());

        int moved = 0;

        while (moved < r && !course.getWaitingList().isEmpty()) {
            Student promoted = course.getWaitingList().dequeue();
            course.getEnrolled().insert(promoted);
            System.out.println(promoted.getName() + " moved from waiting list to enrolled.");
            moved++;
        }
    }


    public void printStudents(int n) throws RegistrationException {
        Course course = search(n);

        if (course == null)
            throw new RegistrationException("No course found with CRN: " + n);

        System.out.println("Enrolled students in " + course.getCourseName() + " (CRN=" + n + "):");

        if (course.getEnrolled().isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            course.getEnrolled().inOrder();
        }
    }


    public Course[] studentEnrolled(int i) throws RegistrationException {
        int count = 0;

        for (int idx = 0; idx < tableSize; idx++) {
            if (table[idx] != null && table[idx] != DELETED) {
                if (table[idx].getEnrolled().search(i) != null)
                    count++;
            }
        }

        if (count == 0)
            throw new RegistrationException("Student with id=" + i + " is not enrolled in any course.");

        Course[] result = new Course[count];
        int pos = 0;

        for (int idx = 0; idx < tableSize; idx++) {
            if (table[idx] != null && table[idx] != DELETED) {
                if (table[idx].getEnrolled().search(i) != null)
                    result[pos++] = table[idx];
            }
        }

        return result;
    }
}}
