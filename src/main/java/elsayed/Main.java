package elsayed;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * This program does boolean algebra
 * Nadeem Elsayed
 */
public class Main 
{
    public static void main( String[] args ) {
        System.out.println("Enter propositional logic Ex:");
        System.out.println("(~x1 + x2) * (x1 =>x2) === x1 <= x2");
        String logic = expressionInput();
        
    }
    /*
     * returns all the variables in a statement
     * only returns one copy of each variable
     */
    public static ArrayList<String> findVariables(String expression){
        Pattern patt = Pattern.compile("[^*+=><!()& ]+");
        Matcher m = patt.matcher(expression);
        ArrayList<String> variables = new ArrayList<String>();
        String match;
        while (m.find()){
            match = m.group();
            if (!variables.contains(match)){
                variables.add(match);
            }
        }
        if (variables.size() == 0){
            return null;
        } else {
            return variables;
        }
    }
    /*
     * checks if the symbols in an expression are all recognized
     */
    public static boolean checkSymbols(String expression){
        //all the symbols I don't want to see
        Pattern patt = Pattern.compile("[@#$%^-_\\[\\]{}'\";:.,\\/`]+");
        Matcher m = patt.matcher(expression);
        if (m.find()){
            return false;
        } else {
            return true;
        }
    }
    /*
     * checks if the brackets match in a string
     */
    public static boolean checkBrackets(List<List<String>> list){
        ArrayList<String> arl = new ArrayList<String>();
        int lcounter = 0;
        int rcounter = 0;
        for (int i = 0; i<arl.size(); i++) {
            if (arl.get(i).equals("(")){
                lcounter++;
            } else {
                rcounter++;
            }
        }
        if (lcounter == rcounter) {
            return true;
        } else {
            return false;
        }
    }
    /* 
     *returns 2D arraylist of brackets with indices
     */
    public static List<List<String>> getBrackets(String expression){
        List<List<String>> arl_double = new ArrayList<List<String>>();
        arl_double.add(new ArrayList<String>());
        arl_double.add(new ArrayList<String>());
        
        String letter;
        for (int i = 0; i<expression.length(); i++){
            letter = expression.substring(i,i+1);
            if (letter.equals("(") || letter.equals(")")){
                arl_double.get(0).add(letter);
                arl_double.get(1).add(Integer.toString(i));
            }
        }
        return arl_double;
    }
    /*
     * solves an operation using the Expression class
     */
    public static boolean solveExpression(String expression){
        return true;
    }
    /*
     * takes out an expression to be solved
     */
    public static Expression extractExpression(String expression, List<List<String>> arl_double, ArrayList<String> variables){
        return null;
    }
    /*
     * asks the user for a proper expression
     */
    public static String expressionInput(){
        Scanner input = new Scanner(System.in);
        String response;
        do {
            response = input.nextLine().replaceAll(" ", "");
            if (checkSymbols(response) && checkBrackets(getBrackets(response))){
                break;
            } else if (!checkSymbols(response)){
                System.out.println("Unrecognized Symbol");
            } else {
                System.out.println("Missing or extra bracket");
            }
        } while (true);
        return response;
    }
    /*
     * asks the user for a proper integer input
     */
    public static int IntInput(){
        Scanner input = new Scanner(System.in);
        int response;
        do {
            if (input.hasNextInt()){
                response = input.nextInt();
                break;
            } else {
                System.out.println("Enter a proper Integer");
            }
        } while (true);
        return response;
    }
}
