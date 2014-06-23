package org.jis.plugins;

import java.util.Iterator;
import java.util.List;

/**
 * Created by baschdl on 18.06.14.
 */
public class PluginIterator implements Iterable {

    class PluginIterable implements Iterator {

        private List<JmjrstPlugin> list = PluginManager.getPlugins();
        private int pos = 0;


        public boolean hasNext() {
            if (list.get(pos + 1) != null) {
                return true;
            }
            return false;
        }

        public JmjrstPlugin next() {
            pos++;
            return list.get(pos);
        }

        public void remove() {
            list.remove(pos);
        }
    }

    public Iterator<JmjrstPlugin> iterator() {
        Iterator it = new PluginIterable();
        return it;
    }
}
