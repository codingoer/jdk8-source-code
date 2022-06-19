package sun.tools.jstat;

import java.util.Comparator;
import sun.jvmstat.monitor.Monitor;

class AscendingMonitorComparator implements Comparator {
   public int compare(Monitor var1, Monitor var2) {
      String var3 = var1.getName();
      String var4 = var2.getName();
      return var3.compareTo(var4);
   }
}
