import java.io.Serializable;

public class Student implements Serializable{

	int id;
	String sName;
	
	public Student(int id, String sName){
		this.id = id;
		this.sName = sName;
	}
}
