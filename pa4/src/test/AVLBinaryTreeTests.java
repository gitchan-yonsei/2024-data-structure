import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

import java.util.Arrays;

public class AVLBinaryTreeTests {
	@Test
	@Score(1)
	public void testBasic1() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IAVLBinaryTree t = new AVLBinaryTree();
			assertThat(t.size(), is(0));
			assertThat(t.isEmpty(), is(true));
			t.put(72);
			assertThat(t.contains(72), is(true));
			assertThat(t.contains(22), is(false));
		});
	}

	@Test
	@Score(1)
	public void testBasic2() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IAVLBinaryTree t = new AVLBinaryTree();
			for (int i=0; i<6; i++){
				t.put(i);
			}
			assertThat(t.getHeight(), is(3));
			assertThat(t.size(), is(6));
		});
	}

	@Test
	@Score(1)
	public void testBasic3() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IAVLBinaryTree t = new AVLBinaryTree();
			for (int i=-10; i<10; i++){
				t.put(i);
			}
			t.remove(0);
			t.remove(1);
			assertThat(t.getHeight(), is(5));
			t.remove(1);
			assertThat(t.size(), is(18));
			t.remove(-3);
			t.remove(-7);
			t.remove(9);
			assertThat(t.getHeight(), is(5));
			t.remove(2);
			assertThat(t.getHeight(), is(4));
		});
	}
}
