import java.util.Arrays;
import java.util.Comparator;

public class LengthChain {
    public static void main(String[] args) {
        int pair[][] = {{5,24}, {9,10}, {5,28}, {27,40}, {50,90}};

        // Sort based on second value
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int lastEnd = pair[0][1];

        for (int i = 1; i < pair.length; i++) {

            if(pair[i][0] > lastEnd){   // chain condition
                chainLen++;
                lastEnd = pair[i][1];
            }

        }

        System.out.println(chainLen);
    }
}