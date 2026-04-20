import java.util.Scanner;

public class Test_Program {

	public static void main(String[] args) {

		startSystem();
	}

	//=================================================================
	
	private static void startSystem() {
		
		// should handle invalid inputs 
		Scanner sc = new Scanner(System.in);
		printMenu();
		int choice = sc.nextInt();
		sc.close();

		switch (choice) {
		case 1 -> m1();
		case 2 -> m2();
		case 3 -> m3();
		case 4 -> m4();
		case 5 -> m5();
		case 6 -> m6();
		case 7 -> m7();

		default -> throw new IllegalArgumentException("Invalid Choice: " + choice);
		}
	}
	
	private static void printMenu() {

		System.out.println("====== Course Registration System ======\n");
		System.out.println("1- Add a new course.\n" + "2- Add a student to a course.\n"
				+ "3- Drop a student from a course.\n" + "4- Raise course’s capacity.\n"
				+ "5- Display students in a course.\n" + "6- Display student’s courses.\n" + "7- Exit\n");

		System.out.print("Choice > ");
	}

	private static void m1() {

		// ask for course CRN, course name, its capacity,
		// call the method addCourse

	}

	private static void m2() {

		// ask for course CRN, students id, name
		// call the method addStudent.

	}

	private static void m3() {

		// ask for course CRN, and student id,
		// call the method dropStudent

	}

	private static void m4() {

		// ask course CRN, and integer number represents the capacity increase(r),
		// call the method raiseCapacity.

	}

	private static void m5() {

		// ask for course CRN,
		// display the list of all students enrolled in course
		// by calling method printStuden

	}

	private static void m6() {

		// asks for student id,
		// prints all courses that the student enrolled in

	}

	private static void m7() {

		// save the data structure object “TreeHashTable”
		// file (Object serialization)

		System.out.println("Shutting down system...");
	    System.exit(0);
	}

}
