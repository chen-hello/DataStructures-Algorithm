package Algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
    System.out.print("排序前的数据:\t");
    System.out.println(Arrays.toString(arr));
    inserttSort(arr);
    }

    //插入排序
    public static void inserttSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;//即arr[i]前面的这个数的下标
            //给insertValue找到出入的位置
            //说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal <arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            arr[insertIndex+1]=insertVal;
            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));

        }
    }
}
