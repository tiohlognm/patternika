package org.cqfn.patternika.ast;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Predicate for checking that two node trees match.
 *
 * @since 2020/11/5
 */
public class DeepMatches implements BiPredicate<Node, Node> {
    /**
     * Predicate for checking whether a node is a hole.
     * Used to avoid explicit dependency on the Hole interface.
     */
    private final Predicate<Node> isHole;

    /**
     * Predicate for checking that two nodes match.
     * Allows using different matching criteria.
     */
    private final BiPredicate<Node, Node> isMatch;

    /**
     * Constructor.
     *
     * @param isHole a predicate that checks whether a node is a hole.
     * @param isMatch a predicate for checking that two nodes match.
     */
    public DeepMatches(final Predicate<Node> isHole, final BiPredicate<Node, Node> isMatch) {
        this.isHole = Objects.requireNonNull(isHole);
        this.isMatch = Objects.requireNonNull(isMatch);
    }

    /**
     * Checks whether two node trees match (recursively).
     *
     * @param root1 the first node tree.
     * @param root2 the second node tree.
     * @return {@code true} if the node trees match or {@code false} otherwise.
     */
    @Override
    public boolean test(final Node root1, final Node root2) {
        // Matching node trees must have matching root nodes.
        if (!testNodes(root1, root2)) {
            return false;
        }
        // If one of the root nodes is a hole, the node trees are considered matching.
        if (isHole.test(root1) || isHole.test(root2)) {
            return true;
        }
        // In matching node trees, roots must have matching children.
        return testChildren(root1, root2);
    }

    /**
     * Checks whether two nodes match (their children are not taken into account).
     *
     * @param node1 the first node.
     * @param node2 the second node.
     * @return {@code true} if the nodes match or {@code false} otherwise.
     */
    private boolean testNodes(final Node node1, final Node node2) {
        if (node1 == node2) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return isMatch.test(node1, node2);
    }

    /**
     * Checks whether children of two nodes match.
     *
     * @param root1 the first node.
     * @param root2 the second node.
     * @return {@code true} if children of the nodes match or {@code false} otherwise.
     */
    private boolean testChildren(final Node root1, final Node root2) {
        final int count1 = root1.getChildCount();
        final int count2 = root2.getChildCount();
        if (count1 != count2) {
            return false;
        }
        for (int index = 0; index < count1; ++index) {
            // Children must match recursively.
            if (!test(root1.getChild(index), root2.getChild(index))) {
                return false;
            }
        }
        return true;
    }

}
