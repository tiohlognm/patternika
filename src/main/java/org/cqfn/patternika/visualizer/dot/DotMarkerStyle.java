package org.cqfn.patternika.visualizer.dot;

import java.util.List;
import java.util.Objects;

/**
 * Style for markers that are used to highlight nodes (possibly with multiple colors).
 *
 * @since 2021/02/16
 */
public class DotMarkerStyle implements DotWriter {
    /** Color names. */
    private final String[] colorNames = {
            "gold",
            "darkolivegreen3",
            "aquamarine3",
            "bisque2",
            "burlywood1",
            "cornsilk2",
            "lightpink2",
            "lightgoldenrod1",
            "lightskyblue2",
            "plum3",
            "rosybrown",
            "seagreen3",
            "sandybrown",
            "peachpuff3",
            "darkseagreen",
            "tomato",
            "mediumslateblue",
            "khaki",
            "cadetblue",
            "powderblue",
            "indianred"
    };

    /** The list of color markers. */
    private final List<Integer> markers;

    /**
     * Constructor.
     *
     * @param markers the list of color markers.
     */
    public DotMarkerStyle(final List<Integer> markers) {
        this.markers = Objects.requireNonNull(markers);
    }

    /**
     * Writes the marker style to the string builder.
     *
     * @param builder the string builder.
     */
    @Override
    public void write(final StringBuilder builder) {
        final boolean isSingle = markers.size() == 1;
        if (isSingle) {
            // Style for a single color.
            builder.append("style=\"rounded,filled\"");
        } else {
            // Striped style for multiple marker colors.
            builder.append("style=striped penwidth=2");
        }
        builder.append(" fillcolor=\"");
        // When multiple marker colors are used, they are separated with ':'.
        // ':' is appended to separate the current color from the previous.
        // This means that it is not appended before the first color.
        boolean isFirst = true;
        for (final Integer marker : markers) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(':');
            }
            builder.append(getColor(marker));
        }
        builder.append("\" ");
    }

    /**
     * Gets a color name by its index.
     *
     * @param index the index of a color.
     * @return the color name.
     */
    private String getColor(final int index) {
        return index < colorNames.length ? colorNames[index] : "coral";
    }

}
