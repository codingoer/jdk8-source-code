package com.sun.tools.example.debug.tty;

public class LineNotFoundException extends Exception {
   private static final long serialVersionUID = 3748297722519448995L;

   public LineNotFoundException() {
   }

   public LineNotFoundException(String var1) {
      super(var1);
   }
}