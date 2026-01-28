package Session04;

import java.util.Scanner;

public class Session04_Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên sách: ");
        String rawTitle = sc.nextLine();

        System.out.print("Nhập tên tác giả: ");
        String rawAuthor = sc.nextLine();

        String title = normalizeTitle(rawTitle);
        String author = normalizeAuthor(rawAuthor);

        String result = "[" + title + "] - Tác giả: " + author ;
        System.out.println(result);
    }
    public static String normalizeTitle(String input) {
        return input.trim()
                .replaceAll("\\s+", " ")
                .toUpperCase();
    }
    public static String normalizeAuthor(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }

        return sb.toString().trim();
    }
}
