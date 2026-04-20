import Trees.Tree;
import Queues.LinkedQueue;
import Queues.Queue;

public class Course {

	int crn;
	String cName;
	int capacity;
	
	Tree<Student> enrolled = new Tree<>(); 
	Queue<Student> waitingList = new LinkedQueue<>();
	
	public Course() {
		
	}
}
