public class operater {

    public static int getIthBit(int num, int pos){
        int bitmask = 1 << pos;

        if((num & bitmask) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int setIthBit(int num, int pos){
        int bitmask = 1 << pos;
        return num | bitmask;
    }

    public static int clearIthBit(int num, int pos){
        int bitmask = ~(1 << pos);
        return num & bitmask;
    }

    public static int Method1_updatdIthbit(int n, int i, int newBit){
        if(newBit == 0){
            return clearIthBit(n, i);
        }else{
            return setIthBit(n, i);
        }
    }

    public static int Method2_updatdIthbit(int n, int i, int newBit){
        n = clearIthBit(n, i);
        int Bitmask = newBit<<i;
        return n | Bitmask;
    }

    public static int clearLastIthBit(int num, int pos){
        int bitmask = ((~0) << pos);   // OR--> int bitmask = ((-1) << pos); 
        return num & bitmask;
    }

    public static int clearRangeOfBit(int num, int i, int j) {
        int a = ((~0) << j+1);
        int b = (1 << i) - 1;
        int bitmask = a|b;
        return num & bitmask;
    }

    public static boolean checkIfNumPowerOfTwo(int num){
        return (num &(num - 1)) == 0;
    }

    public static int countSetBits(int num){
        int count = 0;

        while(num > 0){
            if((num & 1) != 0){
                count++;
            }
            num = num>>1;
        }
        return count;
    }

    public static int exonentiation(int number, int power){
        int ans = 1;

        while(power > 0){
            if((power & 1) != 0){
                ans = ans * number;
            }
            number = number * number;
            power = power >> 1;
        }

    return ans;
    }

    public static void main(String[] args){
        // System.out.println(getIthBit(10, 2));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearLastIthBit(15, 2));
        // System.out.println(clearRangeOfBit(10, 2, 4));
        // System.out.println(checkIfNumPowerOfTwo(4));
        // System.out.println(countSetBits(16));
        System.out.println(exonentiation(5,3));
    }
    
}
