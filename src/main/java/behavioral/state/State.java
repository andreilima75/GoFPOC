interface State {
    void handle(TrafficLight ctx);
}

static class GreenState implements State {
    public void handle(TrafficLight ctx) {
        System.out.println("Green → go");
        ctx.setState(new YellowState());
    }
}

static class YellowState implements State {
    public void handle(TrafficLight ctx) {
        System.out.println("Yellow → slow");
        ctx.setState(new RedState());
    }
}

static class RedState implements State {
    public void handle(TrafficLight ctx) {
        System.out.println("Red → stop");
        ctx.setState(new GreenState());
    }
}

static class TrafficLight {
    private State state = new GreenState();

    void setState(State s) {
        state = s;
    }

    void next() {
        state.handle(this);
    }
}

void main() {
    TrafficLight tl = new TrafficLight();
    tl.next();
    tl.next();
    tl.next();
}
