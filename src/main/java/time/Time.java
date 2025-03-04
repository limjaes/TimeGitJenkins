package time;

import javax.swing.JOptionPane;

/**
 * Taken from Wendi Jollymore :http://www-acad.sheridanc.on.ca/~jollymor/prog24178/oop2.html
 * @modified by Liz Dancy
 * Used as a base class for the testing exercise with JUnit
 * Winter 2021
 */
public class Time {
    public static void main(String[] args) {
        // ICE6
        int totalSeconds = getTotalSeconds("10:10:10:00");
        System.out.println("Github Seconds = " + totalSeconds);

        try {
            String time = JOptionPane.showInputDialog(null,
                    "Enter a time in the format hh:mm:ss", "Enter Time",
                    JOptionPane.QUESTION_MESSAGE);

            int inputSeconds = getTotalSeconds(time);
            JOptionPane.showMessageDialog(null, inputSeconds, "Total Seconds",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,
                    "You entered the time in the wrong format.\n" +
                            "Please enter the time in the form hh:mm:ss or hh:mm:ss:ms",
                    "Invalid Time", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "You entered an invalid time.\nPlease enter numbers only.",
                    "Invalid Time", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("An unexpected Exception occurred");
        }
    }

    public static int getTotalSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        int hours = getTotalHours(time);
        int minutes = getTotalMinutes(time);
        int seconds = getSeconds(time);
        return hours * 3600 + minutes * 60 + seconds;
    }

    public static int getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        return Integer.parseInt(time.substring(6, 8));
    }

    public static int getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        if (time.length() == 11) {
            return Integer.parseInt(time.substring(3, 5)); 
        } else if (time.length() == 8) {
            return Integer.parseInt(time.substring(3, 5));
        } else {
            throw new NumberFormatException("Invalid time format! Expected hh:mm:ss or hh:mm:ss:ms");
        }
    }

    public static int getTotalHours(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        return Integer.parseInt(time.substring(0, 2));
    }

    public static int getMilliseconds(String time) throws IllegalArgumentException {
        if (time == null || time.length() != 11 || !time.matches("\\d{2}:\\d{2}:\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Invalid time format. Expected format: hh:mm:ss:ms");
        }
        return Integer.parseInt(time.substring(9, 11));
    }
}
