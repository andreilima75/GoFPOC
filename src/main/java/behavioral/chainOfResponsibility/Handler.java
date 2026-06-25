abstract static class Handler {
    protected Handler next;

    Handler setNext(Handler h) {
        this.next = h;
        return h;
    }

    public abstract void handle(int request);
}

static class LowHandler extends Handler {
    public void handle(int r) {
        if (r < 10) System.out.println("Low handled: " + r);
        else if (next != null) next.handle(r);
    }
}

static class MidHandler extends Handler {
    public void handle(int r) {
        if (r < 100) System.out.println("Mid handled: " + r);
        else if (next != null) next.handle(r);
    }
}

static class HighHandler extends Handler {
    public void handle(int r) {
        System.out.println("High handled: " + r);
    }
}

void main() {
    Handler low = new LowHandler();
    low.setNext(new MidHandler()).setNext(new HighHandler());
    low.handle(5);
    low.handle(50);
    low.handle(500);
}
