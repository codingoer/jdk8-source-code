package com.sun.xml.internal.rngom.binary;

import javax.xml.namespace.QName;
import org.xml.sax.Locator;

final class RestrictionViolationException extends Exception {
   private String messageId;
   private Locator loc;
   private QName name;

   RestrictionViolationException(String messageId) {
      this.messageId = messageId;
   }

   RestrictionViolationException(String messageId, QName name) {
      this.messageId = messageId;
      this.name = name;
   }

   String getMessageId() {
      return this.messageId;
   }

   Locator getLocator() {
      return this.loc;
   }

   void maybeSetLocator(Locator loc) {
      if (this.loc == null) {
         this.loc = loc;
      }

   }

   QName getName() {
      return this.name;
   }
}
