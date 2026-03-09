
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection{
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        // int start[] = {1,3,0,5,8,5};
        // int end[] = {2,4,6,7,9,9};

        int start[] = {10,12,20};
        int end[] = {20,25,30};

        // Sortring if we have unsorted array
        int activity[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }

        Arrays.sort(activity, Comparator.comparingDouble(o->o[2]));
        
        int maxAct = 1;
        int lastEnd = activity[0][2];
        ans.add(activity[0][0]);

        for(int i=0; i<end.length; i++){
            if(activity[i][1] >= lastEnd){
                maxAct++;
                ans.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }

        System.out.println("Max activity= "+ maxAct);

        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();        
    }
}