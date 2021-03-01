package org.cqfn.patternika.util.cmdline;

import java.util.List;

/**
 * An option with or without arguments.
 *
 * @since 2020/11/18
 */
public interface Option {
    /**
     * @return the option name.
     */
    String getName();

    /**
     * @return the count of arguments required for the option.
     */
    int getArgumentCount();

    /**
     * @return the list of options that must be specified together with this option.
     */
    List<Option> getRelatedRequiredOptions();

    /**
     * @return {@code true} if option is global or {@code false} otherwise.
     */
    boolean isGlobal();

}