package HashTable;

public class LinearProbingHashTable<E>
{
	private Entry[] hashArray;    
	private Entry  defunct;        

	public LinearProbingHashTable(int size)       
	{
		hashArray = new Entry[size];
		defunct = new Entry(-1,null);   
	}

	public void displayTable()
	{
		for(int j=0; j<hashArray.length; j++)
			if(hashArray[j] != null)
				hashArray[j].diplay();
			else
				System.out.println("** ");
	}
	//--------------------------------------------------
	public boolean isFull()
	{
		for (int i=0;i<hashArray.length;i++)
			if(hashArray[i]==null || hashArray[i]==defunct)
				return false;
		return true;

	}
	// -------------------------------------------------------------
	public int hashFunc(int key)
	{
		return key % hashArray.length;     
	}

	public void insert(int k, E d) 
	{
		if (!isFull())
		{

			int hashVal = hashFunc(k);  

			while(hashArray[hashVal] != null && hashArray[hashVal]!= defunct)
			{
				++hashVal;                 
				hashVal %= hashArray.length;      
			}
			hashArray[hashVal] = new Entry(k,d);    
		}
	}
	
	public E delete(int k)  
	{
		int hashVal = hashFunc(k);  
		int start=hashVal;
		boolean checkAll=false;
		while(hashArray[hashVal] != null && hashArray[hashVal]!=defunct && !checkAll)  
		{                               
			if(hashArray[hashVal].key == k)
			{
				E temp = (E)hashArray[hashVal].data; 
				hashArray[hashVal] = defunct;      
				return temp;                        
			}
			++hashVal;                 
			hashVal %= hashArray.length;      
			if (hashVal==start) 
				checkAll=true;
		}
		return null;                  
	}  
	
	public E find(int k)    
	{
		int hashVal = hashFunc(k);  
		int start=hashVal;
		boolean checkAll=false;
		while(hashArray[hashVal] != null && !checkAll)  
		{                               
			if(hashArray[hashVal].key == k)
				return (E)hashArray[hashVal].data;   
			++hashVal;                 
			hashVal %= hashArray.length;      
			if (hashVal==start) 
				checkAll=true;
		}
		return null;                  
	}
	// -------------------------------------------------------------
}  