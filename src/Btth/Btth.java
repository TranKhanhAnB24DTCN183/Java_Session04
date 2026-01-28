package Btth;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Btth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = inputValidId(sc);
        String isbn = inputValidISBN(sc);
        int nxb = inputValidYear(sc);

        System.out.println("----- THÔNG TIN SÁCH -----");
        System.out.println("ID: " + id);
        System.out.println("ISBN: " + isbn);
        System.out.println("NXB: " + nxb);
        System.out.println("--------------------------");

        System.out.print("Nhập tên sách: ");
        String title = normalizeName(sc.nextLine());
        System.out.println("Tên sách chuẩn : " + title);
        System.out.print("Nhập tên tác giả: ");
        String author = normalizeName(sc.nextLine());
        System.out.println("Tên tác giả chuẩn : " + author);

        printResult(id, isbn, title, author, nxb);
    }

    public static String inputValidId(Scanner sc) {
        String id;
        do {
            System.out.print("Nhập id của cuốn sách: ");
            id = sc.nextLine();
            if (Pattern.matches("LIB-[0-9]{4}-S", id)) {
                return id;
            }
            System.err.println("Sai định dạng, vui lòng nhập lại!");
        } while (true);
    }

    public static String inputValidISBN(Scanner sc) {
        String isbn;
        do {
            System.out.print("Nhập mã ISBN: ");
            isbn = sc.nextLine();
            if (Pattern.matches("[0-9]{10}", isbn)) {
                return isbn;
            }
            System.err.println("Sai định dạng ISBN, vui lòng nhập lại!");
        } while (true);
    }

    public static int inputValidYear(Scanner sc) {
        int year;
        int currentYear = new Date().getYear() + 1900;

        do {
            try {
                System.out.print("Nhập năm xuất bản: ");
                year = Integer.parseInt(sc.nextLine());

                if (year <= currentYear) {
                    return year;
                } else {
                    System.err.println("Năm không được lớn hơn năm hiện tại!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!");
            }
        } while (true);
    }

    public static String normalizeName(String input) {
        input = input.trim();
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                result.append(
                        word.substring(0, 1).toUpperCase()
                                + word.substring(1).toLowerCase()
                ).append(" ");
            }
        }

        return result.toString().trim();
    }

    public static String buildCitation(String bookId, String title, String author, int year) {
        StringBuilder sb = new StringBuilder();

        sb.append("[")
                .append(bookId)
                .append("]")
                .append(" - ")
                .append(title)
                .append(" - ")
                .append(author)
                .append(" (")
                .append(year)
                .append(")");

        return sb.toString();
    }

    public static void printResult(
            String bookId,
            String isbn,
            String title,
            String author,
            int year
    ) {
        System.out.println("----- KẾT QUẢ ĐẦU VÀO -----");
        System.out.println("Mã sách chuẩn: " + bookId);
        System.out.println("ISBN-10: " + isbn);
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm XB: " + year);

        String citation = buildCitation(bookId, title, author, year);
        System.out.println("Trích dẫn: " + citation);
        System.out.println("--------------------------");
    }


}
