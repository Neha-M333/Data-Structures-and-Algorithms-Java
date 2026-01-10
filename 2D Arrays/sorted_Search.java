public class sorted_Search {

    public static boolean stairCase_TopRight(int num[][], int key){
        int row = 0;
        int column = num[0].length-1;

        while(row <= num.length-1 && column >= 0){
            if(num[row][column] == key){
                System.out.println("Found the number at position ("+row+","+column+")");
                return true;
            }else if(key < num[row][column]){
                column--;
            }else{
                row++;
            }
        }
        System.out.println("Not found!");
        return false;
    }

    public static boolean stairCase_BottomLeft(int num[][], int key){
        int row = num.length-1;
        int column = 0;

        while(column <= num.length-1 && row >= 0){
            if(num[row][column] == key){
                System.out.println("Found the number at position ("+row+","+column+")");
                return true;
            }else if(key < num[row][column]){
                row--;
            }else{
                column++;
            }
        }
        System.out.println("Not found!");
        return false;
    }

    public static void main(String[] args){
        int num[][] = { {10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                        {32,33,39,50}};
        int key = 33;
        //stairCase_TopRight(num, key);

        stairCase_BottomLeft(num, key);
    }
}
