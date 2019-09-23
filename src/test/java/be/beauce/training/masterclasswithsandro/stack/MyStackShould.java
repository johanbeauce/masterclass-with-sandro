package be.beauce.training.masterclasswithsandro.stack;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.beauce.training.masterclasswithsandro.stack.MyStack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyStackShould {

    private static final Object NEW_ITEM = new Object();
    private static final Object FIRST_ITEM = new Object();
    private static final Object SECOND_ITEM = new Object();

    private MyStack stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack();
    }

    @Test
    void throw_exception_if_popped_when_empty() {
        final MyStack stack = new MyStack();

        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void pop_last_pushed_item() {
        stack.push(NEW_ITEM);

        assertThat(stack.pop()).isEqualTo(NEW_ITEM);
    }

    @Test
    void pop_pushed_items_in_reverse_order() {
        stack.push(FIRST_ITEM);
        stack.push(SECOND_ITEM);

        assertThat(stack.pop()).isEqualTo(SECOND_ITEM);
        assertThat(stack.pop()).isEqualTo(FIRST_ITEM);
    }

}
