package Session04;

import java.time.LocalDate;

public class Session04_Bai03 {
    public static void main(String[] args) {
        String[] transactions = {"BK001-20/01", "BK005-21/01", "BK099-22/01"};

        long start = System.currentTimeMillis();
        System.out.println(start);
        String reportSB = buildReportWithStringBuilder(transactions);
        long end = System.currentTimeMillis();

        long startStr = System.currentTimeMillis();
        String reportStr = buildReportWithString(transactions);
        long endStr = System.currentTimeMillis();

        System.out.println(reportSB);
        System.out.println("Số thời gian thực thi đối với StringBuilder: " + (end - start));
        System.out.println("Số thời gian thực thi đối với String: " + (endStr - startStr));
    }

    public static String buildReportWithStringBuilder(String[] transactions) {
        StringBuilder sb = new StringBuilder();

        sb.append("--- BÁO CÁO MƯỢN SÁCH ---\n");
        sb.append("Ngày tạo: ").append(LocalDate.now()).append("\n");

        for (String t : transactions) {
            sb.append("Giao dịch: ")
                    .append(t)
                    .append("\n");
        }

        return sb.toString();
    }

    public static String buildReportWithString(String[] transactions) {
        String report = "--- BÁO CÁO MƯỢN SÁCH ---\n";
        report += "Ngày tạo: " + LocalDate.now() + "\n";

        for (String t : transactions) {
            report += "Giao dịch: " + t + "\n";
        }

        return report;
    }
}

