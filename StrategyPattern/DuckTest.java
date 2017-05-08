public class DuckTest {
	public static void main(String[] args) {
		Duck duck = new WoodDuck();
		duck.fly();

		duck = new RealDuck();
		duck.fly();
	}
}