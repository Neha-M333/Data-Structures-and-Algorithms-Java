public class diagonal_Sum {

    public static int sum(int num[][]){            // Time complexity: O(n^2)
        int sum = 0;
        for(int i=0; i<num.length; i++){
            for(int j=0; j<num[0].length; j++){
                if(i==j){
                    sum += num[i][j];
                }else if(i+j == num.length-1){
                    sum += num[i][j];
                }
            }
        }
        return sum;
    }

    public static int optimized_Sum(int num[][]){    // Time complexity: O(n)
        int sum = 0;
        for(int i=0; i<num.length; i++){
            sum += num[i][i];

            if(i != num.length-1-i){
                sum += num[i][num.length-1-i];
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int num[][] = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        
        System.out.println(sum(num));
        System.out.println(optimized_Sum(num));
    }
}
