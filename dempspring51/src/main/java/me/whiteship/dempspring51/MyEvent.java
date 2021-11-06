package me.whiteship.dempspring51;

// 이 이벤트를 발생시킬 수 있는 기능을 ApplicationContext 가 가지고 있다. (ApplicationEventPublisher)
// Spring 4.2 부터는 ApplicationEvent 상속을 생략할 수 있다.
public class MyEvent {

    private int data;

    private Object source;

    // 원하는 데이터를 담아서 보낼 수 있다
    public MyEvent(Object source, int data) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}
