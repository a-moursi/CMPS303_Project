<<<<<<< HEAD
public class Student {
=======
import java.io.Serializable;

public class Student implements Serializable{
>>>>>>> branch 'main' of https://github.com/a-moursi/CMPS303_Project.git

<<<<<<< HEAD
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
=======
	int id;
	String sName;
	
	public Student(int id, String sName){
		this.id = id;
		this.sName = sName;
	}
}
>>>>>>> branch 'main' of https://github.com/a-moursi/CMPS303_Project.git
