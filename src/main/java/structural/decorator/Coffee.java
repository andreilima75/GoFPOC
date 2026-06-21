protected interface Coffee {
    double getCost();

    String getDesc();
}

static class SimpleCoffee implements Coffee {
    public double getCost() {
        return 1.0;
    }

    public String getDesc() {
        return "Coffee";
    }
}

abstract static class CoffeeDecorator implements Coffee {
    protected final Coffee coffee;

    CoffeeDecorator(Coffee c) {
        this.coffee = c;
    }
}

static class Milk extends CoffeeDecorator {
    Milk(Coffee c) {
        super(c);
    }

    public double getCost() {
        return coffee.getCost() + 0.25;
    }

    public String getDesc() {
        return coffee.getDesc() + ", milk";
    }
}

static class Sugar extends CoffeeDecorator {
    Sugar(Coffee c) {
        super(c);
    }

    public double getCost() {
        return coffee.getCost() + 0.10;
    }

    public String getDesc() {
        return coffee.getDesc() + ", sugar";
    }
}

void main() {
    Coffee c = new Sugar(new Milk(new SimpleCoffee()));
    System.out.println(c.getDesc() + " $" + c.getCost());
}
