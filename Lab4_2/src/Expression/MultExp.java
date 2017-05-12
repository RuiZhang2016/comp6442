package Expression;

/**
 * Created by rui on 27/04/17.
 */
public class MultExp extends Exp {

    Exp left,right;

    public MultExp(Exp l, Exp r){
        left = l;
        right = r;
    }

    @Override
    public String show() {
        return "(" + left.show() + " * " + right.show() + ")";
    }

    @Override
    public int evaluate(Subs subs) {
        return left.evaluate(subs)*right.evaluate(subs);
    }

    @Override
    public int height() {
        return left.height()>right.height()? left.height()+1:right.height()+1;
    }

    @Override
    public int size() {
        return left.size()+right.size()+1;
    }

    @Override
    public int operators() {
        return left.operators()+right.operators()+1;
    }

    @Override
    public Exp simplify(Subs subs) {
        Exp leftS = left.simplify(subs);
        Exp rightS = right.simplify(subs);
        if(leftS instanceof LitExp && rightS instanceof LitExp ){
            return new LitExp(this.evaluate(subs));
        }else{
            return new MultExp(leftS, rightS);
        }
    }

    @Override
    public void draw(String[][] tree, int ii, int jj) {
        tree[ii][jj] = "*";
        for(int i = 1; i<= this.height(); i++){
            tree[ii+i][jj-i] = "-";
            tree[ii+i][jj+i] = "-";
        }

        this.left.draw(tree, ii+this.height()+1,jj-this.height()-1);
        this.right.draw(tree, ii+this.height()+1,jj+this.height()+1);
    }


}
