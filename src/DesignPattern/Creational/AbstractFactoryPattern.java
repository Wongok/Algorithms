package DesignPattern.Creational;

// 추상 팩토리 패턴은 상세화된 서브클래스를 정의하지 않고도 서로 관련성이 있거나 독립적인 여러 객체군을 생성하기 위한 인터페이스를 제공하는 패턴
// 구현부에 신경쓰지 않고 인터페이스에 집중하여, 인터페이스만을 사용해 부품을 조립하고 제품으로 완성하는 방법
// 아래 코드의 PC나 OS와 같은 부품을 추가하려면 기존 로직도 같이 수정해야하므로 비추
// 새로운 Factory를 만드는 것은 기존 로직을 수정하지 않아도 되므로 간단함
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        NoteBookFactory macBookFactory = new MacBookFactory();
        NoteBook macBook = new NoteBook(macBookFactory.createPC(), macBookFactory.createOS());
        System.out.println("Make a MacBook!");
        macBook.getPc().pc();
        macBook.getOs().os();

        System.out.println("-------------");

        NoteBookFactory galaxyBookFactory = new GalaxyBookFactory();
        NoteBook galaxyBook = new NoteBook(galaxyBookFactory.createPC(), galaxyBookFactory.createOS());
        System.out.println("Make a Galaxy Book!");
        galaxyBook.getPc().pc();
        galaxyBook.getOs().os();
    }
}

interface OS {
    void os();
}

class MacOS implements OS {
    @Override
    public void os() {
        System.out.println("OS >>>>> MacOS");
    }
}

class Windows10 implements OS {
    @Override
    public void os() {
        System.out.println("OS >>>>> Windows");
    }
}

interface PC {
    void pc();
}

class MacBook implements PC {
    @Override
    public void pc() {
        System.out.println("PC >>>>> MacBook");
    }
}

class GalaxyBook implements PC {
    @Override
    public void pc() {
        System.out.println("PC >>>>> Galaxy Book");
    }
}

interface NoteBookFactory {
    PC createPC();
    OS createOS();
}

class MacBookFactory implements NoteBookFactory {

    @Override
    public PC createPC() {
        return new MacBook();
    }

    @Override
    public OS createOS() {
        return new MacOS();
    }
}

class GalaxyBookFactory implements NoteBookFactory {

    @Override
    public PC createPC() {
        return new GalaxyBook();
    }

    @Override
    public OS createOS() {
        return new Windows10();
    }
}

class NoteBook {
    PC pc;
    OS os;

    public NoteBook(PC pc, OS os) {
        this.pc = pc;
        this.os = os;
    }

    public PC getPc() {
        return pc;
    }

    public OS getOs() {
        return os;
    }
}