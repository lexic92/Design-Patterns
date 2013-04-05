import junit.framework.TestCase;


public class TestCakeProxy extends TestCase 
{
	public void setUp()
	{
		//Do nothing
	}
	
	public void tearDown()
	{
		//Do nothing
	}
	
	public void testCakeProxy()
	{
		//Proxy Cake
		CakeProxy cake = new CakeProxy(new GlobalObjectId());
		
		
		//Real Cake. Needs to have the same globalObjectId as the proxy cake so when the proxy
		//cake uses its global id to fetch some object in the database, it will fetch this real cake.
		Cake realCake = new Cake(cake.getGlobalObjectId());
		
		//Get the database singleton and store the real cake in there.
		ObjectDB db = ObjectDB.getSingleton();
		db.store(realCake.getGlobalObjectId().getLocalObjectId(), realCake);
		
		
		assertTrue(cake.bitesLeft() == 20);
		assertTrue(realCake.bitesLeft() == 20);
		//Call "takeBite()" 20 times until there are 0 bites left.
		for(int i = 19; i >= 0; i--)
		{
			cake.takeBite();
			assertTrue(cake.bitesLeft() == i);
			assertTrue(realCake.bitesLeft() == i);
			
		}
		
		
		
	}
	
}
