import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution2 {
    public static void main(String[] args) {
        String fileName = "./Day1/input.txt";
        ArrayList<Integer> firstRow = new ArrayList<>();
        ArrayList<Integer> secondRow = new ArrayList<>();
        int totalSimilarity = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String zeile;

            while ((zeile = br.readLine()) != null) {
                String[] rows = zeile.split("\\s+");
                if (rows.length == 2) {
                    firstRow.add(Integer.parseInt(rows[0]));
                    secondRow.add(Integer.parseInt(rows[1]));
                } else {
                    System.out.println("Ungültige Zeile: " + zeile);
                }
            }
        } catch (IOException e) {
            System.out.println("Dateifehler: " + e.getMessage());
        }

        for (int entry: firstRow) {
            totalSimilarity += entry * Collections.frequency(secondRow, entry);
        }

        System.out.println(totalSimilarity);
    }
}
