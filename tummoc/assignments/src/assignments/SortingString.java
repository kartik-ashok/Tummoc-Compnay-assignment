package assignments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortingString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
//        System.out.println("Unsorted String: " + inputString);

        String sortedString = "";
        for(String s:sortString(inputString).split("\\s+")) {
        	sortedString=s+" "+sortedString;
        }

        System.out.println("Sorted String: " + sortedString);
    }

    private static String sortString(String inputString) {
        String[] words = inputString.split("\\s+");
//        System.out.println(words.length);
       
        
        Arrays.sort(words, Comparator.comparingInt(String::length).thenComparing(SortingString::charOccurrences));
        return String.join(" ", words);
    }

    private static int charOccurrences(String word) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : word.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int maxOccurrences = 0;
//        System.out.println(charCountMap);
        for (int count : charCountMap.values()) {
            if (count > maxOccurrences) {
                maxOccurrences = count;
            }
        }
//System.out.println(maxOccurrences);
        return maxOccurrences;
    }
	
	
}
