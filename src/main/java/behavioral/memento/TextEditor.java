static class TextEditor {
    private String text = "";

    void type(String t) {
        text += t;
    }

    String getText() {
        return text;
    }

    record Memento(String state) {
    }

    Memento save() {
        return new Memento(text);
    }

    void restore(Memento m) {
        text = m.state();
    }
}

static class History {
    private final Deque<TextEditor.Memento> stack = new ArrayDeque<>();

    void push(TextEditor.Memento m) {
        stack.push(m);
    }

    TextEditor.Memento pop() {
        return stack.pop();
    }
}

void main() {
    TextEditor ed = new TextEditor();
    History hist = new History();
    ed.type("Hello");
    hist.push(ed.save());
    ed.type(" World");
    System.out.println(ed.getText());
    ed.restore(hist.pop());
    System.out.println(ed.getText());
}
