interface Visitor {
    void visit(Circle c);

    void visit(Rectangle r);
}

interface Shape {
    void accept(Visitor v);
}

static class Circle implements Shape {
    double radius;

    Circle(double r) {
        this.radius = r;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

static class Rectangle implements Shape {
    double w, h;

    Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

static class AreaCalculator implements Visitor {
    public void visit(Circle c) {
        System.out.println("Circle area: " + (Math.PI * c.radius * c.radius));
    }

    public void visit(Rectangle r) {
        System.out.println("Rect area: " + (r.w * r.h));
    }
}

void main() {
    List<Shape> shapes = List.of(new Circle(5), new Rectangle(3, 4));
    Visitor calc = new AreaCalculator();
    shapes.forEach(s -> s.accept(calc));
}
