package com.sun.tools.javac.main;

import com.sun.tools.javac.util.ListBuffer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class CommandLine {
   public static String[] parse(String[] var0) throws IOException {
      ListBuffer var1 = new ListBuffer();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         String var3 = var0[var2];
         if (var3.length() > 1 && var3.charAt(0) == '@') {
            var3 = var3.substring(1);
            if (var3.charAt(0) == '@') {
               var1.append(var3);
            } else {
               loadCmdFile(var3, var1);
            }
         } else {
            var1.append(var3);
         }
      }

      return (String[])var1.toList().toArray(new String[var1.length()]);
   }

   private static void loadCmdFile(String var0, ListBuffer var1) throws IOException {
      BufferedReader var2 = new BufferedReader(new FileReader(var0));
      StreamTokenizer var3 = new StreamTokenizer(var2);
      var3.resetSyntax();
      var3.wordChars(32, 255);
      var3.whitespaceChars(0, 32);
      var3.commentChar(35);
      var3.quoteChar(34);
      var3.quoteChar(39);

      while(var3.nextToken() != -1) {
         var1.append(var3.sval);
      }

      var2.close();
   }
}
