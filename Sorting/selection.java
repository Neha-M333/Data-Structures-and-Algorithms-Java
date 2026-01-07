public class selection {

    public static void ascending_Selection(int num[]){
        int n = num.length;
        for(int i=0; i<n-1; i++){
            int minNum = i;

            for(int j=i+1; j<n; j++){
                if(num[minNum] > num[j]){
                    minNum = j;
                }
            }
            int temp = num[minNum];
            num[minNum] = num[i];
            num[i] = temp;
        }
    }

    public static void decending_Selection(int num[]){
        int n = num.length;
        for(int i=0; i<n-1; i++){
            int minNum = i;

            for(int j=i+1; j<n; j++){
                if(num[minNum] < num[j]){
                    minNum = j;
                }
            }
            int temp = num[minNum];
            num[minNum] = num[i];
            num[i] = temp;
        }
    }

    public static void print(int num[]) {
        int n = num.length;
        for(int i=0; i<n; i++){
            System.out.print(num[i]+ " ");
        }
    }

    public static void main(String[] args) {
        int num[] = {5, 4, 1, 3, 2};
        ascending_Selection(num);
        print(num);

        System.out.println( );
        decending_Selection(num);
        print(num);
        System.out.println( );
    }
}
