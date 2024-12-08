import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

import java.util.ArrayList;

public class SuffixTriesTests {
	@Test
	@Score(1)
	public void testBasic1() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			ISuffixTries s =new SuffixTries("xabxac");
			ArrayList<String> suffixes = s.allSuffixes();
			assertThat(suffixes.size(), is(6));
			assertThat(suffixes.get(0).equals("abxac"), is(true));
		});
	}

	@Test
	@Score(1)
	public void testBasic2() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			ISuffixTries s =new SuffixTries("xabxac");
			assertThat(s.match("bxac"), is(true));
			assertThat(s.match("ababab"), is(false));
		});
	}
}
