package DesignPattern.Structural;

// decouple an abstraction from its implementation so that the two can vary independently.
// 추상화와 구현을 분리하여 종속관계를 피하고, 확장성을 키울 수 있음
// 사용자에게 세부적인 구현 사항을 숨길 수 있음
// Adapter는 기존의 코드를 재사용하기 위해 사용되고, Bridge는 확장성을 고려하여 미리 예상하여 bridge class를 구현
public class BridgePattern {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(new RectangleDrawing());
        Shape circle = new Circle(new CircleDrawing());

        rectangle.drawLine(1, 6);
        rectangle.fill();
        rectangle.draw();

        System.out.println("===============================");

        circle.drawLine(2, 3);
        circle.fill();
        circle.draw();
    }
}

abstract class Shape {
    private Drawing drawing;

    protected Shape(Drawing drawing) {
        this.drawing = drawing;
    }

    abstract void draw();

    void drawLine(int x, int y) {
        drawing.drawLine(x, y);
    }

    void fill() {
        drawing.fill();
    }
}

class Rectangle extends Shape {
    protected Rectangle(Drawing drawing) {
        super(drawing);
    }

    @Override
    void draw() {
        System.out.println("Draw Rectangle!");
    }
}

class Circle extends Shape {
    protected Circle(Drawing drawing) {
        super(drawing);
    }

    @Override
    void draw() {
        System.out.println("Draw Circle!");
    }
}

interface Drawing {
    void drawLine(int x, int y);
    void fill();
}

class RectangleDrawing implements Drawing {
    @Override
    public void drawLine(int x, int y) {
        System.out.println("Rectangle Draw line from " + x + " to " + y);
    }

    @Override
    public void fill() {
        System.out.println("Rectangle Fill!");
    }
}

class CircleDrawing implements Drawing {
    @Override
    public void drawLine(int x, int y) {
        System.out.println("Circle Draw line from " + x + " to " + y);
    }

    @Override
    public void fill() {
        System.out.println("Circle Fill!");
    }
}
