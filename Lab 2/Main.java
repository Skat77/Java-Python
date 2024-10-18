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

    //Task 3
    public static int MaxSum(int[] array) {
        int answer = array[0];
        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(currentSum + array[i], array[i]);
            answer = Math.max(answer, currentSum);
        }
        return answer;
    }

    //Task 4
    public static int[][] RotateRight(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix[j][rows- i - 1] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    //Task 5
    public static int[] FindTargetSum(int[] array, int target) {
        for (int first = 0; first < array.length; first++) {
            for (int second = first + 1; second < array.length; second++) {
                if (array[first] + array[second] == target) {
                    return new int[]{array[first], array[second]};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //Task 1
        String str = "Good afternoon";
        System.out.println("Task 1: " + UniqueSubstr(str));

        //Task 2
        int[] array1 = {2, 6, 10, 16, 25, 76, 107};
        int[] array2 = {1, 7, 8, 43, 54, 77};
        System.out.println("Task 2: " + Arrays.toString(ArrayMerge(array1, array2)));

        //Task 3
        int[] array3 = {3, -2, -5, 1, 7, -2, 15, 23, 4, -17, 2};
        System.out.println("Task 3: " + MaxSum(array3));

        //Task 4
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] newMatrix = RotateRight(matrix);
        System.out.println("Task 4: ");
        for (int[] row : newMatrix) {
            System.out.println(Arrays.toString(row));
        }

        //Task 5
        int[] findTarget = {1, 5, 9, 6, -1, 3, 15};
        int target = 16;
        int[] targetPair = FindTargetSum(findTarget, target);
        if (targetPair != null) {
            System.out.println("Task 5: " + Arrays.toString(targetPair));
        }
        else {
            System.out.println("Task 5: not found");
        }
    }
}