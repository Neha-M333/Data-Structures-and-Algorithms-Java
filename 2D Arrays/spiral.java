public class spiral {

    public static void print_spiral(int num[][]){
        int startRow = 0;
        int endRow = num.length-1;
        int startColumn = 0;
        int endColumn = num[0].length-1;

        while(startRow <= endRow && startColumn <= endColumn){
            //top
            for(int j=startColumn; j<=endColumn; j++){
                System.out.print(num[startRow][j]+ " ");
            }

            //right
            for(int i=startRow+1; i<=endRow; i++){
                System.out.print(num[i][endColumn]+ " ");
            }

            //bottom
            for(int j=endColumn-1; j>=startColumn; j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(num[endRow][j]+ " ");
            }

            //left
            for(int i=endRow-1; i>=startRow; i--){
                if(startColumn == endColumn){
                    break;
                }
                System.out.print(num[i][startColumn]+ " ");
            }

            startColumn++;
            startRow++;
            endColumn--;
            endRow--;
        }
        System.out.println( );
    }

    public static void main(String[] args){
        int num[][] = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

        print_spiral(num);
    }
}
