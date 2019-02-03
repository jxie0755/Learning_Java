package OOP_Test_Para;

import W3C_basic.C05_OOP_Public_A;
import W3C_basic.C05_OOP_Static;

public class OOP_Test_Public_Para {
    public static void main(String[] args) {

        // Test public
        C05_OOP_Public_A A = new C05_OOP_Public_A();
        // C05_OOP_Internal_B B = new C05_OOP_Internal_B();  // 内部类不能被任何访问
        // C05_OOP_Not_Public_C C = new C05_OOP_Not_Public_C();  // 不是public所以不能被import


        // Test static // 只要是public都可以
        C05_OOP_Static AA = new C05_OOP_Static();   // 真正原因是因为这里造了一个实例,非static的变量和方法必须被实例使用
        System.out.println(AA.fooo);
        System.out.println(AA.barrr);
        AA.foo();
        AA.fooo_barrr();
        // 直接从类出发:
        System.out.println(C05_OOP_Static.fooo);       // 由于fooo是static所以可以直接被call
        C05_OOP_Static.foo();                          // 同上
        // System.out.println(C05_OOP_Static.barrr);   // 由于barrr不是static所以不行
        // C05_OOP_Static.fooo_barrr();                // 同上


    }
}

