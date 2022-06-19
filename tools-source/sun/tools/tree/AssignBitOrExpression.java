package sun.tools.tree;

import sun.tools.asm.Assembler;
import sun.tools.java.Environment;

public class AssignBitOrExpression extends AssignOpExpression {
   public AssignBitOrExpression(long var1, Expression var3, Expression var4) {
      super(11, var1, var3, var4);
   }

   void codeOperation(Environment var1, Context var2, Assembler var3) {
      var3.add(this.where, 128 + this.itype.getTypeCodeOffset());
   }
}
