package Session04;

public class Session04_Bai02 {
    public static void main(String[] args) {
        String description = "Sách Java, Kệ: A1-102, Tình trạng mới";

        if (description.contains("Kệ:")) {
            int startIndex = description.indexOf("Kệ:") + 4;
            System.out.println(startIndex);
            int endIndex = description.indexOf(",", startIndex);
            System.out.println(endIndex);

            if (endIndex == -1) {
                endIndex = description.length();
            }
            String shelfCode = description.substring(startIndex, endIndex).trim();

            System.out.println("Vị trí kệ sách tìm thấy: " + shelfCode);

            String newDescription = description.replace(
                    "Kệ:",
                    "Vị trí lưu trữ:"
            );
            System.out.print("Mô tả mới : ");
            System.out.printf(newDescription);
        } else {
            System.out.println("Không tìm thấy thông tin kệ sách trong mô tả.");
        }
    }
}
