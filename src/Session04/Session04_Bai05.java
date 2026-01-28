package Session04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Session04_Bai05 {
    public static void main(String[] args) {
        int borrowCount = 0;
        int returnCount = 0;

        String log = "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345";

        String regex =
                "(\\d{4}-\\d{2}-\\d{2}) \\| User: (\\w+) \\| Action: (BORROW|RETURN) \\| BookID: (BK\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(log);

        if (m.matches()) {
            String date = m.group(1);
            String user = m.group(2);
            String action = m.group(3);
            if (action.equals("BORROW")) {
                borrowCount++;
            } else if (action.equals("RETURN")) {
                returnCount++;
            }
            String bookId = m.group(4);

            System.out.println("Ngày : " + date);
            System.out.println("Người dùng : " + user);
            System.out.println("Hành động : " + action);
            System.out.println("Mã sách : " + bookId);
            System.out.println("---------------------------");
            System.out.println("Tổng số sách đã mượn: " + borrowCount);
            System.out.println("Tổng số sách đã trả: " + returnCount);
        } else {
            System.out.println("Dòng log không hợp lệ");
        }
    }
}
