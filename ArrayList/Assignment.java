import java.util.*;

public class Assignment {

    // Checking is the array list is monotronic
    public boolean isMonotonic(ArrayList<Integer> num){
        boolean inc = true;
        boolean dec = true;

        for(int i=0; i<num.size()-1; i++){
            if(num.get(i) > num.get(i+1)){
                inc = false;
            }
            
            if(num.get(i) < num.get(i+1)){
                dec = false;
            }
        }
        return inc || dec;
    }

    // Print lonely number in array list
    public ArrayList<Integer> findLonely(ArrayList<Integer> num){
        ArrayList<Integer> result = new ArrayList<>();

        if(num.size() == 0){
            return result;
        }

        Collections.sort(num);

        for(int i=0; i<num.size(); i++){
            int curr = num.get(i); 

            boolean leftDiff = (i==0) || (num.get(i-1) != curr-1 && num.get(i-1) != curr);
            boolean rightDiff = (i==num.size()-1) || (num.get(i+1) != curr + 1 && num.get(i+1) != curr);

            if(leftDiff && rightDiff){
                result.add(curr);
            }
        }
        return result;
    }

    // Most frequent number followed by key
    public int mostFrequent(ArrayList<Integer> num, int key){
        int count[] = new int[1001];

        for(int i=0; i<num.size()-1; i++){
            if(num.get(i) == key){
                int nextNumber = num.get(i+1);
                count[nextNumber]++;
            }
        }
        
        int maxNum = 0; int answer = 0;

        for(int i=0; i<count.length; i++){
            if(count[i] > maxNum){
                maxNum = count[i];
                answer = i;
            }
        }
        return answer;
    }

    // Butterfly ArrayList
    

    public static void main(String[] args) {
        //-------------------------------------
        // MONOTRONIC ARRAY LIST
        //-------------------------------------
        // Assignment obj = new Assignment();
        // ArrayList<Integer> num = new ArrayList<>();

        // Arrays.asList(1,3,2);
        // System.out.println(obj.isMonotonic(num));

        //-------------------------------------
        // LONELY NUMBERS IN ARRAYLIST
        //-------------------------------------
        // Assignment obj = new Assignment();

        // ArrayList<Integer> num = new ArrayList<>(Arrays.asList(10,6,5,8));

        // ArrayList<Integer> lonely = obj.findLonely(num);

        // for(int i=0; i<lonely.size(); i++){
        //     System.out.print(lonely.get(i) + " ");
        // }
        // System.out.println();


        //-------------------------------------
        // MOST FREQUENT NUMBER
        //-------------------------------------
        Assignment obj = new Assignment();

        ArrayList<Integer> num =
            new ArrayList<>(Arrays.asList(1,100,200,1,100));

        int key = 1;

        int result = obj.mostFrequent(num, key);

        System.out.println("Most frequent after key = " + result);
        }
}
