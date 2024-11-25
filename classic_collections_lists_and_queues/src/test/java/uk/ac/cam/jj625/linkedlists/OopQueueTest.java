package uk.ac.cam.jj625.linkedlists;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class OopQueueTest {
    @Test
    public void oopQueue_pop_throwsNoSuchOnEmpty() {
        // ARRANGE
        var empty = new LinkQueue<Integer>();
        // ACT

        // ASSERT
        assertThrows(NoSuchElementException.class, empty::pop);
    }
    @Test
    public void oopQueue_returns_one() {
        // ARRANGE
        var a = new LinkQueue<Integer>();
        // ACT
        a.push(1);
        Integer b = a.pop();

        // ASSERT
        assertThat(b).isEqualTo(1);
    }
    @Test
    public void oopQueue_returns_inOrder() {
        // ARRANGE
        var a = new LinkQueue<Integer>();
        // ACT
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);

        Integer b = a.pop();
        Integer c = a.pop();
        Integer d = a.pop();
        Integer e = a.pop();


        // ASSERT
        assertThat(b).isEqualTo(1);
        assertThat(c).isEqualTo(2);
        assertThat(d).isEqualTo(3);
        assertThat(e).isEqualTo(4);
    }
}
