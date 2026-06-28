interface Mediator {
    void notify(String sender, String event);
}

static class ChatRoom implements Mediator {
    private List<User> users = new ArrayList<>();

    void register(User u) {
        users.add(u);
        u.mediator = this;
    }

    public void notify(String sender, String msg) {
        users.stream()
                .filter(u -> !u.name.equals(sender))
                .forEach(u -> u.receive(sender, msg));
    }
}

static class User {
    String name;
    Mediator mediator;

    User(String n) {
        this.name = n;
    }

    void send(String msg) {
        mediator.notify(name, msg);
    }

    void receive(String from, String msg) {
        System.out.println(name + " <- " + from + ": " + msg);
    }
}

void main() {
    ChatRoom room = new ChatRoom();
    User alice = new User("Alice");
    User bob = new User("Bob");
    room.register(alice);
    room.register(bob);
    alice.send("Hello!");
}
