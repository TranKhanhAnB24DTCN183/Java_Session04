package Session04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Session04_Bai06 {
    public static void main(String[] args) {

        String review = "Cuốn sách này thật sự rất ngu và nội dung khá dở. ";

        String[] blacklist = {"ngu", "xấu", "dở"};
        String regex = "(?i)\\b(" + String.join("|", blacklist) + ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(review);

        StringBuilder filtered = new StringBuilder();
        int lastIndex = 0;

        while (matcher.find()) {
            filtered.append(review, lastIndex, matcher.start());
            System.out.println(filtered);

            int length = matcher.group().length();
            filtered.append("*".repeat(length));

            lastIndex = matcher.end();
        }
        filtered.append(review.substring(lastIndex));

        String result = filtered.toString();
        
        if (result.length() > 200) {
            int cutIndex = result.lastIndexOf(" ", 200);
            System.out.println(cutIndex);
            StringBuilder shortText = new StringBuilder();
            shortText.append(result, 0, cutIndex).append("...");
            result = shortText.toString();
        }

        System.out.println("Nội dung sau khi lọc:");
        System.out.println(result);
    }
}
