package bai13ArrangeAlgorithms.InsertionSortByStep;

public class insertionSort {
     static int[] list = {3,2,1,6,5,4};

    public static void insertionSort(int[] list) {
        boolean needNextPass = true;
        for (int i = 1; i < list.length && needNextPass; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    needNextPass = true;
                } else {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        insertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
