package DesignPattern.Structural;

// allows the interface of an existing class to be used as another interface.
// 이미 존재하는 클래스의 소스코드를 수정하지 않고 작동(호환)할 수 있도록 함
// Client와 Adaptee를 그대로 두고 Adapter class를 만들어 연결하여 사용
public class AdapterPattern {
    public static void main(String[] args) {
        /* Old Source  */
        WebClient client = new WebClient(new OldWebRequester());
        client.doWork();

        /* New Source  */
        WebAdapter adapter = new WebAdapter(new NewRequester());
        WebClient client2= new WebClient(adapter);
        client2.doWork();
    }
}

interface WebRequester {
    void requestHandler();
}

class WebClient {
    private WebRequester webRequester;

    WebClient(WebRequester webRequester) {
        this.webRequester = webRequester;
    }

    void doWork() {
        webRequester.requestHandler();
    }
}

class OldWebRequester implements WebRequester {
    @Override
    public void requestHandler() {
        System.out.println("request >>>>> OldWebRequester!");
    }
}

class NewRequester {
    void newRequestHandler() {
        System.out.println("request >>>>> NewRequestHandler is called!");
    }
}

class WebAdapter implements WebRequester {
    private NewRequester newRequester;

    WebAdapter(NewRequester newRequester) {
        this.newRequester = newRequester;
    }

    @Override
    public void requestHandler() {
        newRequester.newRequestHandler();
    }
}