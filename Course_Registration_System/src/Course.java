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
	
	
}
