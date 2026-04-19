package Trees;

public class Test {
public static void main(String arg[])
{
	Tree t=new Tree();
	t.insert(50,new Student(50,"Ali"));
	t.insert(20,new Student(20,"Khalid"));
	t.insert(70,new Student(70,"Nasser"));
	t.traverse(3);
	System.out.println();
	t.delete(70);
	t.traverse(3);
	System.out.println();
}
}
