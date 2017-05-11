public abstract class Duck {
	
	public Duck() {}

	FlyBehavior flyBehavior;

	public void fly() {
		flyBehavior.fly();
	}
}

interface FlyBehavior {
	public void fly();
}

class FlyWithWings implements FlyBehavior {
	public void fly() {
		System.out.println("Fly with wings!");
	}
}

class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("Can not fly!");
	}
}