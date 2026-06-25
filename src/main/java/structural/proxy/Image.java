interface Image {
    void display();
}

static class RealImage implements Image {
    private final String file;

    RealImage(String f) {
        this.file = f;
        System.out.println("Loading: " + f);  // expensive!
    }

    public void display() {
        System.out.println("Displaying: " + file);
    }
}

static class ProxyImage implements Image {
    private final String file;
    private RealImage real;

    ProxyImage(String f) {
        this.file = f;
    }

    public void display() {
        if (real == null)
            real = new RealImage(file);
        real.display();
    }
}

void main() {
    Image img = new ProxyImage("photo.jpg");
    img.display();
    img.display();
}
