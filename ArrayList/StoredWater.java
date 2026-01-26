import java.util.ArrayList;

public class StoredWater {

    public static int storedWater(ArrayList<Integer> height){
        int maxStore = 0;
        int n = height.size();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int minHeight = Math.min(height.get(i), height.get(j));
                int width = j-i;
                int currStored = minHeight * width;
                maxStore = Math.max(maxStore, currStored);
            }
        }
        return maxStore;
    }

    public static void main(String[] args){
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storedWater(height));

    }
}
