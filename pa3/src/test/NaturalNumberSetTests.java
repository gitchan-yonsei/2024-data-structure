import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

import java.util.Arrays;

public class NaturalNumberSetTests {
	@Test
	@Score(1)
	public void testBasic1() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			INaturalNumberSet s = new NaturalNumberSet(13, 7);
			assertThat(s.size(), is(0));
			assertThat(s.add(72), is(true));
			assertThat(s.contains(72), is(true));
			assertThat(s.contains(59), is(false));
			assertThat(s.remove(27), is(-1));
		});
	}

	@Test
	@Score(1)
	public void testBasic2() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			INaturalNumberSet s = new NaturalNumberSet(13, 7);
			assertThat(s.add(11), is(true));
			assertThat(s.add(24), is(true));
			assertThat(s.add(37), is(true));
			int[] iter = s.iterator();
			Arrays.sort(iter);
			assertThat(iter, is(new int[] { 11, 24, 37 }));
		});
	}

	@Test
	@Score(1)
	public void testBasic3() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			INaturalNumberSet two = new NaturalNumberSet(31, 13);
			INaturalNumberSet three = new NaturalNumberSet(31, 13);
			for (int i=1; i<16; i++){
				two.add(2*i);
				three.add(3*i);
			}
			two.addAll(three);
			assertThat(two.size(), is(25));
		});
	}
}
