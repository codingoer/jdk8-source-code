package com.sun.tools.internal.ws.wsdl.document;

public final class OperationStyle {
   public static final OperationStyle ONE_WAY = new OperationStyle();
   public static final OperationStyle REQUEST_RESPONSE = new OperationStyle();
   public static final OperationStyle SOLICIT_RESPONSE = new OperationStyle();
   public static final OperationStyle NOTIFICATION = new OperationStyle();

   private OperationStyle() {
   }
}
