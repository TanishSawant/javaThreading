public class infixToPostfix {
    public static void main(String[] args) {
        StackArray<Character> operandStack = new <Character>StackArray();
        StackArray<Character> operatorStack = new <Character>StackArray();
        String expression = "a-(b+c*d)/e";
        for (char c : expression.toCharArray() ) {
            if(Character.isLetterOrDigit(c)){
                
            }
        }
    }    
}
