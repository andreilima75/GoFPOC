interface Target {
    void request();
}

static class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee: specific request");
    }
}

static class Adapter implements Target {
    private final Adaptee adaptee;

    Adapter(Adaptee a) {
        this.adaptee = a;
    }

    public void request() {
        adaptee.specificRequest();
    }
}


void main() {
    Target t = new Adapter(new Adaptee());
    t.request();
}