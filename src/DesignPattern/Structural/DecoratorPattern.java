package DesignPattern.Structural;

// allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class.
// 기존 코드를 수정하지 않고 행동 확장 가능
// 실행 중에 새로운 행동 추가 가능
// 의미 없는 객체가 많아질 수 있어 복잡해짐
public class DecoratorPattern {
    public static void main(String[] args) {
        Component espresso = new BaseComponent();
        System.out.println("Espresso >>>>> " + espresso.add());

        Component americano = new WaterDecorator(new BaseComponent());
        System.out.println("Americano >>>>> " + americano.add());

        Component latte = new MilkDecorator(new BaseComponent());
        System.out.println("Latte >>>>> " + latte.add());
    }
}

// Component
interface Component {
    String add();
}

class BaseComponent implements Component {

    @Override
    public String add() {
        return "Espresso";
    }
}

// Decorator
abstract class Decorator implements Component {
    public Component coffeeComponent;

    public Decorator(Component coffeeComponent) {
        this.coffeeComponent = coffeeComponent;
    }

    public String add() {
        return coffeeComponent.add();
    }
}

class WaterDecorator extends Decorator {
    public WaterDecorator(Component coffeeComponent) {
        super(coffeeComponent);
    }

    @Override
    public String add() {
        return super.add() + " + Water";
    }
}

class MilkDecorator extends Decorator {
    public MilkDecorator(Component coffeeComponent) {
        super(coffeeComponent);
    }

    @Override
    public String add() {
        return super.add() + " + Milk";
    }
}
