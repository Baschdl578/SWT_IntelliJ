package org.jis.plugins;

import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Iterator;

/**
 * Manages all plugins
 */
public class PluginManager {

    private static PluginManager manager;
    private ServiceLoader<JmjrstPlugin> loader;

    private PluginManager() {
        loader = ServiceLoader.load(JmjrstPlugin.class);
    }

    /**
     * Load all available plugins for JMJRST and return them sorted by their
     * name.
     *
     * @return A List of all plugins, sorted alphabetically
     *
     */
    public static List<JmjrstPlugin> getPlugins() {
        List<JmjrstPlugin> plugins = new LinkedList<JmjrstPlugin>();
        Iterator iter = getInstance().loader.iterator();
        System.out.println(((JmjrstPlugin) iter.next()).getName());
        if (iter.hasNext()) {
            JmjrstPlugin plugin = (JmjrstPlugin) iter.next();
            plugins.add(plugin);




            System.out.println(plugin.getName());




        }
        while (iter.hasNext()) {
            JmjrstPlugin plugin = (JmjrstPlugin) iter.next();
            for (int i = 0; i < plugins.size(); i++) {
                if (plugin.compareTo(plugins.get(i)) <= 0) {
                    plugins.add(i, plugin);
                    continue;
                }
            }
        }
        return plugins;
    }

    public static synchronized PluginManager getInstance() {
        if (manager == null) {
            manager = new PluginManager();
        }
        return manager;
    }

}