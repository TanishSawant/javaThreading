import java.text.MessageFormat;
import java.util.HashMap;

public class infix_p {
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static int evaluatePostFixExpression(String exp, HashMap<Character, Integer> map) {
        System.out.println(exp);
        StackPointers<Integer> stack = new StackPointers<Integer>();
        //System.out.println("Inside Function ...................");
        for (int i = 0; i < exp.length()-1; i++) {
            System.out.println("Next character : " + exp.charAt(i));
            System.out.print("Stack : ");
            stack.display();
            System.out.println();
            char c = exp.charAt(i);
            if (Character.isLetter(c) || c == 'A') {
                //System.out.println(MessageFormat.format( "Hooooo : {0} ",map.get(c) ));
                stack.push((int) (map.get(c)));
                
                // stack.push((int) (map.get(c) - '0'));
            } else {
                int op1 = stack.getTop();
                stack.pop();
                int op2 = stack.getTop();
                stack.pop();
                switch (c) {
                    case '+':
                        System.out.println(MessageFormat.format("{0} + {1} = {2}", op2, op1, op1 + op2));
                    stack.push(op2+op1); 
                    break;
                      
                    case '-': 
                    stack.push(op2- op1); 
                    System.out.println(MessageFormat.format("{0} - {1} = {2}", op2, op1, op2 - op1));
                    break;
                      
                    case '/': 
                    stack.push(op2/op1);
                    System.out.println(MessageFormat.format("{0} / {1} = {2}", op2, op1, op2 / op1)); 
                    break; 
                      
                    case '*': 
                    stack.push(op2*op1); 
                    System.out.println(MessageFormat.format("{0} * {1} = {2}", op2, op1, op1 * op2));
                    break;
                    
                    case '%':
                    stack.push(op2 % op1);
                    System.out.println(MessageFormat.format("{0} % {1} = {2}", op2, op1, op2 % op1));
                    break;
              } 
            } 
        }
        
        return stack.getTop();     
    }
    static String infixToPostFix(String expression){

        String result = "";
        StackPointers<Character> stack = new StackPointers<>();
        stack.push('#');
        for (int i = 0; i <expression.length() ; i++) {
            char c = expression.charAt(i);

            //check if char is operator
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.getTop())>=precedence(c)){
                    result += stack.getTop();
                    stack.pop();
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.getTop();
                stack.pop();
                while(x!='('){
                    result += x;
                    x = stack.getTop();
                    stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor ( 
                result += c;
            }
        }
        while(stack.getTop() != null) {
            result += stack.getTop();
            try{
            stack.pop();
            } catch(Exception e){
                System.out.println(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "(A-(B/C)*D+E)*F%G";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + infixToPostFix(exp));

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 90);
        map.put('B', 50);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 1);
        map.put('F', 2);
        map.put('G', 5);
        System.out.println(evaluatePostFixExpression(infixToPostFix(exp), map));
    }

}
