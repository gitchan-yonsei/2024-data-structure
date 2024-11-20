import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class DoubleHashMapTests {
	@Test
	@Score(1)
	public void testBasic1() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IDoubleHashMap m = new DoubleHashMap(13, 7);
			assertThat(m.size(), is(0));
			assertThat(m.isEmpty(), is(true));
		});
	}

	@Test
	@Score(1)
	public void testBasic2() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IDoubleHashMap m = new DoubleHashMap(13, 7);
			assertThat(m.get(72), is(nullValue()));
			assertThat(m.put(59, "hello"), is(nullValue()));
			assertThat(m.put(59, "world"), is("hello"));
			assertThat(m.get(59), is("world"));
			assertThat(m.remove(59), is("world"));
		});
	}
}
