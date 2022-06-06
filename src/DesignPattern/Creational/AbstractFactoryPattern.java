package DesignPattern.Creational;

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