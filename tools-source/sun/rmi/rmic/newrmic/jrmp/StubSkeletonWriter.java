package sun.rmi.rmic.newrmic.jrmp;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Type;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sun.rmi.rmic.newrmic.BatchEnvironment;
import sun.rmi.rmic.newrmic.IndentingWriter;

class StubSkeletonWriter {
   private final BatchEnvironment env;
   private final RemoteClass remoteClass;
   private final Constants.StubVersion version;
   private final String stubClassName;
   private final String skeletonClassName;
   private final String packageName;
   private final String stubClassSimpleName;
   private final String skeletonClassSimpleName;
   private final RemoteClass.Method[] remoteMethods;
   private final String[] methodFieldNames;

   StubSkeletonWriter(BatchEnvironment var1, RemoteClass var2, Constants.StubVersion var3) {
      this.env = var1;
      this.remoteClass = var2;
      this.version = var3;
      this.stubClassName = Util.binaryNameOf(var2.classDoc()) + "_Stub";
      this.skeletonClassName = Util.binaryNameOf(var2.classDoc()) + "_Skel";
      int var4 = this.stubClassName.lastIndexOf(46);
      this.packageName = var4 != -1 ? this.stubClassName.substring(0, var4) : "";
      this.stubClassSimpleName = this.stubClassName.substring(var4 + 1);
      this.skeletonClassSimpleName = this.skeletonClassName.substring(var4 + 1);
      this.remoteMethods = var2.remoteMethods();
      this.methodFieldNames = nameMethodFields(this.remoteMethods);
   }

   String stubClassName() {
      return this.stubClassName;
   }

   String skeletonClassName() {
      return this.skeletonClassName;
   }

   void writeStub(IndentingWriter var1) throws IOException {
      var1.pln("// Stub class generated by rmic, do not edit.");
      var1.pln("// Contents subject to change without notice.");
      var1.pln();
      if (!this.packageName.equals("")) {
         var1.pln("package " + this.packageName + ";");
         var1.pln();
      }

      var1.plnI("public final class " + this.stubClassSimpleName);
      var1.pln("extends java.rmi.server.RemoteStub");
      ClassDoc[] var2 = this.remoteClass.remoteInterfaces();
      int var3;
      if (var2.length > 0) {
         var1.p("implements ");

         for(var3 = 0; var3 < var2.length; ++var3) {
            if (var3 > 0) {
               var1.p(", ");
            }

            var1.p(var2[var3].qualifiedName());
         }

         var1.pln();
      }

      var1.pOlnI("{");
      if (this.version == Constants.StubVersion.V1_1 || this.version == Constants.StubVersion.VCOMPAT) {
         this.writeOperationsArray(var1);
         var1.pln();
         this.writeInterfaceHash(var1);
         var1.pln();
      }

      if (this.version == Constants.StubVersion.VCOMPAT || this.version == Constants.StubVersion.V1_2) {
         var1.pln("private static final long serialVersionUID = 2;");
         var1.pln();
         if (this.methodFieldNames.length > 0) {
            if (this.version == Constants.StubVersion.VCOMPAT) {
               var1.pln("private static boolean useNewInvoke;");
            }

            this.writeMethodFieldDeclarations(var1);
            var1.pln();
            var1.plnI("static {");
            var1.plnI("try {");
            if (this.version == Constants.StubVersion.VCOMPAT) {
               var1.plnI("java.rmi.server.RemoteRef.class.getMethod(\"invoke\",");
               var1.plnI("new java.lang.Class[] {");
               var1.pln("java.rmi.Remote.class,");
               var1.pln("java.lang.reflect.Method.class,");
               var1.pln("java.lang.Object[].class,");
               var1.pln("long.class");
               var1.pOln("});");
               var1.pO();
               var1.pln("useNewInvoke = true;");
            }

            this.writeMethodFieldInitializers(var1);
            var1.pOlnI("} catch (java.lang.NoSuchMethodException e) {");
            if (this.version == Constants.StubVersion.VCOMPAT) {
               var1.pln("useNewInvoke = false;");
            } else {
               var1.plnI("throw new java.lang.NoSuchMethodError(");
               var1.pln("\"stub class initialization failed\");");
               var1.pO();
            }

            var1.pOln("}");
            var1.pOln("}");
            var1.pln();
         }
      }

      this.writeStubConstructors(var1);
      var1.pln();
      if (this.remoteMethods.length > 0) {
         var1.pln("// methods from remote interfaces");

         for(var3 = 0; var3 < this.remoteMethods.length; ++var3) {
            var1.pln();
            this.writeStubMethod(var1, var3);
         }
      }

      var1.pOln("}");
   }

   private void writeStubConstructors(IndentingWriter var1) throws IOException {
      var1.pln("// constructors");
      if (this.version == Constants.StubVersion.V1_1 || this.version == Constants.StubVersion.VCOMPAT) {
         var1.plnI("public " + this.stubClassSimpleName + "() {");
         var1.pln("super();");
         var1.pOln("}");
      }

      var1.plnI("public " + this.stubClassSimpleName + "(" + "java.rmi.server.RemoteRef" + " ref) {");
      var1.pln("super(ref);");
      var1.pOln("}");
   }

   private void writeStubMethod(IndentingWriter var1, int var2) throws IOException {
      RemoteClass.Method var3 = this.remoteMethods[var2];
      MethodDoc var4 = var3.methodDoc();
      String var5 = var4.name();
      Type[] var6 = var3.parameterTypes();
      String[] var7 = nameParameters(var6);
      Type var8 = var4.returnType();
      ClassDoc[] var9 = var3.exceptionTypes();
      var1.pln("// implementation of " + Util.getFriendlyUnqualifiedSignature(var4));
      var1.p("public " + var8.toString() + " " + var5 + "(");

      int var10;
      for(var10 = 0; var10 < var6.length; ++var10) {
         if (var10 > 0) {
            var1.p(", ");
         }

         var1.p(var6[var10].toString() + " " + var7[var10]);
      }

      var1.plnI(")");
      if (var9.length > 0) {
         var1.p("throws ");

         for(var10 = 0; var10 < var9.length; ++var10) {
            if (var10 > 0) {
               var1.p(", ");
            }

            var1.p(var9[var10].qualifiedName());
         }

         var1.pln();
      }

      var1.pOlnI("{");
      List var13 = this.computeUniqueCatchList(var9);
      if (var13.size() > 0) {
         var1.plnI("try {");
      }

      if (this.version == Constants.StubVersion.VCOMPAT) {
         var1.plnI("if (useNewInvoke) {");
      }

      if (this.version == Constants.StubVersion.VCOMPAT || this.version == Constants.StubVersion.V1_2) {
         if (!Util.isVoid(var8)) {
            var1.p("Object $result = ");
         }

         var1.p("ref.invoke(this, " + this.methodFieldNames[var2] + ", ");
         if (var6.length <= 0) {
            var1.p("null");
         } else {
            var1.p("new java.lang.Object[] {");

            for(int var11 = 0; var11 < var6.length; ++var11) {
               if (var11 > 0) {
                  var1.p(", ");
               }

               var1.p(wrapArgumentCode(var6[var11], var7[var11]));
            }

            var1.p("}");
         }

         var1.pln(", " + var3.methodHash() + "L);");
         if (!Util.isVoid(var8)) {
            var1.pln("return " + unwrapArgumentCode(var8, "$result") + ";");
         }
      }

      if (this.version == Constants.StubVersion.VCOMPAT) {
         var1.pOlnI("} else {");
      }

      if (this.version == Constants.StubVersion.V1_1 || this.version == Constants.StubVersion.VCOMPAT) {
         var1.pln("java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, " + var2 + ", interfaceHash);");
         if (var6.length > 0) {
            var1.plnI("try {");
            var1.pln("java.io.ObjectOutput out = call.getOutputStream();");
            writeMarshalArguments(var1, "out", var6, var7);
            var1.pOlnI("} catch (java.io.IOException e) {");
            var1.pln("throw new java.rmi.MarshalException(\"error marshalling arguments\", e);");
            var1.pOln("}");
         }

         var1.pln("ref.invoke(call);");
         if (Util.isVoid(var8)) {
            var1.pln("ref.done(call);");
         } else {
            var1.pln(var8.toString() + " $result;");
            var1.plnI("try {");
            var1.pln("java.io.ObjectInput in = call.getInputStream();");
            boolean var14 = writeUnmarshalArgument(var1, "in", var8, "$result");
            var1.pln(";");
            var1.pOlnI("} catch (java.io.IOException e) {");
            var1.pln("throw new java.rmi.UnmarshalException(\"error unmarshalling return\", e);");
            if (var14) {
               var1.pOlnI("} catch (java.lang.ClassNotFoundException e) {");
               var1.pln("throw new java.rmi.UnmarshalException(\"error unmarshalling return\", e);");
            }

            var1.pOlnI("} finally {");
            var1.pln("ref.done(call);");
            var1.pOln("}");
            var1.pln("return $result;");
         }
      }

      if (this.version == Constants.StubVersion.VCOMPAT) {
         var1.pOln("}");
      }

      if (var13.size() > 0) {
         Iterator var15 = var13.iterator();

         while(var15.hasNext()) {
            ClassDoc var12 = (ClassDoc)var15.next();
            var1.pOlnI("} catch (" + var12.qualifiedName() + " e) {");
            var1.pln("throw e;");
         }

         var1.pOlnI("} catch (java.lang.Exception e) {");
         var1.pln("throw new java.rmi.UnexpectedException(\"undeclared checked exception\", e);");
         var1.pOln("}");
      }

      var1.pOln("}");
   }

   private List computeUniqueCatchList(ClassDoc[] var1) {
      ArrayList var2 = new ArrayList();
      var2.add(this.env.docRuntimeException());
      var2.add(this.env.docRemoteException());
      ClassDoc[] var3 = var1;
      int var4 = var1.length;

      label35:
      for(int var5 = 0; var5 < var4; ++var5) {
         ClassDoc var6 = var3[var5];
         if (this.env.docException().subclassOf(var6)) {
            var2.clear();
            break;
         }

         if (var6.subclassOf(this.env.docException())) {
            Iterator var7 = var2.iterator();

            while(var7.hasNext()) {
               ClassDoc var8 = (ClassDoc)var7.next();
               if (var6.subclassOf(var8)) {
                  continue label35;
               }

               if (var8.subclassOf(var6)) {
                  var7.remove();
               }
            }

            var2.add(var6);
         }
      }

      return var2;
   }

   void writeSkeleton(IndentingWriter var1) throws IOException {
      if (this.version == Constants.StubVersion.V1_2) {
         throw new AssertionError("should not generate skeleton for version " + this.version);
      } else {
         var1.pln("// Skeleton class generated by rmic, do not edit.");
         var1.pln("// Contents subject to change without notice.");
         var1.pln();
         if (!this.packageName.equals("")) {
            var1.pln("package " + this.packageName + ";");
            var1.pln();
         }

         var1.plnI("public final class " + this.skeletonClassSimpleName);
         var1.pln("implements java.rmi.server.Skeleton");
         var1.pOlnI("{");
         this.writeOperationsArray(var1);
         var1.pln();
         this.writeInterfaceHash(var1);
         var1.pln();
         var1.plnI("public java.rmi.server.Operation[] getOperations() {");
         var1.pln("return (java.rmi.server.Operation[]) operations.clone();");
         var1.pOln("}");
         var1.pln();
         var1.plnI("public void dispatch(java.rmi.Remote obj, java.rmi.server.RemoteCall call, int opnum, long hash)");
         var1.pln("throws java.lang.Exception");
         var1.pOlnI("{");
         int var2;
         if (this.version == Constants.StubVersion.VCOMPAT) {
            var1.plnI("if (opnum < 0) {");
            if (this.remoteMethods.length > 0) {
               for(var2 = 0; var2 < this.remoteMethods.length; ++var2) {
                  if (var2 > 0) {
                     var1.pO("} else ");
                  }

                  var1.plnI("if (hash == " + this.remoteMethods[var2].methodHash() + "L) {");
                  var1.pln("opnum = " + var2 + ";");
               }

               var1.pOlnI("} else {");
            }

            var1.pln("throw new java.rmi.UnmarshalException(\"invalid method hash\");");
            if (this.remoteMethods.length > 0) {
               var1.pOln("}");
            }

            var1.pOlnI("} else {");
         }

         var1.plnI("if (hash != interfaceHash)");
         var1.pln("throw new java.rmi.server.SkeletonMismatchException(\"interface hash mismatch\");");
         var1.pO();
         if (this.version == Constants.StubVersion.VCOMPAT) {
            var1.pOln("}");
         }

         var1.pln();
         if (!this.remoteClass.classDoc().isPrivate()) {
            var1.pln(this.remoteClass.classDoc().qualifiedName() + " server = (" + this.remoteClass.classDoc().qualifiedName() + ") obj;");
         }

         var1.plnI("switch (opnum) {");

         for(var2 = 0; var2 < this.remoteMethods.length; ++var2) {
            this.writeSkeletonDispatchCase(var1, var2);
         }

         var1.pOlnI("default:");
         var1.pln("throw new java.rmi.UnmarshalException(\"invalid method number\");");
         var1.pOln("}");
         var1.pOln("}");
         var1.pOln("}");
      }
   }

   private void writeSkeletonDispatchCase(IndentingWriter var1, int var2) throws IOException {
      RemoteClass.Method var3 = this.remoteMethods[var2];
      MethodDoc var4 = var3.methodDoc();
      String var5 = var4.name();
      Type[] var6 = var3.parameterTypes();
      String[] var7 = nameParameters(var6);
      Type var8 = var4.returnType();
      var1.pOlnI("case " + var2 + ": // " + Util.getFriendlyUnqualifiedSignature(var4));
      var1.pOlnI("{");
      if (var6.length > 0) {
         for(int var9 = 0; var9 < var6.length; ++var9) {
            var1.pln(var6[var9].toString() + " " + var7[var9] + ";");
         }

         var1.plnI("try {");
         var1.pln("java.io.ObjectInput in = call.getInputStream();");
         boolean var11 = writeUnmarshalArguments(var1, "in", var6, var7);
         var1.pOlnI("} catch (java.io.IOException e) {");
         var1.pln("throw new java.rmi.UnmarshalException(\"error unmarshalling arguments\", e);");
         if (var11) {
            var1.pOlnI("} catch (java.lang.ClassNotFoundException e) {");
            var1.pln("throw new java.rmi.UnmarshalException(\"error unmarshalling arguments\", e);");
         }

         var1.pOlnI("} finally {");
         var1.pln("call.releaseInputStream();");
         var1.pOln("}");
      } else {
         var1.pln("call.releaseInputStream();");
      }

      if (!Util.isVoid(var8)) {
         var1.p(var8.toString() + " $result = ");
      }

      String var12 = this.remoteClass.classDoc().isPrivate() ? "((" + var4.containingClass().qualifiedName() + ") obj)" : "server";
      var1.p(var12 + "." + var5 + "(");

      for(int var10 = 0; var10 < var7.length; ++var10) {
         if (var10 > 0) {
            var1.p(", ");
         }

         var1.p(var7[var10]);
      }

      var1.pln(");");
      var1.plnI("try {");
      if (!Util.isVoid(var8)) {
         var1.p("java.io.ObjectOutput out = ");
      }

      var1.pln("call.getResultStream(true);");
      if (!Util.isVoid(var8)) {
         writeMarshalArgument(var1, "out", var8, "$result");
         var1.pln(";");
      }

      var1.pOlnI("} catch (java.io.IOException e) {");
      var1.pln("throw new java.rmi.MarshalException(\"error marshalling return\", e);");
      var1.pOln("}");
      var1.pln("break;");
      var1.pOlnI("}");
      var1.pln();
   }

   private void writeOperationsArray(IndentingWriter var1) throws IOException {
      var1.plnI("private static final java.rmi.server.Operation[] operations = {");

      for(int var2 = 0; var2 < this.remoteMethods.length; ++var2) {
         if (var2 > 0) {
            var1.pln(",");
         }

         var1.p("new java.rmi.server.Operation(\"" + this.remoteMethods[var2].operationString() + "\")");
      }

      var1.pln();
      var1.pOln("};");
   }

   private void writeInterfaceHash(IndentingWriter var1) throws IOException {
      var1.pln("private static final long interfaceHash = " + this.remoteClass.interfaceHash() + "L;");
   }

   private void writeMethodFieldDeclarations(IndentingWriter var1) throws IOException {
      String[] var2 = this.methodFieldNames;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         var1.pln("private static java.lang.reflect.Method " + var5 + ";");
      }

   }

   private void writeMethodFieldInitializers(IndentingWriter var1) throws IOException {
      for(int var2 = 0; var2 < this.methodFieldNames.length; ++var2) {
         var1.p(this.methodFieldNames[var2] + " = ");
         RemoteClass.Method var3 = this.remoteMethods[var2];
         MethodDoc var4 = var3.methodDoc();
         String var5 = var4.name();
         Type[] var6 = var3.parameterTypes();
         var1.p(var4.containingClass().qualifiedName() + ".class.getMethod(\"" + var5 + "\", new java.lang.Class[] {");

         for(int var7 = 0; var7 < var6.length; ++var7) {
            if (var7 > 0) {
               var1.p(", ");
            }

            var1.p(var6[var7].toString() + ".class");
         }

         var1.pln("});");
      }

   }

   private static String[] nameMethodFields(RemoteClass.Method[] var0) {
      String[] var1 = new String[var0.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = "$method_" + var0[var2].methodDoc().name() + "_" + var2;
      }

      return var1;
   }

   private static String[] nameParameters(Type[] var0) {
      String[] var1 = new String[var0.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = "$param_" + generateNameFromType(var0[var2]) + "_" + (var2 + 1);
      }

      return var1;
   }

   private static String generateNameFromType(Type var0) {
      String var1 = var0.typeName().replace('.', '$');
      int var2 = var0.dimension().length() / 2;

      for(int var3 = 0; var3 < var2; ++var3) {
         var1 = "arrayOf_" + var1;
      }

      return var1;
   }

   private static void writeMarshalArgument(IndentingWriter var0, String var1, Type var2, String var3) throws IOException {
      if (var2.dimension().length() <= 0 && var2.asClassDoc() == null) {
         if (var2.typeName().equals("boolean")) {
            var0.p(var1 + ".writeBoolean(" + var3 + ")");
         } else if (var2.typeName().equals("byte")) {
            var0.p(var1 + ".writeByte(" + var3 + ")");
         } else if (var2.typeName().equals("char")) {
            var0.p(var1 + ".writeChar(" + var3 + ")");
         } else if (var2.typeName().equals("short")) {
            var0.p(var1 + ".writeShort(" + var3 + ")");
         } else if (var2.typeName().equals("int")) {
            var0.p(var1 + ".writeInt(" + var3 + ")");
         } else if (var2.typeName().equals("long")) {
            var0.p(var1 + ".writeLong(" + var3 + ")");
         } else if (var2.typeName().equals("float")) {
            var0.p(var1 + ".writeFloat(" + var3 + ")");
         } else {
            if (!var2.typeName().equals("double")) {
               throw new AssertionError(var2);
            }

            var0.p(var1 + ".writeDouble(" + var3 + ")");
         }
      } else {
         var0.p(var1 + ".writeObject(" + var3 + ")");
      }

   }

   private static void writeMarshalArguments(IndentingWriter var0, String var1, Type[] var2, String[] var3) throws IOException {
      assert var2.length == var3.length;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         writeMarshalArgument(var0, var1, var2[var4], var3[var4]);
         var0.pln(";");
      }

   }

   private static boolean writeUnmarshalArgument(IndentingWriter var0, String var1, Type var2, String var3) throws IOException {
      boolean var4 = false;
      if (var3 != null) {
         var0.p(var3 + " = ");
      }

      if (var2.dimension().length() <= 0 && var2.asClassDoc() == null) {
         if (var2.typeName().equals("boolean")) {
            var0.p(var1 + ".readBoolean()");
         } else if (var2.typeName().equals("byte")) {
            var0.p(var1 + ".readByte()");
         } else if (var2.typeName().equals("char")) {
            var0.p(var1 + ".readChar()");
         } else if (var2.typeName().equals("short")) {
            var0.p(var1 + ".readShort()");
         } else if (var2.typeName().equals("int")) {
            var0.p(var1 + ".readInt()");
         } else if (var2.typeName().equals("long")) {
            var0.p(var1 + ".readLong()");
         } else if (var2.typeName().equals("float")) {
            var0.p(var1 + ".readFloat()");
         } else {
            if (!var2.typeName().equals("double")) {
               throw new AssertionError(var2);
            }

            var0.p(var1 + ".readDouble()");
         }
      } else {
         var0.p("(" + var2.toString() + ") " + var1 + ".readObject()");
         var4 = true;
      }

      return var4;
   }

   private static boolean writeUnmarshalArguments(IndentingWriter var0, String var1, Type[] var2, String[] var3) throws IOException {
      assert var2.length == var3.length;

      boolean var4 = false;

      for(int var5 = 0; var5 < var2.length; ++var5) {
         if (writeUnmarshalArgument(var0, var1, var2[var5], var3[var5])) {
            var4 = true;
         }

         var0.pln(";");
      }

      return var4;
   }

   private static String wrapArgumentCode(Type var0, String var1) {
      if (var0.dimension().length() <= 0 && var0.asClassDoc() == null) {
         if (var0.typeName().equals("boolean")) {
            return "(" + var1 + " ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE)";
         } else if (var0.typeName().equals("byte")) {
            return "new java.lang.Byte(" + var1 + ")";
         } else if (var0.typeName().equals("char")) {
            return "new java.lang.Character(" + var1 + ")";
         } else if (var0.typeName().equals("short")) {
            return "new java.lang.Short(" + var1 + ")";
         } else if (var0.typeName().equals("int")) {
            return "new java.lang.Integer(" + var1 + ")";
         } else if (var0.typeName().equals("long")) {
            return "new java.lang.Long(" + var1 + ")";
         } else if (var0.typeName().equals("float")) {
            return "new java.lang.Float(" + var1 + ")";
         } else if (var0.typeName().equals("double")) {
            return "new java.lang.Double(" + var1 + ")";
         } else {
            throw new AssertionError(var0);
         }
      } else {
         return var1;
      }
   }

   private static String unwrapArgumentCode(Type var0, String var1) {
      if (var0.dimension().length() <= 0 && var0.asClassDoc() == null) {
         if (var0.typeName().equals("boolean")) {
            return "((java.lang.Boolean) " + var1 + ").booleanValue()";
         } else if (var0.typeName().equals("byte")) {
            return "((java.lang.Byte) " + var1 + ").byteValue()";
         } else if (var0.typeName().equals("char")) {
            return "((java.lang.Character) " + var1 + ").charValue()";
         } else if (var0.typeName().equals("short")) {
            return "((java.lang.Short) " + var1 + ").shortValue()";
         } else if (var0.typeName().equals("int")) {
            return "((java.lang.Integer) " + var1 + ").intValue()";
         } else if (var0.typeName().equals("long")) {
            return "((java.lang.Long) " + var1 + ").longValue()";
         } else if (var0.typeName().equals("float")) {
            return "((java.lang.Float) " + var1 + ").floatValue()";
         } else if (var0.typeName().equals("double")) {
            return "((java.lang.Double) " + var1 + ").doubleValue()";
         } else {
            throw new AssertionError(var0);
         }
      } else {
         return "((" + var0.toString() + ") " + var1 + ")";
      }
   }
}