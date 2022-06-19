package com.sun.tools.internal.xjc;

import com.sun.istack.internal.Nullable;

public class BadCommandLineException extends Exception {
   private Options options;

   public BadCommandLineException(String msg) {
      super(msg);
   }

   public BadCommandLineException(String message, Throwable cause) {
      super(message, cause);
   }

   public BadCommandLineException() {
      this((String)null);
   }

   public void initOptions(Options opt) {
      assert this.options == null;

      this.options = opt;
   }

   @Nullable
   public Options getOptions() {
      return this.options;
   }
}