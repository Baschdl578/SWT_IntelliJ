package org.jis.plugins;

public abstract class JmjrstPlugin implements Comparable<JmjrstPlugin> {

    /**
     * Menu-Text for the plugin
     *
     * @return
     */
    public abstract String getMenuText();

    public abstract String getName();

    /**
     * JMJRST pushes the main application to every subclass - so plugins are
     * allowed to look at Main as well.
     *
     * @param main
     *            JMJRST main application
     */
    public abstract void init(org.jis.Main main);

    /**
     * Run plugin
     */
    public abstract void run();

    /**
     * Returns true if the plugin can be configured.
     *
     * @return
     */
    public abstract boolean isConfigurable();

    /**
     * Open a configuration dialogue.
     */
    public abstract void configure();

    /**
     * Implement comparator functionality - plugins are compared on basis of
     * their names.
     */
    public int compareTo(JmjrstPlugin otherPlugin) {
        return this.getName().compareTo(otherPlugin.getName());
    }
}