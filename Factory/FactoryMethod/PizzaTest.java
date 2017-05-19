import java.util.ArrayList;

public class PizzaTest {
	public static void main(String[] args) {
		PizzaStore nyPizzaStore = new NYPizzaStore();
		PizzaStore laPizzaStore = new LAPizzaStore();

		nyPizzaStore.orderPizza();
		laPizzaStore.orderPizza();
	}
}

abstract class PizzaStore {
	public Pizza orderPizza() {
		Pizza pizza;

		pizza = createPizza();

		pizza.prepare();
		pizza.bake();
		pizza.box();

		return pizza;
	}

	// Let subclass decide return type => Factory method pattern
	// It also satisfies the "inversion dependence" principle, as "orderPizza" does not depend
	// on the concrete type of pizza.
	protected abstract Pizza createPizza();
}

class LAPizzaStore extends PizzaStore {
	protected Pizza createPizza() {
		return new LAStylePizza();
	}
}

class NYPizzaStore extends PizzaStore {
	protected Pizza createPizza() {
		return new NYStylePizza();
	}
}

abstract class Pizza {
	String name;
	ArrayList<String> toppings = new ArrayList<String>();

	void prepare() {
		System.out.println("preparing " + name);
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println("  " + toppings.get(i));
		}
	}

	void bake() {
		System.out.println("Baking...");
	}

	void box() {
		System.out.println("Put in box ...");
	}
}

class NYStylePizza extends Pizza {
	public NYStylePizza() {
		name = "NY Pizza";
		toppings.add("NY cheese");
	}
}

class LAStylePizza extends Pizza {
	public LAStylePizza() {
		name = "LA Pizza";
		toppings.add("LA cheese");
	}
}