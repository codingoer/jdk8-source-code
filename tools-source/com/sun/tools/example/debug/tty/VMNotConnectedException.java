package com.sun.tools.example.debug.tty;

public class VMNotConnectedException extends RuntimeException {
   private static final long serialVersionUID = -7433430494903950165L;

   public VMNotConnectedException() {
   }

   public VMNotConnectedException(String var1) {
      super(var1);
   }
}