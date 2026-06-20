interface Component {
    void show(int depth);
}

static class Leaf implements Component {
    private final String name;

    Leaf(String n) {
        this.name = n;
    }

    public void show(int d) {
        System.out.println("  ".repeat(d) + name);
    }
}

static class Composite implements Component {
    private final String name;
    private final List<Component> children = new ArrayList<>();

    Composite(String n) {
        this.name = n;
    }

    void add(Component c) {
        children.add(c);
    }

    public void show(int d) {
        System.out.println("  ".repeat(d) + name);
        children.forEach(c -> c.show(d + 1));
    }
}

void main() {
    Composite root = new Composite("root");
    root.add(new Leaf("file1"));
    root.add(new Leaf("file2"));
    root.show(0);
}
