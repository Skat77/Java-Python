import java.util.Arrays;
import java.util.HashSet;

public class Main {

    //Task 1
    public static String UniqueSubstr(String str) {
        String answer = "";
        int maxLen = 0;
        int start = 0;
        HashSet<Character> chars = new HashSet<>();
        for (int end = 0; end < str.length(); end++) {
            while (chars.contains(str.charAt(end))) {
                chars.remove(str.charAt(start));
                start++; //Если обнаружен повторяющийся символ, сдвинуть начальную точку
            }
            chars.add(str.charAt(end));
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                answer = str.substring(start, end +1);
            }
        }
        return answer;
    }

    //Task 2
    public static int[] ArrayMerge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] arr3 = new int[len1 + len2];
        int ind1 = 0, ind2 = 0, ind3= 0;
        while (ind1 < len1 && ind2 < len2) {
            if (arr1[ind1] <= arr2[ind2]) {
                arr3[ind3] = arr1[ind1];
                ind1++;
                ind3++;
            }
            else {
                arr3[ind3] = arr2[ind2];
                ind2++;
                ind3++;
            }
        }
        //Добавление оставшихся элементов начальных массивов
        while (ind1 < len1) {
            arr3[ind3] = arr1[ind1];
            ind1++;
            ind3++;
        }
        while (ind2 < len2) {
            arr3[ind3] = arr2[ind2];
            ind2++;
            ind3++;
        }
        return arr3;
    }

    public static void main(String[] args) {
        //Task 1
        String str = "Good afternoon";
        System.out.println("Task 1: " + UniqueSubstr(str));

        //Task 2
        int[] array1 = {2, 6, 10, 16, 25, 76, 107};
        int[] array2 = {1, 7, 8, 43, 54, 77};
        System.out.println("Task 2: " + Arrays.toString(ArrayMerge(array1, array2)));
    }
}