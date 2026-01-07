public class bubbleSort {

    public static void Accending_bubble(int num[]){
        int n = num.length;
        for(int turn=0; turn<n-1; turn++){
            boolean swapped = false;
            for(int j=0; j<n-1-turn; j++){
                if(num[j] > num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
    }

    public static void decending_bubble(int num[]){
        for(int turn=0; turn<num.length-1; turn++){
            boolean swapped = false;
            for(int j=0; j<num.length-1-turn; j++){
                if(num[j]<num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void print(int num[]){
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num[] = {5, 4, 1, 3, 2};
        
        Accending_bubble(num);
        print(num);
        System.out.println();
        decending_bubble(num);
        print(num);
    }
}
