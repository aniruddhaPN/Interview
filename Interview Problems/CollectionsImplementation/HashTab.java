package CollectionsImplementation;

public class HashTab {

	public class HashEntry
	{
		String value;
		int key;
		HashEntry next;

		HashEntry(int key,String value)
		{
			this.key=key;
			this.value=value;
			this.next=null;
		}				
	}
	int size;
	HashEntry [] HashTabl;

	HashTab(int size)
	{
		this.size=size;
		HashTabl = new HashEntry[size];
	}
	private void put(int key, String value) 
	{
		int hash_index=hashCode(key);
		if(HashTabl[hash_index]==null)
		{
			HashEntry entry=new HashEntry(key,value);
			HashTabl[hash_index]=entry;
		}
		else
		{
			HashEntry prev=HashTabl[hash_index];
			while(prev.next!=null)
			{
				prev=prev.next;
			}
			prev.next= new HashEntry(key,value);
		}

	}
	private String get(int key1) 
	{
		int hash_index=hashCode(key1);
		HashEntry h =HashTabl[hash_index];
		if(h.key==key1)
			return h.value ;
		else if(h.next==null)
		{
			return null;
		}
		else 
		{
			return get(h,key1);
		}
	}

	private static String get(HashEntry h,int key)
	{
		h=h.next;
		if(h==null)
			return null;
		else if(key==h.key)
			return h.value;
		else
			return get(h,key);
	}
	private int hashCode(int key)
	{
		return key%size;
	}
	private boolean containsValue(int key) {
		HashEntry h = HashTabl[hashCode(key)];
			while(h.next!=null)
			{
				if(h.key==key)
					return true;
				h=h.next;
			}
			if(h.key==key)
				return true;
			return false;
		}
	
	public static void main(String args[])
	{
		HashTab ht=new HashTab(10);
		ht.put(1,"20");
		ht.put(3,"abi");
		ht.put(4,"dog");
		ht.put(15,"cat");
		ht.put(25,"kahkjd");
		ht.put(35,"kscahkjd");
		ht.put(16,"get");
		ht.put(26,"dog");
		System.out.println(ht.get(1));
		System.out.println(ht.get(3));
		System.out.println(ht.get(4));
		System.out.println(ht.get(15));
		System.out.println(ht.get(25));
		System.out.println(ht.get(16));
		System.out.println(ht.get(26));
		System.out.println("code--"+ht.hashCode(15));
		System.out.println("code--"+ht.hashCode(25));
		System.out.println(ht.containsValue(15));

	}
	


}
