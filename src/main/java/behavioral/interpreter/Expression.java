interface Expression {
    int interpret();
}

static class NumberExpr implements Expression {
    private final int n;

    NumberExpr(int n) {
        this.n = n;
    }

    public int interpret() {
        return n;
    }
}

static class AddExpr implements Expression {
    private final Expression left, right;

    AddExpr(Expression l, Expression r) {
        left = l;
        right = r;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

static class MulExpr implements Expression {
    private final Expression left, right;

    MulExpr(Expression l, Expression r) {
        left = l;
        right = r;
    }

    public int interpret() {
        return left.interpret() * right.interpret();
    }
}

Expression expr = new MulExpr(
        new AddExpr(new NumberExpr(3), new NumberExpr(5)),
        new NumberExpr(2)
);

void main() {
    System.out.println(expr.interpret());
}
