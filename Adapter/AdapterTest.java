public class AdapterTest {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat fakeCat = new Dog2CatAdapter(dog);

		fakeCat.meow();
	}
}

class Cat {
	void meow() {
		System.out.println("Cat meows!");
	}
}

class Dog {
	void bark() {
		System.out.println("Dog barks!");
	}
}

class Dog2CatAdapter extends Cat {
	private Dog dog;

	public Dog2CatAdapter(Dog dog) {
		this.dog = dog;
	}

	// Not like in Scala, no need for keyword override.
	public void meow() {
		dog.bark();
	}
}