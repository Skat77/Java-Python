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

    public static void main(String[] args) {
        //Task 1
        String str = "Good afternoon";
        System.out.println("Task 1: " + UniqueSubstr(str));
    }
}
