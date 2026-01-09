public class palindrome {
    public static boolean isPalindrom(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                System.out.println("Not a Palindrom");
                return false;
            }
        }
        System.out.println(str+" is a Palindrom");
        return true;
    }

    public static void main(String[] args){
        String str = "racecar";
        isPalindrom(str);
    }
}
