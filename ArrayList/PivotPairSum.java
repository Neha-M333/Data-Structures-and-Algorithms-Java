import java.util.ArrayList;

public class PivotPairSum {

    public static boolean pairSum(ArrayList<Integer> list, int target){
        // Find the pivot.
        int pivot = -1;

        for(int i=0; i<list.size(); i++){
            if(list.get(i) > list.get(i+1)){
                pivot = i;
                break;
            }
        }

        int lp = pivot+1;
        int rp = pivot;
        int n = list.size();

        while(lp != rp){
        // case 1: return true.
        if(list.get(lp) + list.get(rp) == target){
            return true;
        }

        if(list.get(lp) + list.get(rp) < target){
            // case 2: update left pointer
            lp = (lp+1) % n;
        }else{
            // case 3: update right pointer
            rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        System.out.println(pairSum(list, target));

    }
}
