import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

import java.util.ArrayList;

class FindCycleTests {

    @Test
    @Score(1)
    void testBasic() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            int n = 10;
            int[][] edges = new int[][]{{2,3,4,3,0},{1,0,3,1,2}};
            UndirectedGraph g = new UndirectedGraph(n, edges);
            ArrayList<Object> s = FindCycle.findCycle(g);
			assertThat(((Vertex)(s.get(0))).getIdx(), is(0));
            assertThat(((Edge)(s.get(1))).getIdx(), is(4));
        });
    }
}
