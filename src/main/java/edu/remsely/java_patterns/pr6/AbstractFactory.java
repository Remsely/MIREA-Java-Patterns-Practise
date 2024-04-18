package edu.remsely.java_patterns.pr6;

interface Button {
    void paint();
}

interface Widget {
    void paint();
}

class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("MacOSButton");
    }
}

class MacOSWidget implements Widget {
    @Override
    public void paint() {
        System.out.println("MacOSWidget");
    }
}

class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("WindowsButton");
    }
}

class WindowsWidget implements Widget {
    @Override
    public void paint() {
        System.out.println("WindowsWidget");
    }
}

interface GUIFactory {
    Button createButton();
    Widget createWidget();
}

class MacOSGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Widget createWidget() {
        return new MacOSWidget();
    }
}

class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Widget createWidget() {
        return new WindowsWidget();
    }
}

public class AbstractFactory {
    private final Button button;
    private final Widget widget;

    public AbstractFactory(GUIFactory factory) {
        this.button = factory.createButton();
        this.widget = factory.createWidget();
    }

    public void paint() {
        button.paint();
        widget.paint();
    }

    public static void main(String[] args) {
        AbstractFactory test = new AbstractFactory(new MacOSGUIFactory());
        test.paint();

        test = new AbstractFactory(new WindowsGUIFactory());
        test.paint();
    }
}
