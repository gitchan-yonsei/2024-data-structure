import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class TableCatchTests {
	@Test
	@Score(1)
	public void testBasic1() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			TableCatch t = new TableCatch();
			assertThat(t.numWaiting(), is(0));
			t.startWaiting(7);
			t.startWaiting(3);
			t.startWaiting(2);
			assertThat(t.numWaiting(), is(3));
			assertThat(t.seatOpened(4), is(2));
			assertThat(t.numWaiting(), is(2));
		});
	}

	@Test
	@Score(1)
	public void testBasic2() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			TableCatch t = new TableCatch();
			for (int i=10; i>0; i--){
				t.startWaiting(i);
			}
			for (int i=1; i<=10; i++){
				t.stopWaiting(i);
			}
			assertThat(t.seatOpened(999), is(-1));
			t.startWaiting(6);
			assertThat(t.howManyGroupsAhead(11), is(0));
			assertThat(t.seatOpened(2), is(-1));
			assertThat(t.seatOpened(999), is(11));
		});
	}

	@Test
	@Score(1)
	public void testBasic3() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			TableCatch t = new TableCatch();
			for (int i=10; i>0; i--){
				t.startWaiting(i);
			}
			assertThat(t.numWaiting(), is(10));
			assertThat(t.howManyGroupsAhead(6), is(5));
			assertThat(t.seatOpened(5), is(6));
			assertThat(t.howManyGroupsAhead(6), is(9));
		});
	}
}
