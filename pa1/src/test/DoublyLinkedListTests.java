import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class DoublyLinkedListTests {
	@Test
	@Score(1)
	public void testBasic1() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			DoublyLinkedList<Integer> d = new DoublyLinkedList<Integer>();
			assertThat(d.size(), is(0));
			assertThat(d.isEmpty(), is(true));
			d.addFirst(20);
			d.addLast(24);
			assertThat(d.size(), is(2));
			assertThat(d.isEmpty(), is(false));
		});
	}

	@Test
	@Score(1)
	public void testBasic2() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			DoublyLinkedList<Integer> d = new DoublyLinkedList<Integer>();
			d.addLast(6);
			d.popFirst();
			assertThat(d.isEmpty(), is(true));
			assertThat(d.getHead(), is(nullValue()));
			assertThat(d.getTail(), is(nullValue()));
			d.addFirst(24);
			d.addLast(9);
			d.addFirst(20);
			d.addLast(26);
			assertThat(d.size(), is(4));
			assertThat(d.search(9).next.data, is(26));
			assertThat(d.popLast(), is(26));
			assertThat(d.getTail().data, is(9));
		});
	}

	@Test
	@Score(1)
	public void testBasic3() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			DoublyLinkedList<Integer> d = new DoublyLinkedList<Integer>();
			for (int i=0; i<10; i++){
				d.addLast(i);
			}
			d.searchDelete(5);
			assertThat(d.search(4).next.data, is(6));
			d.insertAfter(5, 4);
			assertThat(d.search(4).next.data, is(5));
			d.insertAfter(10, 10);
			assertThat(d.getTail().data, is(9));
			assertThat(d.size(), is(10));
			d.insertAfter(10, 9);
			assertThat(d.getTail().data, is(10));
			assertThat(d.size(), is(11));
			assertThat(d.search(9).next.data, is(10));
		});
	}
}
