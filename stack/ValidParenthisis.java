import java.util.Stack;

public class ValidParenthisis {
    
    public static boolean isValid(String str){
        // 1. Create the stack.
        // 2. Traverce through the stack.
        // 3. If in string there is "opening bracket" push it in the stack.
        // 4. If string contains "closing bracket" check:
        //    (i) The top of the stack is empty then return false 
        //    (ii) Else if not empty pop out the top.
        // 5. Then at the end we check the stack if it contains any bracket return false, if it is empty return true.

        // (1)
        Stack<Character> s = new Stack<>();

        // (2)
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            // (3)
            if(ch == '(' || ch == '[' || ch == '{'){
                s.push(ch);
            }else{

                // (4) -> (i)
                if(s.isEmpty()){
                    return false;
                }

                // (4) -> (ii)
                if((s.peek() == '(' && ch == ')') || 
                    (s.peek() == '[' && ch == ']') || 
                    (s.peek() == '{' && ch == '}')){
                        s.pop();
                }else{
                    return false;
                }
            }
        }

        // (5)
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println(isValid(str));
    }
}
