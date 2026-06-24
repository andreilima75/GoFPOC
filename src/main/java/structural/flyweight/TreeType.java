static class TreeType {
    private final String name;
    private final String color;

    TreeType(String n, String c) {
        this.name = n;
        this.color = c;
    }

    void draw(int x, int y) {
        System.out.println(name + " (" + color + ") at " + x + "," + y);
    }
}

static class TreeFactory {
    private static final Map<String, TreeType> cache = new HashMap<>();

    static TreeType get() {
        return cache.computeIfAbsent(
                "Oak" + "green", k -> new TreeType("Oak", "green"));
    }
}

void main() {
    for (int i = 0; i < 1_000_000; i++) {
        TreeFactory.get().draw(i, i * 2);
    }
}
