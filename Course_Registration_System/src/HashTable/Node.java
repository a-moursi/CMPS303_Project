package HashTable;

public class Node<E>{
	int key;
	E data;
	Node next;
	public Node(int k, E d,Node<E> n)
	{
		key=k;
		data=d;
		next=n;
	}
	public void diplay()
	{
		 System.out.print(key+":");
		 System.out.println(data);
	}
}
