import java.util.ArrayList;

public class PairSum {

    public static boolean pair(ArrayList<Integer> list, int target){
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean optimizedPair(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size()-1;

        while(lp < rp) {
            // case 1: return true
        if(list.get(lp) + list.get(rp) == target){
            return true;
        }

        // case 2: update left pointer
        if(list.get(lp) + list.get(rp) < target){
            lp++;
        }else{
            // case 3: update right pointer
            rp--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int target = 15;
        for(int i=1; i<=6; i++){
            list.add(i);
        }

        System.out.println(pair(list, target));
        System.out.println(optimizedPair(list, target));
    }
}
