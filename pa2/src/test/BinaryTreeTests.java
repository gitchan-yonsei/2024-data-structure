import java.time.Duration;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class BinaryTreeTests {

    @Test
    @Score(1)
    public void testBasic1() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            BinaryTree<Integer> tree = new BinaryTree<>();
            assertThat(tree.size(), is(0));
            assertThat(tree.isEmpty(), is(true));
            assertThat(tree.getRoot(), is(nullValue()));
            tree.insert(10, "");
            assertThat(tree.size(), is(1));
            assertThat(tree.isEmpty(), is(false));
            assertThat(tree.getRoot().getValue(), is(10));
            tree.insert(5, "l");
            tree.insert(15, "r");
            assertThat(tree.size(), is(3));
            assertThat(tree.getRoot().getLeft().getValue(), is(5));
            assertThat(tree.getRoot().getRight().getValue(), is(15));
        });
    }

    @Test
    @Score(1)
    public void testBasic2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            BinaryTree<String> tree = new BinaryTree<>();
            tree.insert("M", "");
            tree.insert("B", "l");
            tree.insert("Q", "r");
            tree.insert("A", "ll");
            tree.insert("Z", "rr");
            tree.insert("C", "lr");
            tree.insert("D", "rlr");
            assertThat(tree.size(), is(6));
            assertThat(tree.getRoot().getValue(), is("M"));
            assertThat(tree.getRoot().getLeft().getValue(), is("B"));
            assertThat(tree.getRoot().getRight().getValue(), is("Q"));
            assertThat(tree.getRoot().getLeft().getLeft().getValue(), is("A"));
            assertThat(tree.getRoot().getLeft().getRight().getValue(), is("C"));
            assertThat(tree.getRoot().getRight().getRight().getValue(), is("Z"));
        });
    }

    @Test
    @Score(1)
    public void testBasic3() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            BinaryTree<Character> tree = new BinaryTree<>();
            tree.insert('c', "r");
            tree.insert('a', "");
            assertThat(tree.pop(""), is('a'));
            assertTrue(tree.isEmpty());
            assertThat(tree.getRoot(), is(nullValue()));
            tree.insert('2', "");
        });
    }
}