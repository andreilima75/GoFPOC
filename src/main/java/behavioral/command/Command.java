interface Command {
    void execute();

    void undo();
}

static class Light {
    void on() {
        System.out.println("Light ON");
    }

    void off() {
        System.out.println("Light OFF");
    }
}

static class LightOn implements Command {
    private final Light light;

    LightOn(Light l) {
        this.light = l;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

static class RemoteControl {
    private Deque<Command> history = new ArrayDeque<>();

    void press(Command c) {
        c.execute();
        history.push(c);
    }

    void undoLast() {
        if (!history.isEmpty()) history.pop().undo();
    }
}

void main() {
    RemoteControl rc = new RemoteControl();
    rc.press(new LightOn(new Light()));
    rc.undoLast();
}
