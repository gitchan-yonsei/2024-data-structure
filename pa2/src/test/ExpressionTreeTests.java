import java.time.Duration;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class ExpressionTreeTests {

    @Test
    @Score(1)
    public void testBasic1() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ExpressionTree tree = new ExpressionTree(new String[]{});
            assertThat(tree.getRoot(), is(nullValue()));
            assertThat(tree.size(), is(0));
        });
    }

    @Test
    @Score(1)
    public void testBasic2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ExpressionTree tree = new ExpressionTree(new String[]{"(","3","+","4",")","*","2"});
            assertThat(tree.size(), is(5));
            assertThat(tree.getRoot().getValue(), is("*"));
            assertThat(tree.getRoot().getLeft().getValue(), is("+"));
            assertThat(tree.getRoot().getRight().getValue(), is("2"));
            assertThat(tree.getRoot().getLeft().getLeft().getValue(), is("3"));
            assertThat(tree.getRoot().getLeft().getRight().getValue(), is("4"));
        });
    }

    @Test
    @Score(1)
    public void testBasic3() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            ExpressionTree tree = new ExpressionTree(new String[]{"3","+","4"});
            assertThat(tree.infixNotation().trim(), is("( 3 + 4 )"));
            assertThat(tree.prefixNotation().trim(), is("+ 3 4"));
            assertThat(tree.postfixNotation().trim(), is("3 4 +"));
        });
    }
}