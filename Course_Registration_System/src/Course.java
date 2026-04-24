<<<<<<< HEAD
public class Course {
=======
import Trees.Tree;

import java.io.Serializable;
>>>>>>> branch 'main' of https://github.com/a-moursi/CMPS303_Project.git

<<<<<<< HEAD
    private int CRN;
    private String courseName;
    private int capacity;
    private Tree<Student> enrolled;
    private LinkedQueue<Student> waitingList;

    public Course(int CRN, String courseName, int capacity) {
        this.CRN = CRN;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolled = new Tree<>();
        this.waitingList = new LinkedQueue<>();
    }

    public int getCRN() { return CRN; }
    public String getCourseName() { 
    	return courseName; }
    
    public int getCapacity() { 
    	return capacity;
    	}
    
    public void setCapacity(int capacity) {
    	this.capacity = capacity;
    	}
    
    public Tree<Student> getEnrolled() {
    	return enrolled;
    	}
    public LinkedQueue<Student> getWaitingList() {
    	return waitingList;
    	}

    @Override
    public String toString() {
        return "Course{CRN=" + CRN + ", name='" + courseName + "', capacity=" + capacity +
               ", enrolled=" + enrolled.size() + ", waitingList=" + waitingList.size() + "}";
    }
}
=======
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
>>>>>>> branch 'main' of https://github.com/a-moursi/CMPS303_Project.git
