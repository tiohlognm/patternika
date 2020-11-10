package org.cqfn.patternika.ast;

import java.util.Iterator;
import java.util.Objects;

/**
 * Iterable for a node, which allows iterating over tree nodes
 * in a BFS (breadth-first search) manner.
 *
 * @param <T> Exact node type, {@link Node} or its subclass.
 *
 * @since 2020/11/3
 */
public class Bfs<T extends Node> implements Iterable<T> {
    /** Node tree root. */
    private final T root;

    /**
     * Constructor.
     *
     * @param root Node tree root.
     */
    public Bfs(final T root) {
        this.root = Objects.requireNonNull(root);
    }

    /**
     * Returns a BFS iterator over the tree nodes.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new BfsIterator<>(root);
    }

}
