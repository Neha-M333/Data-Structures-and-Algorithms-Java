public class subString {

    public static void get_Substring(String str, int si, int ei) {
        for(int i=si; i<ei; i++){
            System.out.print(str.charAt(i)+ " ");
        }
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        // OR System.out.print(str.subString(0, 5));
        get_Substring(str, 0, 5);
    }
}
