package DesignPattern.Structural;

import java.util.HashMap;

// 인스턴스를 가능한 한 공유해서 사용함으로써 메모리를 절약하는 패턴
// 중복 생성될 가능성이 높은 경우, 자원 생성 비용은 큰데 사용빈도가 낮은 경우
// Singleton은 종류와 상관없이 단 하나 <-> FlyWeight는 하나씩 여러종류
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