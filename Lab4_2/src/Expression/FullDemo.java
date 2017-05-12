package Expression; /**
 * Created by rui on 27/04/17.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

import static Expression.CreateExp.*;

public class FullDemo {

    public static void main(String[] args) {
        Subs subs = new Subs();

        int m = 10;
        int n = 30;

        Exp e = add(mult(lit(3), lit(4)), lit(5));

        System.out.println(e.show() + " value is " + e.evaluate(subs));
        System.out.println(e.show() + " tree height: " + e.height());
        System.out.println(e.show() + " tree size: " + e.size());
        System.out.println(e.show() + " num of operator: " + e.operators());
        System.out.println(e.show() + " simplified as: " + e.simplify(subs).show());

        String[][] tree = new String[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(tree[i], new String(" "));
        }
        e.draw(tree, 0,n/2);
        for(int i = 0; i < m; i++){
            Arrays.stream(tree[i]).forEach(System.out::print);
            System.out.println();
        }

        subs.put("x",5);
        System.out.println("\n");

        Exp e2 =  add( mult( lit(3),  lit(4)),
                 mult( lit(5),  var("x")));
        String e2String = e2.show();
        System.out.println(e2String + " value is " + e2.evaluate(subs));
        System.out.println(e2String + " tree height: " + e2.height());
        System.out.println(e2.show() + " tree size: " + e2.size());
        System.out.println(e2.show() + " num of operator: " + e2.operators());
        System.out.println(e2.show() + " simplified as: " + e2.simplify(subs).show());

        String[][] tree2 = new String[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(tree2[i], new String(" "));
        }
        e2.draw(tree2, 0,n/2);
        for(int i = 0; i < m; i++){
            Arrays.stream(tree2[i]).forEach(System.out::print);
            System.out.println();
        }
    }
}
