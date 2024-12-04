package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution1 {
    public static void main(String[] args) {
        String fileName = "./Day3/input.txt";
        int totalSum = 0;

        try {
            String fileContent = Files.readString(Paths.get(fileName));

            String regexMult = "mul\\((\\d+),(\\d+)\\)";

            Pattern pattern = Pattern.compile(regexMult);
            Matcher matcher = pattern.matcher(fileContent);

            while (matcher.find()) {
                Integer firstNumber = Integer.parseInt(matcher.group(1));
                Integer secondNumber = Integer.parseInt(matcher.group(2));

                totalSum += firstNumber*secondNumber;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(totalSum);
    }
}