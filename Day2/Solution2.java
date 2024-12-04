package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution2 {
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

                // Überprüfe, ob der Bericht sicher ist
                if (isSafe(intArray)) {
                    safeReports++;
                } else {
                    // Prüfe, ob das Entfernen eines Werts den Bericht sicher macht
                    for (int i = 0; i < intArray.length; i++) {
                        int[] modifiedArray = removeIndex(intArray, i);
                        if (isSafe(modifiedArray)) {
                            safeReports++;
                            break; // Nur einmal pro Bericht erhöhen
                        }
                    }
                }
            }

            System.out.println("Anzahl sicherer Reports mit Problem Dampener: " + safeReports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode zur Überprüfung, ob ein Bericht sicher ist
    private static boolean isSafe(int[] intArray) {
        if (intArray.length < 2) return false;

        boolean isAscending = intArray[0] < intArray[1];

        for (int i = 0; i < intArray.length - 1; i++) {
            int diff = intArray[i + 1] - intArray[i];

            // Prüfe die Differenzregel
            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }

            // Prüfe, ob die Reihenfolge konsistent bleibt
            if ((isAscending && diff < 0) || (!isAscending && diff > 0)) {
                return false;
            }
        }

        return true;
    }

    private static int[] removeIndex(int[] array, int index) {
        int[] result = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                result[j++] = array[i];
            }
        }
        return result;
    }
     
}
