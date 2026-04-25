
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
            System.out.println("A course with  this CRN " + c.getCRN() + " already exists. .");
            return;
        }

        if (!isFull()) {
            int hashVal = hash(c.getCRN());
            
            while (table[hashVal] != null && table[hashVal] != defunct) {
                hashVal++;
                hashVal %= size;
            }

            table[hashVal] = c;
            System.out.println("Course added successfully.\n");
        } else {
            System.out.println("Hash table is full. Cannot add more courses.");
        }
    }

    public Course search(int crn) {
        int hashVal = hash(crn);
        int start = hashVal;
        boolean checkedAll = false;

        while (table[hashVal] != null && !checkedAll) {
            if (table[hashVal] != defunct && table[hashVal].getCRN() == crn) {
                return table[hashVal];
            }

            hashVal++;
            hashVal %= table.length;

            if (hashVal == start) {
                checkedAll = true;
            }
        }
        
        return null;
    }

    public void addStudent(int crn, Student s) {
        Course course = search(crn);
        if (course == null) {
            throw new IllegalArgumentException("Course with CRN " + crn + " was not found.");
        }
        if (course.getEnrolledCount() >= course.getCapacity()) {
            course.getWaitingList().enqueue(s);
            System.out.println("Student is added to the Waiting List since the course is full");
        }
        if(course.getEnrolled().search(s.getId())!=null) {
        	System.out.println("Student already exists");
        }
        else {
            course.enrollStudent(s);
            System.out.println("Student is successfully added");
        }
    }

    public void dropStudent(int crn, int studentId) {
        Course course = search(crn);
        if (course == null) {
            throw new IllegalArgumentException("Course with CRN " + crn + " was not found.");
        }
        if (course.getEnrolled().search(studentId) == null) {
            throw new IllegalArgumentException("Student with ID " + studentId + " was not found.");
        }
        course.dropStudent(studentId);
        if (!course.getWaitingList().isEmpty())
            course.enrollStudent(course.getWaitingList().dequeue());
    }

    public void raiseCapacity(int crn, int increase) {
        Course course = search(crn);
        if (course == null) {
            throw new IllegalArgumentException("Course with CRN " + crn + " was not found.");
        }
        
        else {
            course.setCapacity(course.getCapacity() + increase);
            while (course.getCapacity() > course.getEnrolledCount() && course.getWaitingList().size() != 0) {
                course.enrollStudent(course.getWaitingList().dequeue());
            }
        }
    }

    public void printStudents(int crn) {
        Course course = search(crn);
        if (course == null) {
            throw new IllegalArgumentException("Course with CRN " + crn + " was not found.");
        }

        if (course.getEnrolled() == null) {
            System.out.println("No students enrolled.");
            return;
        }

        course.getEnrolled().traverse(2); // inOrder traversal
    }

    public Course[] studentEnrolled(int studentId) {
        Course[] result = new Course[table.length];
        int counter = 0;

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i] != defunct) {
                if (table[i].getEnrolled().search(studentId) != null) {
                    result[counter] = table[i];
                    counter += 1;
                }
            }
        }

        if (counter == 0) {
            throw new IllegalArgumentException("Student with ID " + studentId + " is not enrolled in any course.");
        }

        return result;
    }
    

    

    	
    	
    }




































