package org.cqfn.patternika.ast;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.cqfn.patternika.source.Fragment;

/**
 * Node for testing tree processing logic.
 *
 * @since 2020/11/9
 */
public class TestNode implements Node {
    /** Code fragment associated with the current node, can be {@code null} in tests. */
    private final Fragment fragment;
    /** Node type. */
    private final String type;
    /** Node data. */
    private final String data;
    /** List of node children. */
    private final List<Node> children;

    /**
     * Main constructor.
     *
     * @param fragment fragment, can be {@code null}.
     * @param type node type.
     * @param data node data.
     * @param children node children.
     */
    public TestNode(
            final Fragment fragment,
            final String type,
            final String data,
            final List<Node> children) {
        this.fragment = fragment;
        this.type = Objects.requireNonNull(type);
        this.data = data;
        this.children = Objects.requireNonNull(children);
    }

    /**
     * Additional constructor.
     * <p>
     * Data has an integer type to simplify tests.
     *
     * @param type node type.
     * @param data node data.
     * @param children node children.
     */
    public TestNode(final String type, final int data, final List<Node> children) {
        this(null, type, Integer.toString(data), children);
    }

    /**
     * Additional constructor.
     *
     * @param type node type.
     * @param data node data.
     * @param children array of children.
     */
    public TestNode(final String type, final int data, final Node... children) {
        this(type, data, Arrays.asList(children));
    }

    /**
     * Additional constructor with a default node type.
     *
     * @param data node data.
     * @param children array of children.
     */
    public TestNode(final int data, final List<Node> children) {
        this("TestNode", data, children);
    }

    /**
     * Additional constructor with a default node type.
     *
     * @param data node data.
     * @param children array of children.
     */
    public TestNode(final int data, final Node... children) {
        this(data, Arrays.asList(children));
    }

    /**
     * Returns node type identifier that uniquely identifies node type.
     *
     * @return node type identifier.
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Returns data associated with the node (in a textual format).
     *
     * @return node data.
     */
    @Override
    public String getData() {
        return data;
    }

    /**
     * Returns the fragment associated with the current node.
     *
     * @return {@code null} because test nodes do not have fragments.
     */
    @Override
    public Fragment getFragment() {
        return fragment;
    }

    /**
     * Returns the number of children.
     *
     * @return child node count.
     */
    @Override
    public int getChildCount() {
        return children.size();
    }

    /**
     * Gets a child by its index.
     *
     * @param index child index.
     * @return child node.
     */
    @Override
    public Node getChild(final int index) {
        return children.get(index);
    }

    /**
     * Checks whether the current node matches the specified node.
     *
     * @param other node to be checked for match with the current node.
     * @return {@code true} if the nodes match or {@code false} otherwise.
     */
    @Override
    public boolean matches(final Node other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        return getType().equals(other.getType())
                && Objects.equals(this.getData(), other.getData());
    }

    /**
     * Checks the current object for equality with the given object.
     * <p>
     * Takes into account the following properties: type, data, and child count.
     *
     * @param obj the given object.
     * @return {@code true} or {@code false}.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final TestNode other = (TestNode) obj;
        return Objects.equals(this.type, other.type)
            && Objects.equals(this.data, other.data)
            && this.children.size() == other.children.size();
    }

    /**
     * Returns hash code for the current object.
     *
     * @return hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, data, children.size());
    }

    /**
     * Returns textual representation of the node. Helpful for debugging.
     * <p>
     * Text contains: class name, node type, node data, child count, and object identity hash code.
     * This allows identifying specific nodes among similar nodes and identical nodes.
     *
     * @return textual representation of the node.
     */
    @Override
    public String toString() {
        return String.format(
                "%s {'%s', '%s', %d} @%s",
                getClass().getSimpleName(),
                type,
                data,
                getChildCount(),
                Integer.toHexString(System.identityHashCode(this))
            );
    }

}
