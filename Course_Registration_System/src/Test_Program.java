import java.io.*;
import java.util.Scanner;

public class Test_Program {

	public static void main(String[] args) {
		final String Save_File = "treehashtable.dat";
		TreeHashTable sys = loadData(Save_File);
		startSystem(sys);

		exit(sys, Save_File);
	}

	// =================================================================

	private static TreeHashTable loadData(String save_file) {
		
		
		File file = new File(save_file);

	    if (!file.exists()) {
	        System.out.println("\nNo saved data found.\n");
	        return new TreeHashTable(); // return fresh object if no file
	    }

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
	    	System.out.println("\nData loaded successfully.\n");
	        return (TreeHashTable) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        System.err.println("\nFailed to load data: " + e.getMessage());
	        return new TreeHashTable(); // return fresh object if error
	    }
	}

	private static void startSystem(TreeHashTable sys) { // should handle invalid inputs
		Scanner sc = new Scanner(System.in);
		int choice = -1;

		while (choice != 7) {
			printMenu();

			if (!sc.hasNextInt()) {
				System.out.println("\nInvalid input!\n");
				sc.nextLine();
				continue;
			}
			choice = sc.nextInt();
			sc.nextLine();

			if (choice < 1 || choice > 7) {
				System.out.println("\nChoice must be [1-7]\n");
				continue;
			}

			switch (choice) {
			case 1 -> addCourse(sys);
			case 2 -> addStudent(sys);
			case 3 -> dropStudent(sys);
			case 4 -> raiseCapacity(sys);
			case 5 -> displayStudents(sys);
			case 6 -> displayCourses(sys);
			case 7 -> System.out.println("\nShutting down system...");

			default -> throw new IllegalArgumentException("Invalid Choice: " + choice);
			}
		}
		sc.close();
	}

	private static void printMenu() {

		System.out.println("====== Course Registration System ======\n");
		System.out.println("1- Add a new course.\n" + "2- Add a student to a course.\n"
				+ "3- Drop a student from a course.\n" + "4- Raise course’s capacity.\n"
				+ "5- Display students in a course.\n" + "6- Display student’s courses.\n" + "7- Exit\n");

		System.out.print("Choice > ");
	}

	private static void addCourse(TreeHashTable sys) {
		int crn = 0;
		String cName = null;
		int capacity = 0;

		// ask for course CRN, course name, its capacity,
		// call the method addCourse

		Course c = new Course(crn, cName, capacity);
		sys.addCourse(c);

	}

	private static void addStudent(TreeHashTable sys) {
		int crn = 0;
		String sName = null;
		int id = 0;

		// ask for course CRN, students id, name
		// call the method addStudent.

		Student s = new Student(id, sName);
		sys.addStudent(crn, s);
	}

	private static void dropStudent(TreeHashTable sys) {
		int crn = 0;
		int id = 0;

		// ask for course CRN, and student id,
		// call the method dropStudent

		sys.dropStudent(crn, id);
	}

	private static void raiseCapacity(TreeHashTable sys) {
		int crn = 0;
		int r = 0;

		// ask course CRN, and integer number represents the capacity increase(r),
		// call the method raiseCapacity.

		sys.raiseCapacity(crn, r);
	}

	private static void displayStudents(TreeHashTable sys) {
		int crn = 0;

		// ask for course CRN,
		// display the list of all students enrolled in course
		// by calling method printStudents

		sys.printStudents(crn);
	}

	private static void displayCourses(TreeHashTable sys) {
		int id = 0;

		// asks for student id,
		// prints all courses that the student enrolled in

	}

	private static void exit(TreeHashTable sys, String save_file) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(save_file))) {
	        oos.writeObject(sys);
	        System.out.println("\nData saved successfully.\n");
	    } catch (IOException e) {
	        System.err.println("\nFailed to save data: " + e.getMessage());
	    }
		
		// save the data structure object “TreeHashTable”
		// file (Object serialization)

		System.exit(0);
	}

}
