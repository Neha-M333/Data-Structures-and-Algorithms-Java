import java.util.*;

public class anagram {

    public static void anagram(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()){
            char str1Array[] = str1.toCharArray();
            char str2Array[] = str2.toCharArray();

            Arrays.sort(str1Array);
            Arrays.sort(str2Array);

            boolean result = Arrays.equals(str1Array, str2Array);
            if(result){
                System.out.println("These strings are anagram");
            }else{
                System.out.println("These strings are not anagram");
            }
        }else{
            System.out.println("These strings are not anagram");
        }
    }                                            

    public static void main(String args[]){
        String str1 = "race";
        String str2 = "care";
        anagram(str1, str2);
    }
}

