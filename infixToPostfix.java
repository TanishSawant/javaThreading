public class infixToPostfix {
    public static void main(String[] args) {
        StackPointers<Character> operandStack = new <Character>StackPointers();
        StackPointers<Character> operatorStack = new <Character>StackPointers();
        String expression = "a-(b+c*d)/e";
        for (char c : expression.toCharArray() ) {
            if(Character.isLetterOrDigit(c) && c!='(' && c!=')'){
                operandStack.push(c);
                System.out.println("Added " + c);
            }
            else if(Character.isWhitespace(c)){
                
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/' || c == '('){
                operatorStack.push(c);
                System.out.println("Added " + c);
            }
            else if(c == ')'){
                while (operatorStack.getTop() != '(') {
                    char temp = operatorStack.getTop();
                    operatorStack.pop();
                    operandStack.push(temp);
                    System.out.println("Added " + temp + " to operand");
                }
                operatorStack.pop();
            }
        }
            while (!operatorStack.isEmpty()) {
                char temp = operatorStack.getTop();
                operatorStack.pop();
                operandStack.push(temp);
            }
        operatorStack = null;
        //operandStack.push(expression.charAt(0));
        StackPointers<Character> result = new <Character>StackPointers();
        result.push(operandStack.getTop());
        while(!operandStack.isEmpty()){
            char temp = operandStack.getTop();
            result.push(temp);
            operandStack.pop();
        } 
        result.display();
        operandStack.display();
        operandStack = null;
    }    
}
