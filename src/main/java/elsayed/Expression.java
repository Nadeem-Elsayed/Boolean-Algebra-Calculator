package elsayed;

public class Expression{
    // public final boolean[] OR = {false, true, true, true};
    // public final boolean[] AND = {false, false, false, true};
    // public final boolean[] IMPL = {true, true, false, true};
    // public final boolean[] EQUIV = {true, false, false, true};
    // public final boolean[] CAUSE = {true, false, true, true};
    public final int OR = 0;
    public final int AND = 1;
    public final int IMPL = 2;
    public final int EQUIV = 3;
    public final int CAUSE = 4;

    private boolean solution;
    /*
     * Truth tables contain 4 values, each consisting of:
     * 1 for true
     * 0 for false
     */
    public Expression(boolean x, int operator, boolean y){
        switch (operator) {
            case OR:
                solution = or(x, y);
                break;
            case AND:
                solution = and(x, y);
                break;
            case IMPL:
                solution = impl(x, y);
            case EQUIV:
                solution = equiv(x, y);
            case CAUSE:
                solution = cause(x, y);
            default:
                solution = false;
        }
    }
    /*
     * These Methods Compare Truth Tables to Each Other
     */
    public static boolean and(boolean x, boolean y){
        if (x && y){
            return true;
        } else {
            return false;
        }
    }
    public static boolean or(boolean x, boolean y){
        if (x||y){
            return true;
        } else {
            return false;
        }
    }
    public static boolean not(boolean x){
        return !x;
    }
    public static boolean equiv(boolean x, boolean y){
        if (x==y){
            return true;
        } else {
            return false;
        }
    }
    public static boolean impl(boolean x, boolean y){
        if (!x || y){
            return true;
        } else {
            return false;
        }
    }
    public static boolean cause(boolean x, boolean y){
        if (!y || x){
            return true;
        } else {
            return false;
        }
    }
    public boolean getSolution(){
        return this.solution;
    }
}
