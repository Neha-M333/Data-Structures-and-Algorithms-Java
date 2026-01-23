public class AprochTwoMajoreElement {

    private static int count(int nums[], int num, int si, int ei){
        int count = 0;
        for(int i=si; i<=ei; i++){
            if(nums[i] == num){
                count +=1;
            }
        }
        return count;
    }

    private static int majorElementRec(int nums[], int si, int ei){
        //Base case
        if(si == ei){
            return nums[si];
        }

        //Working
        int mid = si+(ei- si) / 2;
        int left = majorElementRec(nums, si, mid);
        int right = majorElementRec(nums, mid+1, ei);

        //If two also have same number
        if(left == right){
            return left;
        }

        //Start counting the element
        int leftCount = count(nums, left, si, ei);
        int rightCount = count(nums, right, si, ei);

        return leftCount > rightCount ? left : right;
    }

    public static int majorElement(int nums[]){
        return majorElementRec(nums, 0, nums.length-1);
    }
    public static void main(String[] args) {
        int nums[] = {3, 2, 3};
        // int nums[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorElement(nums));
    }
}
