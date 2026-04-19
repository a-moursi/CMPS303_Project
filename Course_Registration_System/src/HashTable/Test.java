package HashTable;

public class Test {
public static void main(String arg[])
{
	LinearProbingHashTable<Student> t=new LinearProbingHashTable<Student>(10);
	t.insert(50,new Student(50,"Ali"));
	t.insert(20,new Student(20,"Khalid"));
	t.insert(70,new Student(70,"Nasser"));
	t.displayTable();
	
	t.delete(70);
	t.insert(30,new Student(70,"Nasser"));
	t.displayTable();
	
	
}
}
