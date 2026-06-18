static class Shape implements Cloneable {
    private final String color;
    private final int x;
    private final int y;

    Shape(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        return color + " shape at (" + x + "," + y + ")";
    }
}

void main() {
    Shape original = new Shape("red", 10, 20);
    Shape copy = original.clone();
    System.out.println(copy);
}
