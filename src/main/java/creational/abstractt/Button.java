interface Button {
    void render();
}

interface Checkbox {
    void render();
}

static class WinButton implements Button {
    public void render() {
        System.out.println("Win creational.abstractt.Button");
    }
}

static class MacButton implements Button {
    public void render() {
        System.out.println("Mac creational.abstractt.Button");
    }
}

static class WinCheckbox implements Checkbox {
    public void render() {
        System.out.println("Win Checkbox");
    }
}

static class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Mac Checkbox");
    }
}

interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

static class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }

    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

static class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

void main() {
    GUIFactory factory = new WindowsFactory();
    factory.createButton().render();

    GUIFactory factory2 = new MacFactory();
    factory2.createButton().render();
}