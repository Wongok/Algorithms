package DesignPattern.Structural;

// a class functioning as an interface to something else
// 어떤 클래스에 접근해 주요 기능이 수행되기 전에, 부가적인 전처리 단계를 수행
// 접근 조절, 비용 절감, 복잡도 감소
// 빈번한 객체 생성으로인한 성능 저하, 가독성이 안좋아 질 수 있음
public class ProxyPattern {
    public static void main(String[] args) {
        ProxyImage image1 = new ProxyImage("ProxyPattern.java");
        ProxyImage image2 = new ProxyImage("test.java");

        image1.displayImages();
        image2.displayImages();
    }
}

interface Image {
    void displayImages();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
    }

    public void loadFromDisk(String fileName) {
        System.out.println("Loading >>>>> " + fileName);
    }

    @Override
    public void displayImages() {
        System.out.println("Display >>>>> " + fileName);
    }
}

class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void displayImages() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.displayImages();
    }
}