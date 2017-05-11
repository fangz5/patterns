public class DecoratorTest {
    public static void main(String[] args) {
        Beverage order1 = new Espresso();
        order1 = new Milk(order1);

        Beverage order2 = new Tea();
        order2 = new Milk(order2);
        order2 = new Honey(order2);

        System.out.println(order1.getDescription() + ":" + order1.cost());
        System.out.println(order2.getDescription() + ":" + order2.cost());
    }
}

abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}

class Tea extends Beverage {
    public Tea() {
        description = "Tea";
    }

    public double cost() {
        return 1.49;
    }
}

class Milk extends CondimentDecorator {
    public Milk(Beverage b) {
        beverage = b;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    } 

    public double cost() {
        return beverage.cost() + 0.25;
    }
}

class Honey extends CondimentDecorator {
    public Honey(Beverage b) {
        beverage = b;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Honey";
    }

    public double cost() {
        return beverage.cost() + 0.50;
    }
}