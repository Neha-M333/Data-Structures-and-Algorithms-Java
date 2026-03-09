
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsach {
    public static void main(String[] args) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int capacity = 50;
        int finalValue = 0;

        // 1. Find the ratio and sort it in ascending order
        double ratio[][] = new double[value.length][2];

        for(int i=0; i<value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // 2. Finding out if capacity is greater than or equal to the weight
        for(int i=ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finalValue += value[idx];
                capacity -= weight[idx];
            }else{
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final value: "+ finalValue);
    }
}
