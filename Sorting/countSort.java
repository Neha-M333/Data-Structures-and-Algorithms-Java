
public class countSort {

    public static void ascending_Count(int num[]){
        int n = num.length;
        // 1st Find Largest number
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            largest = Math.max(largest,num[i]);
        }

        // 2nd Create the count array
        int count[] = new int[largest+1];

        for(int i=0; i<n; i++){
            count[num[i]]++;
        }

        // 3rd Sort the array
        int j=0;                          //j → position in sorted array
        for(int i=0; i<count.length; i++){           //i → current number (value)
            while(count[i] > 0){          //count[i] → how many times i appears
                num[j] = i;               //num[j] = i → place number i into the array
                j++;
                count[i]--;
            }
        }
    }

    public static void decending_Count(int num[]){
        int n = num.length;
        // 1st Find Largest number
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            largest = Math.max(largest,num[i]);
        }

        // 2nd Create the count array
        int count[] = new int[largest+1];

        for(int i=0; i<n; i++){
            count[num[i]]++;
        }

        // 3rd Sort the array
        int j=0;                                           //j → position in sorted array
        for(int i=count.length-1; i >= 0; i--){            //i → current number (value)
            while(count[i] > 0){                          //count[i] → how many times i appears
                num[j] = i;                               //num[j] = i → place number i into the array
                j++;
                count[i]--;
            }
        }
    }

    public static void printArray(int num[]){
        System.out.print("Sorted array: ");
        for(int i=0; i<num.length; i++){
            System.out.print(num[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int num[] = {1, 4, 1, 3, 2, 4, 3, 7};
        ascending_Count(num);
        printArray(num);

        decending_Count(num);
        printArray(num);
    }
}
