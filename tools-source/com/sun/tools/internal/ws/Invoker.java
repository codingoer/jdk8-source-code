package com.sun.tools.internal.ws;

import com.sun.istack.internal.tools.MaskingClassLoader;
import com.sun.istack.internal.tools.ParallelWorldClassLoader;
import com.sun.tools.internal.ws.resources.WscompileMessages;
import com.sun.tools.internal.ws.wscompile.Options;
import com.sun.tools.internal.xjc.api.util.ToolsJarNotFoundException;
import com.sun.xml.internal.bind.util.Which;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceFeature;

public final class Invoker {
   static final String[] maskedPackages = new String[]{"com.sun.istack.internal.tools.", "com.sun.tools.internal.jxc.", "com.sun.tools.internal.xjc.", "com.sun.tools.internal.ws.", "com.sun.codemodel.internal.", "com.sun.relaxng.", "com.sun.xml.internal.xsom.", "com.sun.xml.internal.bind.", "com.ctc.wstx.", "org.codehaus.stax2.", "com.sun.xml.internal.messaging.saaj.", "com.sun.xml.internal.ws.", "com.oracle.webservices.internal.api."};
   public static final boolean noSystemProxies;

   static int invoke(String mainClass, String[] args) throws Throwable {
      if (!noSystemProxies) {
         try {
            System.setProperty("java.net.useSystemProxies", "true");
         } catch (SecurityException var16) {
         }
      }

      ClassLoader oldcc = Thread.currentThread().getContextClassLoader();

      try {
         ClassLoader cl = Invoker.class.getClassLoader();
         if (Arrays.asList(args).contains("-Xendorsed")) {
            cl = createClassLoader((ClassLoader)cl);
         } else {
            int targetArgIndex = Arrays.asList(args).indexOf("-target");
            Options.Target targetVersion;
            if (targetArgIndex != -1) {
               targetVersion = Options.Target.parse(args[targetArgIndex + 1]);
            } else {
               targetVersion = Options.Target.getDefault();
            }

            Options.Target loadedVersion = Options.Target.getLoadedAPIVersion();
            if (!loadedVersion.isLaterThan(targetVersion)) {
               if (Service.class.getClassLoader() == null) {
                  System.err.println(WscompileMessages.INVOKER_NEED_ENDORSED(loadedVersion.getVersion(), targetVersion.getVersion()));
               } else {
                  System.err.println(WscompileMessages.WRAPPER_TASK_LOADING_INCORRECT_API(loadedVersion.getVersion(), Which.which(Service.class), targetVersion.getVersion()));
               }

               byte var27 = -1;
               return var27;
            }

            List urls = new ArrayList();
            findToolsJar((ClassLoader)cl, urls);
            if (urls.size() > 0) {
               List mask = new ArrayList(Arrays.asList(maskedPackages));
               ClassLoader cl = new MaskingClassLoader((ClassLoader)cl, mask);
               ClassLoader cl = new URLClassLoader((URL[])urls.toArray(new URL[urls.size()]), cl);
               cl = new ParallelWorldClassLoader(cl, "");
            }
         }

         Thread.currentThread().setContextClassLoader((ClassLoader)cl);
         Class compileTool = ((ClassLoader)cl).loadClass(mainClass);
         Constructor ctor = compileTool.getConstructor(OutputStream.class);
         Object tool = ctor.newInstance(System.out);
         Method runMethod = compileTool.getMethod("run", String[].class);
         boolean r = (Boolean)runMethod.invoke(tool, args);
         int var9 = r ? 0 : 1;
         return var9;
      } catch (ToolsJarNotFoundException var17) {
         System.err.println(var17.getMessage());
      } catch (InvocationTargetException var18) {
         throw var18.getCause();
      } catch (ClassNotFoundException var19) {
         throw var19;
      } finally {
         Thread.currentThread().setContextClassLoader(oldcc);
      }

      return -1;
   }

   public static boolean checkIfLoading21API() {
      try {
         Service.class.getMethod("getPort", Class.class, WebServiceFeature[].class);
         return true;
      } catch (NoSuchMethodException var1) {
      } catch (LinkageError var2) {
      }

      return false;
   }

   public static boolean checkIfLoading22API() {
      try {
         Service.class.getMethod("create", URL.class, QName.class, WebServiceFeature[].class);
         return true;
      } catch (NoSuchMethodException var1) {
      } catch (LinkageError var2) {
      }

      return false;
   }

   public static ClassLoader createClassLoader(ClassLoader cl) throws ClassNotFoundException, IOException, ToolsJarNotFoundException {
      URL[] urls = findIstack22APIs(cl);
      if (urls.length == 0) {
         return cl;
      } else {
         List mask = new ArrayList(Arrays.asList(maskedPackages));
         if (urls.length > 1) {
            mask.add("javax.xml.bind.");
            mask.add("javax.xml.ws.");
         }

         ClassLoader cl = new MaskingClassLoader(cl, mask);
         ClassLoader cl = new URLClassLoader(urls, cl);
         ClassLoader cl = new ParallelWorldClassLoader(cl, "");
         return cl;
      }
   }

   private static URL[] findIstack22APIs(ClassLoader cl) throws ClassNotFoundException, IOException, ToolsJarNotFoundException {
      List urls = new ArrayList();
      if (Service.class.getClassLoader() == null) {
         URL res = cl.getResource("javax/xml/ws/EndpointContext.class");
         if (res == null) {
            throw new ClassNotFoundException("There's no JAX-WS 2.2 API in the classpath");
         }

         urls.add(ParallelWorldClassLoader.toJarUrl(res));
         res = cl.getResource("javax/xml/bind/JAXBPermission.class");
         if (res == null) {
            throw new ClassNotFoundException("There's no JAXB 2.2 API in the classpath");
         }

         urls.add(ParallelWorldClassLoader.toJarUrl(res));
      }

      findToolsJar(cl, urls);
      return (URL[])urls.toArray(new URL[urls.size()]);
   }

   private static void findToolsJar(ClassLoader cl, List urls) throws ToolsJarNotFoundException, MalformedURLException {
      try {
         Class.forName("com.sun.tools.javac.Main", false, cl);
      } catch (ClassNotFoundException var5) {
         File jreHome = new File(System.getProperty("java.home"));
         File toolsJar = new File(jreHome.getParent(), "lib/tools.jar");
         if (!toolsJar.exists()) {
            throw new ToolsJarNotFoundException(toolsJar);
         }

         urls.add(toolsJar.toURL());
      }

   }

   static {
      boolean noSysProxiesProperty = false;

      try {
         noSysProxiesProperty = Boolean.getBoolean(Invoker.class.getName() + ".noSystemProxies");
      } catch (SecurityException var5) {
      } finally {
         noSystemProxies = noSysProxiesProperty;
      }

   }
}