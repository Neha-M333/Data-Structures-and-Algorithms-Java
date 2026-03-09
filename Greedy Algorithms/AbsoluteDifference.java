
import java.util.Arrays;

public class AbsoluteDifference {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[] = {2,1,4};
        int absDiff = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0; i<a.length; i++){
            absDiff += Math.abs(a[i] - b[i]);
        }
        System.out.println("Absolute Difference of pairs: "+ absDiff);
    }
}
