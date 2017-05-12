package Expression;

/**
 * Created by rui on 27/04/17.
 */
public class VarExp extends Exp {

    String name;

    public VarExp (String n){
        name = n;
    }

    @Override
    public String show() {
        return name+"";
    }

    @Override
    public int evaluate(Subs subs) {
        return subs.get(name);
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public int operators() {
        return 0;
    }

    @Override
    public Exp simplify(Subs subs) {
        return this;
    }

    @Override
    public void draw(String[][] tree, int ii, int jj) {
        tree[ii][jj] = this.show();
    }
}
