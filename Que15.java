package javaAssignment;
import java.util.HashMap;

public class Que15 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 3, 2, 4, 5, 3, 6};
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int key : countMap.keySet()) {
            System.out.println(key + " appears " + countMap.get(key) + " times.");
        }
    }
}