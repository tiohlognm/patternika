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
     * Used to avoid explicit dependency on classes that implement holes.
     */
    private final Predicate<Node> hole;

    /**
     * Main constructor.
     *
     * @param hole a predicate that checks whether a node is a hole.
     */
    public DeepMatches(final Predicate<Node> hole) {
        this.hole = Objects.requireNonNull(hole);
    }

    /**
     * Default constructor.
     * <p>
     * Does not take holes into account.
     */
    public DeepMatches() {
        this(x -> false);
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
        // If both arguments refer to the same instance, they match.
        if (root1 == root2) {
            return true;
        }
        // Matching node trees must have matching root nodes.
        if (root1 == null || !root1.matches(root2)) {
            return false;
        }
        // If one of the root nodes is a hole, the node trees are considered matching.
        if (hole.test(root1) || hole.test(root2)) {
            return true;
        }
        // In matching node trees, roots must have matching children.
        return testChildren(root1, root2);
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
