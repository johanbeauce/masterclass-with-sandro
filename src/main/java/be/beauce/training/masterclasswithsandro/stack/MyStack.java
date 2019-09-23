package be.beauce.training.masterclasswithsandro.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack {

    private List items = new ArrayList();

    public Object pop() {
        if (items.isEmpty()) {
            throw new EmptyStackException();
        }
        int lastItemIndex = items.size() -1;
        return items.remove(lastItemIndex);
    }

    public void push(Object item) {
        items.add(item);
    }
}
