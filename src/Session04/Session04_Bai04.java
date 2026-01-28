package Session04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Session04_Bai04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code;

        String prefixRegex = "^[A-Z]{2}.*";
        String yearRegex = "^[A-Z]{2}\\d{4}.*";
        String fullRegex = "^[A-Z]{2}\\d{4}\\d{5}$";

        do {
            System.out.print("Nhập mã thẻ thư viện: ");
            code = sc.nextLine();

            if (!Pattern.matches(prefixRegex, code)) {
                System.err.println("Thiếu hoặc sai tiền tố (2 chữ cái viết hoa)");
                continue;
            }

            if (!Pattern.matches(yearRegex, code)) {
                System.err.println("Thiếu hoặc sai năm vào học (4 chữ số)");
                continue;
            }

            int year = Integer.parseInt(code.substring(2, 6));
            if (year < 2000 || year > 2026) {
                System.err.println("Năm vào học không hợp lệ");
                continue;
            }

            if (!Pattern.matches(fullRegex, code)) {
                System.err.println("Mã thẻ không đúng định dạng (phải có 5 chữ số cuối)");
                continue;
            }
            System.out.println("Mã thẻ thư viện hợp lệ");
            break;
        } while (true);
    }
}
