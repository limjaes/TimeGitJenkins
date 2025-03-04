package time;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TimeTest {

    // getTotalSeconds()
    // Good case: Proper time format
    @Test
    void testGetTotalSecondsGood() {
        int seconds = Time.getTotalSeconds("05:05:05");
        assertEquals(18305, seconds, "The seconds were not calculated properly");
    }

    // Good case with milliseconds included
    @Test
    void testGetTotalSecondsGoodWithMilliseconds() {
        int seconds = Time.getTotalSeconds("05:05:05:10");
        assertEquals(18305, seconds, "The seconds were not calculated properly with milliseconds");
    }

    // Bad case: Missing seconds
    @Test
    void testGetTotalSecondsBad() {
        assertThrows(
            StringIndexOutOfBoundsException.class, 
            () -> Time.getTotalSeconds("10:00")
        );
    }

    // Boundary case: Edge time values (00:00:00)
    @Test
    void testGetTotalSecondsBoundary() {
        int seconds = Time.getTotalSeconds("00:00:00");
        assertEquals(0, seconds, "Boundary test failed for time 00:00:00");
    }

    // getSeconds()
    // Good case: Proper seconds extraction
    @Test
    void testGetSecondsGood() {
        int seconds = Time.getSeconds("12:34:56");
        assertEquals(56, seconds, "The seconds were not extracted properly");
    }

    // Bad case: Missing seconds
    @Test
    void testGetSecondsBad() {
        assertThrows(
            StringIndexOutOfBoundsException.class, 
            () -> Time.getSeconds("12:34")
        );
    }

    // Boundary case: Seconds are 00
    @Test
    void testGetSecondsBoundary() {
        int seconds = Time.getSeconds("12:34:00");
        assertEquals(0, seconds, "Boundary test failed for seconds 00");
    }

    // getTotalMinutes()
    // Good case: Proper minutes extraction
    @Test
    void testGetTotalMinutesGood() {
        int minutes = Time.getTotalMinutes("12:34:56");
        assertEquals(34, minutes, "The minutes were not extracted properly");
    }

    // Good case with milliseconds included
    @Test
    void testGetTotalMinutesGoodWithMilliseconds() {
        int minutes = Time.getTotalMinutes("12:34:56:99");
        assertEquals(34, minutes, "The minutes were not extracted properly with milliseconds");
    }

    // Bad case: Time format too long
    @Test
    void testGetTotalMinutesBad() {
        assertThrows(
            NumberFormatException.class, 
            () -> Time.getTotalMinutes("12:34:5678")
        );
    }

    // Boundary case: Minutes are 00
    @Test
    void testGetTotalMinutesBoundary() {
        int minutes = Time.getTotalMinutes("12:00:56");
        assertEquals(0, minutes, "Boundary test failed for minutes 00");
    }

    // getTotalHours()
    // Good case: Proper hours extraction
    @Test
    void testGetTotalHoursGood() {
        int hours = Time.getTotalHours("12:34:56");
        assertEquals(12, hours, "The hours were not extracted properly");
    }

    // Bad case: Time format too short
    @Test
    void testGetTotalHoursBad() {
        assertThrows(
            StringIndexOutOfBoundsException.class, 
            () -> Time.getTotalHours("1")
        );
    }

    // Boundary case: Hours are 00
    @Test
    void testGetTotalHoursBoundary() {
        int hours = Time.getTotalHours("00:34:56");
        assertEquals(0, hours, "Boundary test failed for hours 00");
    }

    // getMilliseconds()
    // Good case
    @Test
    void testGetMillisecondsGood() {
        String time = "12:05:05:05";
        int expectedMilliseconds = 5;
        assertEquals(expectedMilliseconds, Time.getMilliseconds(time));
    }

    // Bad case: Invalid format (wrong separators)
    @Test
    void testGetMillisecondsBadFormat() {
        String invalidTime = "12-05-05-05";
        assertThrows(IllegalArgumentException.class, () -> Time.getMilliseconds(invalidTime));
    }

    // Bad case: Too short format
    @Test
    void testGetMillisecondsTooShort() {
        String invalidTime = "12:05:05";
        assertThrows(IllegalArgumentException.class, () -> Time.getMilliseconds(invalidTime));
    }

    // Boundary case: Maximum millisecond value (99)
    @Test
    void testGetMillisecondsMaxBoundary() {
        String time = "23:59:59:99";
        int expectedMilliseconds = 99;
        assertEquals(expectedMilliseconds, Time.getMilliseconds(time));
    }

    // Boundary case: Minimum millisecond value (00)
    @Test
    void testGetMillisecondsMinBoundary() {
        String time = "00:00:00:00";
        int expectedMilliseconds = 0;
        assertEquals(expectedMilliseconds, Time.getMilliseconds(time));
    }
}
