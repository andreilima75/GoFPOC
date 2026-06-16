interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Meow!");
    }
}

abstract class AnimalFactory {
    abstract Animal createAnimal();

    void run() {
        createAnimal().speak();
    }
}

class DogFactory extends AnimalFactory {
    Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    Animal createAnimal() {
        return new Cat();
    }
}

void main() {
    new DogFactory().run();
    new CatFactory().run();
}



