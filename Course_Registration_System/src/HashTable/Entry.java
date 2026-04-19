package HashTable;

public class Entry<E>{
	int key;
	E data;
	public Entry(int k, E d)
	{
		key=k;
		data=d;
		
	}
	public void diplay()
	{
		 System.out.print(key+":");
		 System.out.println(data);
	}
}
