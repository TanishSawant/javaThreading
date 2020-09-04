public class infixToPostfix {

    public static String reverseString(char[] ch) {
        
        String rev="";  
        for(int i=ch.length-1;i>=0;i--){  
            rev+=ch[i];  
        }  
        return rev;  
    } 

    public static int[] addX(int n, int arr[], int x) 
    { 
        int i; 
  
        // create a new array of size n+1 
        int newarr[] = new int[n + 1]; 
  
        // insert the elements from 
        // the old array into the new array 
        // insert all elements till n 
        // then insert x at n+1 
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    }

    public static char[] addX(int n, char arr[], char x) 
    { 
        int i;  
        char newarr[] = new char[n + 1]; 
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x;
        return newarr; 
    }

    public static int evaluatePostFixExpression(String exp) {
        //create a stack 
        StackPointers<Integer> stack=new StackPointers<Integer>(); 
        
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push((int) (c - '0'));
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int op1 =  stack.getTop();
                stack.pop(); 
                int op2 =  stack.getTop(); 
                stack.pop();
                switch(c) 
                { 
                    case '+': 
                    stack.push(op2+op1); 
                    break; 
                      
                    case '-': 
                    stack.push(op2- op1); 
                    break; 
                      
                    case '/': 
                    stack.push(op2/op1); 
                    break; 
                      
                    case '*': 
                    stack.push(op2*op1); 
                    break;
                    
                    case '%':
                    stack.push(op2 % op1);
                    break;
              } 
            } 
        }
        
        return stack.getTop();     
    }
    public static void main(String[] args) {
        StackPointers<Character> operandStack = new <Character>StackPointers();
        StackPointers<Character> operatorStack = new <Character>StackPointers();
        //String expression = "(A – (B / C) * D + E ) * F % G";
        String expression = "(90-(50/2)*3+1)*2%5";
        for (char c : expression.toCharArray() ) {
            if(Character.isLetterOrDigit(c) && c!='(' && c!=')'){
                operandStack.push(c);
                System.out.println("Added " + c);
            }
            else if(Character.isWhitespace(c)){
                
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == '%'){
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
        /* while(!operandStack.isEmpty()){
            char temp = operandStack.getTop();
            result.push(temp);
            operandStack.pop();
        } */
        
        char[] _result = {};
        while(!operandStack.isEmpty()){
            char temp = operandStack.getTop();
            _result = addX(_result.length, _result, temp);
            operandStack.pop();
        }
        
        System.out.println(reverseString(_result));
        //result.display();
        //operandStack.display();
        //expression = "(90-(50/2)*3+1)*2%5";
        System.out.println(evaluatePostFixExpression("231*+9-"));
        System.gc();
    }
}
