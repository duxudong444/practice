import java.util.Arrays;

public class SortClass {
    public static void main(String[] args) {
        int[] arr = {2,4,5,1,5,2,56,7,8,9};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr) {
        quick(arr, 0, arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {
        //首先是递归终止条件
        if(right - left < 0){
            return;
        }
        int i = left;
        int j = right;
        int index = arr[i];
        //两端同时扫描，一旦一边不满足即交换再扫描另一边
        while (i<j){
            while(i<j && arr[j]>=index){
                j--;
            }
            if(i<j){
                arr[i++] = arr[j];
            }
            while(i<j && arr[i]<index){
                i++;
            }
            if(i<j){
                arr[j--] = arr[i];
            }
        }
        //将基准值插入数组中
        arr[i] = index;
        //递归调用，注意边界值不要写错
        quick(arr, left, i-1);
        quick(arr, i+1, right);

    }

}
