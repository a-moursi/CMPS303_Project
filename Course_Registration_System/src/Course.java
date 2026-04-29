import Trees.Tree;

import java.io.Serializable;

import Queues.LinkedQueue;
import Queues.Queue;

public class Course implements Serializable{

	private int crn;
	private String cName;
	private int capacity;
	
	Tree<Student> enrolled = new Tree<>(); 
	Queue<Student> waitingList = new LinkedQueue<>();
	
	public Course(int crn, String name) {
		this.crn = crn;
		this.cName = name;
		this.capacity = 30; //Default Capacity
	}
	
	public Course(int crn, String name, int capacity) {
		this.crn = crn;
		this.cName = name;
		this.capacity = capacity;
	}

	public int getCRN() {
		return crn;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Tree<Student> getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Tree<Student> enrolled) {
		this.enrolled = enrolled;
	}

	public Queue<Student> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(Queue<Student> waitingList) {
		this.waitingList = waitingList;
	}

	public void enrollStudent(Student s) {
		enrolled.insert(s.getId(), s);
		
	}

	public void dropStudent(int studentId) {
		enrolled.delete(studentId);
	}

	public int getEnrolledCount() {
		return 0;
	}
	
}
