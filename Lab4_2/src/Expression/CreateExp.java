package Expression;

/**
 * Created by rui on 25/04/17.
 */
public class CreateExp {

    public static Exp mult(Exp a, Exp b){
        return new MultExp(a,b);
    }

    public static Exp add(Exp a, Exp b){
        return new AddExp(a,b);
    }

    public static Exp lit(int i){
        return(new LitExp(i));
    }

    public static Exp var(String n){
        return new VarExp(n);
    }

}
