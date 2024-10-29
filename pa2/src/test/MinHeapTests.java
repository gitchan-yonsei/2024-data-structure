import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class MinHeapTests {

    @Test
    @Score(1)
    public void testBasic1() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            MinHeap heap = new MinHeap(10);
            assertThat(heap.size(), is(0));
            assertThat(heap.isEmpty(), is(true));
        });
    }

    @Test
    @Score(1)
    public void testBasic2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            MinHeap heap = new MinHeap(5);
            heap.add(10);
            heap.add(5);
            heap.add(20);
            heap.add(3);
            heap.add(15);
            assertThat(heap.size(), is(5));
            assertThat(heap.isEmpty(), is(false));
            assertThat(heap.pop(), is(3));
            assertThat(heap.pop(), is(5));
            assertThat(heap.pop(), is(10));
            assertThat(heap.pop(), is(15));
            assertThat(heap.pop(), is(20));
            assertThat(heap.isEmpty(), is(true));
        });
    }

    @Test
    @Score(1)
    public void testBasic3() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            MinHeap heap = new MinHeap(10);
            heap.add(20);
            heap.add(15);
            heap.add(30);
            heap.add(10);
            heap.add(5);
            assertThat(heap.pop(), is(5));
            assertThat(heap.pop(), is(10));
            assertThat(heap.pop(), is(15));
            assertThat(heap.pop(), is(20));
            assertThat(heap.pop(), is(30));
        });
    }
}

