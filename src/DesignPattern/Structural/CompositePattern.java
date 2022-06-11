package DesignPattern.Structural;

import java.util.ArrayList;

// describes a group of objects that are treated the same way as a single instance of the same type of object.
// 부분-전체 구조로 여러 객체들을 트리 구조로 표현 (소유 개념)
public class CompositePattern {
    public static void main(String[] args) {
        // Initialize four File
        File file1 = new File("Singleton.java", 11);
        File file2 = new File("Prototype.java", 22);
        File file3 = new File("AdapterPattern.java", 33);
        File file4 = new File("BridgePattern.java", 44);

        // Initialize three Directory
        Directory src = new Directory("src");
        Directory dir = new Directory("DesignPattern");
        Directory dir1 = new Directory("Creational");
        Directory dir2 = new Directory("Structural");

        dir1.add(file1);    // children - leaf
        dir1.add(file2);    // children - leaf
        dir2.add(file3);    // children - leaf
        dir2.add(file4);    // children - leaf

        dir.add(dir1);      // children - composite
        dir.add(dir2);      // children - composite
        src.add(dir);       // children - composite


        dir1.printList("dir1 >>>>> ");
        dir2.printList("dir2 >>>>> ");
        dir.printList("dir >>>>> ");

        src.printList("src >>>>> ");
    }
}

// Component
abstract class Entry {
    abstract String getName();

    abstract int getSize();

    Entry add(Entry entry) throws Exception {
        throw new Exception();
    }

    void printList() {
        printList("");
    }

    abstract void printList(String prefix);

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}

// Composite
class Directory extends Entry {
    private String name;
    private ArrayList<Entry> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        int size = 0;
        for(Entry entry : children) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        children.add(entry);
        return this;
    }

    @Override
    void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : children) {
            entry.printList(prefix + "/" + name);
        }
    }
}

// Leaf
class File extends Entry {
    private String name;
    private int size;


    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}