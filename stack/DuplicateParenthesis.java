
import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean isDuplicate(String str){
        // 1. Create a stack
        // 2. Traverce through the string.
        // 3. Now we will check if there is "closing bracket" in string:
        //    (i) If there is "closing bracket" inatilize count to 0, then till I get "opening bracket" pop the top and increase the count.
        //    (ii) If count is less than 1, then it is true duplicate exist.
        //         else pop() -> "Opening pair"
        // 4. Push the "Open bracket" and other variables.
        // 5. If the stack is not empty by end return false duplicate does not exist.

        // (1)
        Stack<Character> s = new Stack<>();

        // (2)
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            // (3)
            if(ch == ')'){
                // (3) -> (i)
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }

                // (3) -> (ii)
                if(count < 1){
                    return true;
                }else{
                    s.pop();
                }

            }
            // (4)
            else{
                s.push(ch);
            }
        }
        // (5)
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(isDuplicate(str));
    }
}
