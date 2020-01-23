package DesignPattern.Creational;

// Factory Method Design Pattern
// When the implementation of an interface or an abstract class is expected to change frequently
// When the current implementation cannot comfortably accommodate new change
// When the initialization process is relatively simple, and the constructor only requires a handful of parameters
public class FactoryPattern {
    public static void main(String[] args) {
        PolygonFactory polygonFactory = new PolygonFactory();

        Polygon p1 = polygonFactory.getPolygon(3);
        System.out.println(p1.getType()); // Triangle!

        Polygon p2 = polygonFactory.getPolygon(5);
        System.out.println(p2.getType()); // Pentagon!

        Polygon p3 = polygonFactory.getPolygon(7);
        System.out.println(p3.getType()); // Heptagon!
    }
}

interface Polygon {
    String getType();
}

class PolygonFactory {
    //use getPolygon method to get object of types of polygons
    public Polygon getPolygon(int numberOfSides) {
        if(numberOfSides == 3) {
            return new Triangle();
        }
        if(numberOfSides == 4) {
            return new Square();
        }
        if(numberOfSides == 5) {
            return new Pentagon();
        }
        if(numberOfSides == 6) {
            return new Hexagon();
        }
        if(numberOfSides == 7) {
            return new Heptagon();
        }
        if(numberOfSides == 8) {
            return new Octagon();
        }
        return null;
    }
}

class Triangle implements Polygon{
    @Override
    public String getType() {
        return "Triangle!";
    }
}

class Square implements Polygon{
    @Override
    public String getType() {
        return "Square!";
    }
}

class Pentagon implements Polygon{
    @Override
    public String getType() {
        return "Pentagon!";
    }
}

class Hexagon implements Polygon{
    @Override
    public String getType() {
        return "Hexagon!";
    }
}

class Heptagon implements Polygon{
    @Override
    public String getType() {
        return "Heptagon!";
    }
}

class Octagon implements Polygon{
    @Override
    public String getType() {
        return "Octagon!";
    }
}

