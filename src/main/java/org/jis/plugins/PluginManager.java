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
        if (iter.hasNext()) {
            JmjrstPlugin plugin = (JmjrstPlugin) iter.next();
            plugins.add(plugin);
        }
        while (iter.hasNext()) {
            JmjrstPlugin plugin = (JmjrstPlugin) iter.next();
            boolean cont = true;
            for (int i = 0; i < plugins.size(); i++) {
                if (cont && plugin.compareTo(plugins.get(i)) <= 0) {
                    plugins.add(i, plugin);
                    cont = false;
                    continue;
                }
            }
            if (cont == true) {
                plugins.add(plugin);
                continue;
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