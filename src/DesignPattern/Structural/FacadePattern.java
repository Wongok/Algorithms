package DesignPattern.Structural;

// an object that serves as a front-facing interface masking more complex underlying or structural code
// 복잡한 구조 코드에 대한 간략화된 인터페이스를 제공하는 객체
// 서브시스템을 더 쉽게 사용할 수 있도록 higher-level 인터페이스를 정의 및 제공
public class FacadePattern {
    public static void main(String[] args) {
        // AS-IS
        Computer computer = new Computer();
        Light light = new Light();
        Radio radio = new Radio();
        System.out.println("====Home In====");
        computer.turnOn();
        light.turnOn();
        radio.turnOn();

        System.out.println("====Home Out====");
        computer.turnOff();
        light.turnOff();
        radio.turnOff();

        // TO-BE : Facade
        HomeFacade facade = new HomeFacade(computer, light, radio);
        facade.homeIn();
        facade.homeOut();
    }
}

class Computer {
    private boolean power;

    public void turnOn() {
        power = true;
        System.out.println("Turn On the Computer!");
    }

    public void turnOff() {
        power = false;
        System.out.println("Turn Off the Computer!");
    }

    public boolean getPower() {
        return power;
    }
}

class Light {
    private boolean power;

    public void turnOn() {
        power = true;
        System.out.println("Turn On the Light!");
    }

    public void turnOff() {
        power = false;
        System.out.println("Turn Off the Light!");
    }

    public boolean getPower() {
        return power;
    }
}

class Radio {
    private boolean power;

    public void turnOn() {
        power = true;
        System.out.println("Turn On the Light!");
    }

    public void turnOff() {
        power = false;
        System.out.println("Turn Off the Light!");
    }

    public boolean getPower() {
        return power;
    }
}

class HomeFacade {
    private Computer computer;
    private Light light;
    private Radio radio;

    public HomeFacade(Computer computer, Light light, Radio radio) {
        this.computer = computer;
        this.light = light;
        this.radio = radio;
    }

    public void homeIn() {
        System.out.println("Home In, Turn on the Computer, Light, Radio!");
        if (!computer.getPower()) {
            computer.turnOn();
        }
        if (!light.getPower()) {
            light.turnOn();
        }
        if (!radio.getPower()) {
            radio.turnOn();
        }
    }

    public void homeOut() {
        System.out.println("Home Out, Turn off the Computer, Light, Radio!");
        if (computer.getPower()) {
            computer.turnOff();
        }
        if (light.getPower()) {
            light.turnOff();
        }
        if (radio.getPower()) {
            radio.turnOff();
        }
    }
}