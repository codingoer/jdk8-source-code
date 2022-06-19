package com.sun.tools.internal.ws.processor.generator;

import com.sun.codemodel.internal.ClassType;
import com.sun.codemodel.internal.JAnnotationUse;
import com.sun.codemodel.internal.JClassAlreadyExistsException;
import com.sun.codemodel.internal.JCodeModel;
import com.sun.codemodel.internal.JDefinedClass;
import com.sun.tools.internal.ws.ToolVersion;
import com.sun.tools.internal.ws.processor.model.Block;
import com.sun.tools.internal.ws.processor.model.Fault;
import com.sun.tools.internal.ws.processor.model.Model;
import com.sun.tools.internal.ws.processor.model.ModelVisitor;
import com.sun.tools.internal.ws.processor.model.Operation;
import com.sun.tools.internal.ws.processor.model.Parameter;
import com.sun.tools.internal.ws.processor.model.Port;
import com.sun.tools.internal.ws.processor.model.Request;
import com.sun.tools.internal.ws.processor.model.Response;
import com.sun.tools.internal.ws.processor.model.Service;
import com.sun.tools.internal.ws.processor.util.DirectoryUtil;
import com.sun.tools.internal.ws.processor.util.IndentingWriter;
import com.sun.tools.internal.ws.wscompile.ErrorReceiver;
import com.sun.tools.internal.ws.wscompile.WsimportOptions;
import com.sun.xml.internal.ws.util.xml.XmlUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.processing.Filer;
import javax.jws.HandlerChain;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public abstract class GeneratorBase implements ModelVisitor {
   private File destDir;
   private String targetVersion;
   protected boolean donotOverride;
   protected JCodeModel cm;
   protected Model model;
   protected String wsdlLocation;
   protected ErrorReceiver receiver;
   protected WsimportOptions options;

   protected GeneratorBase() {
   }

   public void init(Model model, WsimportOptions options, ErrorReceiver receiver) {
      this.model = model;
      this.options = options;
      this.destDir = options.destDir;
      this.receiver = receiver;
      this.wsdlLocation = options.wsdlLocation;
      this.targetVersion = options.target.getVersion();
      this.cm = options.getCodeModel();
   }

   public void doGeneration() {
      try {
         this.model.accept(this);
      } catch (Exception var2) {
         this.receiver.error(var2);
      }

   }

   public void visit(Model model) throws Exception {
      Iterator var2 = model.getServices().iterator();

      while(var2.hasNext()) {
         Service service = (Service)var2.next();
         service.accept(this);
      }

   }

   public void visit(Service service) throws Exception {
      Iterator var2 = service.getPorts().iterator();

      while(var2.hasNext()) {
         Port port = (Port)var2.next();
         port.accept(this);
      }

   }

   public void visit(Port port) throws Exception {
      Iterator var2 = port.getOperations().iterator();

      while(var2.hasNext()) {
         Operation operation = (Operation)var2.next();
         operation.accept(this);
      }

   }

   public void visit(Operation operation) throws Exception {
      operation.getRequest().accept(this);
      if (operation.getResponse() != null) {
         operation.getResponse().accept(this);
      }

      Iterator faults = operation.getFaultsSet().iterator();
      if (faults != null) {
         while(faults.hasNext()) {
            Fault fault = (Fault)faults.next();
            fault.accept(this);
         }
      }

   }

   public void visit(Parameter param) throws Exception {
   }

   public void visit(Block block) throws Exception {
   }

   public void visit(Response response) throws Exception {
   }

   public void visit(Request request) throws Exception {
   }

   public void visit(Fault fault) throws Exception {
   }

   public List getJAXWSClassComment() {
      return getJAXWSClassComment(this.targetVersion);
   }

   public static List getJAXWSClassComment(String targetVersion) {
      List comments = new ArrayList();
      comments.add("This class was generated by the JAX-WS RI.\n");
      comments.add(ToolVersion.VERSION.BUILD_VERSION + "\n");
      comments.add("Generated source version: " + targetVersion);
      return comments;
   }

   protected JDefinedClass getClass(String className, ClassType type) throws JClassAlreadyExistsException {
      JDefinedClass cls;
      try {
         cls = this.cm._class(className, type);
      } catch (JClassAlreadyExistsException var5) {
         cls = this.cm._getClass(className);
         if (cls == null) {
            throw var5;
         }
      }

      return cls;
   }

   protected void log(String msg) {
      if (this.options.verbose) {
         System.out.println("[" + Names.stripQualifier(this.getClass().getName()) + ": " + msg + "]");
      }

   }

   protected void writeHandlerConfig(String className, JDefinedClass cls, WsimportOptions options) {
      Element e = options.getHandlerChainConfiguration();
      if (e != null) {
         JAnnotationUse handlerChainAnn = cls.annotate(this.cm.ref(HandlerChain.class));
         NodeList nl = e.getElementsByTagNameNS("http://java.sun.com/xml/ns/javaee", "handler-chain");
         if (nl.getLength() > 0) {
            String fName = this.getHandlerConfigFileName(className);
            handlerChainAnn.param("file", fName);
            this.generateHandlerChainFile(e, className);
         }

      }
   }

   private String getHandlerConfigFileName(String fullName) {
      String name = Names.stripQualifier(fullName);
      return name + "_handler.xml";
   }

   private void generateHandlerChainFile(Element hChains, String name) {
      Filer filer = this.options.filer;

      try {
         IndentingWriter p;
         if (filer != null) {
            FileObject jfo = filer.createResource(StandardLocation.SOURCE_OUTPUT, Names.getPackageName(name), this.getHandlerConfigFileName(name), new javax.lang.model.element.Element[0]);
            this.options.addGeneratedFile(new File(jfo.toUri()));
            p = new IndentingWriter(new OutputStreamWriter(jfo.openOutputStream()));
         } else {
            String hcName = this.getHandlerConfigFileName(name);
            File packageDir = DirectoryUtil.getOutputDirectoryFor(name, this.destDir);
            File hcFile = new File(packageDir, hcName);
            this.options.addGeneratedFile(hcFile);
            p = new IndentingWriter(new OutputStreamWriter(new FileOutputStream(hcFile)));
         }

         Transformer it = XmlUtil.newTransformer();
         it.setOutputProperty("method", "xml");
         it.setOutputProperty("indent", "yes");
         it.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
         it.setOutputProperty("encoding", "UTF-8");
         it.transform(new DOMSource(hChains), new StreamResult(p));
         p.close();
      } catch (Exception var9) {
         throw new GeneratorException("generator.nestedGeneratorError", new Object[]{var9});
      }
   }
}
