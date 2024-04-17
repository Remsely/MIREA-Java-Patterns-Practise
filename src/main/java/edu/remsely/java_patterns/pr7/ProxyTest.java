package edu.remsely.java_patterns.pr7;


interface Image {
    void display();
}

class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        load(fileName);
    }

    private void load(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {
    private final String fileName;
    private Image image;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(fileName);
        }
        image.display();
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("./remsely/image.jpg");
        image.display();
        System.out.println();
        image.display();
    }
}
