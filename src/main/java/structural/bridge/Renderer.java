interface Renderer {
    void render(String shape);
}

static class VectorRenderer implements Renderer {
    public void render(String s) {
        System.out.println("Vector: " + s);
    }
}

static class RasterRenderer implements Renderer {
    public void render(String s) {
        System.out.println("Raster: " + s);
    }
}

abstract static class Shape {
    protected Renderer renderer;

    Shape(Renderer r) {
        this.renderer = r;
    }

    abstract void draw();
}

static class Circle extends Shape {
    Circle(Renderer r) {
        super(r);
    }

    public void draw() {
        renderer.render("Circle");
    }
}

void main() {

    new Circle(new VectorRenderer()).draw();
    new Circle(new RasterRenderer()).draw();
}
