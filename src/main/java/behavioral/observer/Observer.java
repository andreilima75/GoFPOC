interface Observer {
    void update(String event);
}

static class EventSource {
    private final List<Observer> observers = new ArrayList<>();

    void subscribe(Observer o) {
        observers.add(o);
    }

    void unsubscribe(Observer o) {
        observers.remove(o);
    }

    void emit() {
        observers.forEach(o -> o.update("user.login"));
    }
}

static class Logger implements Observer {
    public void update(String e) {
        System.out.println("LOG: " + e);
    }
}

static class Alerter implements Observer {
    public void update(String e) {
        System.out.println("ALERT: " + e);
    }
}

void main() {
    EventSource src = new EventSource();
    src.subscribe(new Logger());
    src.subscribe(new Alerter());
    src.emit();
}
