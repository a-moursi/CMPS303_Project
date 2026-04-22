public class Course {

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