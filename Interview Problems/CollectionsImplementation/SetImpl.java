package CollectionsImplementation;
/**yet to be completed*/
public class SetImpl {
	int size;
	int no_elements;
	
	SetImpl(int size)
	{
		this.size=size;
		no_elements=0;
		
	}
	private void add( )
	{
		no_elements++;
	}

	private void clear( )
	{
		no_elements=0;
	}

	
	private boolean	contains( int element)
	{
		
	}

	private boolean isEmpty( )
	{
		return (no_elements==0)?true:false;
	}

//		iterator( )
//	Returns an Iterator object for the collection which may be used to retrieve an object

	private int	remove( )
	{
		
	}
	private int	size( )
	{
		return size;
	}
	
	public static void main(String args[])
	{
		SetImpl s=new SetImpl(20);
	}
}
