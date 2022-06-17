package DesignPattern.Structural;

import java.util.HashMap;

public class FlyWeightPattern {
    public static void main(String[] args) {
        Tree tree1 = TreeFactory.getTree("green");
        tree1.setX(1);
        tree1.setY(2);
        tree1.install();

        Tree tree2 = TreeFactory.getTree("blue");
        tree2.setX(3);
        tree2.setY(7);
        tree2.install();

        Tree tree3 = TreeFactory.getTree("green");
        tree3.setX(10);
        tree3.setY(20);
        tree3.install();
    }
}

class Tree {
    private String color;
    private int x;
    private int y;

    public Tree(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void install() {
        System.out.println("Location >>>>> (" + x + ", " + y + ") " + "Color >>>>> " + color);
    }
}

class TreeFactory {
    public static final HashMap<String, Tree> treeMap = new HashMap<>();

    public static Tree getTree(String treeColor) {
        Tree tree = (Tree) treeMap.get(treeColor);

        if (tree == null) {
            tree = new Tree(treeColor);
            treeMap.put(treeColor, tree);
            System.out.println("Make new Tree >>>>> " + treeColor);
        }

        return tree;
    }
}