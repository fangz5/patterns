public class SingletonTest {
	public static void main(String[] args) {
		Singleton ref1 = Singleton.getInstance();
		Singleton ref2 = Singleton.getInstance();

		ref1.echo();
		ref2.echo();
	}
}

class Singleton {
   /*
	Options for multi-threading:
	1) If performance doesn't matter, use synchronization.
	2) Use eagerly created instance rather than a lazily created one.
	3) "Double-checked locking." If not created, synchronize.
	   Use keyword "volatile" to guarantee that different threads access
	   the instance in main memory, so the changes to the instance are 
	   visible to all threads.
	*/
	public static Singleton theInstance;
	private int count;

	private Singleton() { count = 0; }

	public static Singleton getInstance() {
		if (theInstance == null) {
			theInstance = new Singleton();
		}
		return theInstance; 
	}

	public void echo() {
		count++;
		System.out.println("Current count is " + count + ".");
	}

}