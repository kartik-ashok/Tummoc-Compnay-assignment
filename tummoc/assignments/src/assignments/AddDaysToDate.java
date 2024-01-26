package assignments;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AddDaysToDate {

    public static String addDaysToDate(String inputDate, int daysToAdd) {
        try {
            // Define the date format
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            // Parse the input date string to a Date object
            Date date = dateFormat.parse(inputDate);

            // Create a Calendar instance and set it to the parsed date
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Add the specified number of days
            calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);

            // Format the new date as a string
            String newDate = dateFormat.format(calendar.getTime());

            return newDate;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use the format dd-MM-yyyy.");
            System.exit(1);
            return null; // Unreachable, but needed for compiler
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input date from user
        System.out.print("Enter the date (dd-MM-yyyy): ");
        String inputDate = scanner.next();

        // Get days to add from user
        System.out.print("Enter the number of days to add: ");
        int daysToAdd = scanner.nextInt();

        // Call the method to add days to the date
        String resultDate = addDaysToDate(inputDate, daysToAdd);

        // Print the result
        System.out.println("Result Date: " + resultDate);

        // Close the scanner
        scanner.close();
    }
}
