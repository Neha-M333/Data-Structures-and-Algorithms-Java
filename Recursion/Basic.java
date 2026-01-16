public class Basic {

    public static int factorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n * factorial(n-1);
    }

    // public static int factorial(int n){
    //     int result = 0;
    //     for(int i=1; i<=n; i++){
    //         result *= i;
    //     }
    //     return result;
    // }

    public static void  printDec(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+ " ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if(n == 1){
            System.out.print(n+ " ");
            return;
        }
        printInc(n-1);
        System.out.print(n+ " ");
    }

    public static int sumN(int n){
        if(n == 1){
            return n;
        }
        return n + sumN(n-1);
    }

    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // public static int fibonacci(int n) {
    //     int a=0;
    //     int b=1;

    //     for(int i=2; i<=n; i++){
    //         int c = a+b;
    //         a = b;
    //         b = c;
    //     }
    //     return b;
    // }

    public static boolean sorted(int num[], int i){
        if(i== num.length-1){
            return true;
        }

        if(num[i] > num[i+1]){
            return false;
        }

        return sorted(num, i+1);
    }

    // public static boolean sorted(int num[]){
    //     for(int i=0; i<num.length; i++){
    //         if(num[i] > num[i+1]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public static int firstOccurence(int num[], int i, int key){
        if(i==num.length-1){
            return -1;
        }

        if(num[i]==key){
            return i;

        }
        return firstOccurence(num, i+1, key);
    }

    public static int lastOccurence(int num[], int i, int key){
        if(i==num.length){
            return -1;
        }   
        int isFound = lastOccurence(num, i+1, key);
        if(isFound == -1 && num[i]==key){
            return i;
        }
        return isFound;
    }

    public static int power(int num, int pow){
        if(pow == 0){
            return 1;
        }
        return num*power(num, pow-1);
    }

    public static int optimizedPower(int n, int pow){
        if(pow == 0){
            return 1;
        }

        int half = optimizedPower(n, pow/2);
        int halfsq = half * half;

        // If Odd
        if(pow % 2 != 0){
            halfsq = n * halfsq;
        }
        return halfsq;
    }

    

    public static void main(String[] args) {
        //System.out.println(factorial(5));
        //printDec(10);
        //printInc(5);
        //System.out.println(sumN(5));
        //System.out.println(fibonacci(4));
        // System.out.println(sorted(num, 0));
        // int num[] ={1,5,3,4,5};
        // System.out.println(lastOccurence(num, 0, 5));
        //System.out.println(power(2, 3));
        System.out.println(optimizedPower(2, 5));
    }
}
