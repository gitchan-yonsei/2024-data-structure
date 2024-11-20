import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

import java.util.Comparator;
import java.util.Random;

class SkipListTests {

    public class Coin1 implements ICoin {
        private Random random;
        public Coin1() { random = new Random(); }
        public boolean toss() { return random.nextBoolean(); }
    }

    @Test
    @Score(1)
    void testBasic() {
        assertTimeoutPreemptively(
            Duration.ofSeconds(1),
            () -> {
                ISkipList<Integer> s = new SkipList<>(
                    new Coin1(), Comparator.<Integer>naturalOrder());

                for (int i = 0; i < 4; ++i)
                {
                    s.add(i);
                }

                for (int i = -3; i < 7; ++i)
                {
                    assertThat(s.contain(i), is( ( i < 0 ) ? false : ( (i > 3) ? false : true ) ));
                }

                s.delete(0);

                for (int i = -3; i < 7; ++i)
                {
                    assertThat(s.contain(i), is( ( i < 1 ) ? false : ( (i > 3) ? false : true ) ));
                }

                assertThat(s.size(), is(3));
        });
    }
}
