package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        String fileName = "./input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String zeile;
            int safeReports = 0;

            while ((zeile = br.readLine()) != null) {
                String[] rows = zeile.trim().split(" ");

                // Ignoriere leere Zeilen
                if (rows.length < 2) continue;

                // Konvertiere in Integer-Array
                int[] intArray = Arrays.stream(rows)
                                       .mapToInt(Integer::parseInt)
                                       .toArray();

                boolean isAscending = intArray[0] < intArray[1];
                boolean isValid = true;

                for (int i = 0; i < intArray.length - 1; i++) {
                    int diff = intArray[i + 1] - intArray[i];

                    // Prüfe die Differenzregel
                    if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                        isValid = false;
                        break;
                    }

                    // Prüfe, ob die Reihenfolge konsistent bleibt
                    if ((isAscending && diff < 0) || (!isAscending && diff > 0)) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    safeReports++;
                }
            }

            System.out.println("Anzahl sicherer Reports: " + safeReports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
