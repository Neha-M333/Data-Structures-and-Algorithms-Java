public class insertion{

    public static void ascending_Selection(int num[]){
        for(int i=1; i<num.length; i++){
            int curr = num[i];
            int prev = i-1;
            
            //Find out the correct "position" to insert
            while(prev >= 0 && num[prev] > curr){
                num[prev + 1] = num[prev];
                prev--;
            }
            //This is when in "insert"
            num[prev + 1] = curr;
        }
    }

    public static void decending_Selection(int num[]){
        for(int i=1; i<num.length; i++){
            int curr = num[i];
            int prev = i-1;
            
            //Find out the correct "position" to insert
            while(prev >= 0 && num[prev] < curr){
                num[prev + 1] = num[prev];
                prev--;
            }
            //This is when in "insert"
            num[prev + 1] = curr;
        }
    }

    public static void print(int num[]) {
        for(int i=0; i<num.length; i++){
            System.out.print(num[i]+ " ");
        }
    }

    public static void main(String[] args){
        int num[] = {5, 4, 1, 3, 2};
        ascending_Selection(num);
        print(num);

        System.out.println( );

        decending_Selection(num);
        print(num);

        System.out.println( );
    }
}