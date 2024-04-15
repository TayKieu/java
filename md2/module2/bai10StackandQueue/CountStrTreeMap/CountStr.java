package bai10StackandQueue.CountStrTreeMap;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class CountStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input String: ");
        String str = sc.nextLine();
        String arr[] = str.split(" ");
        System.out.println(Arrays.toString(arr));
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        for(int i = 0; i< arr.length;i++){
            if(treeMap.containsKey(arr[i])){
                Integer value = treeMap.get(arr[i]);
                value++;
                treeMap.replace(arr[i],value);
            }
            else {
                treeMap.put(arr[i],1);
            }
        }
        System.out.println(treeMap.toString());
    }
}
