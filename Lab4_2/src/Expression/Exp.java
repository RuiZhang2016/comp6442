package Expression;

/**
 * Created by rui on 27/04/17.
 */
public abstract class Exp {

    public abstract String show();

    public abstract int evaluate(Subs subs);

    public abstract int height();
    public abstract int size();
    public abstract int operators();

    public abstract Exp simplify(Subs subs);

    public abstract void draw(String[][] tree, int ii, int jj);
}
