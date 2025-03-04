package time;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    void testGetTotalSeconds() {
        assertEquals(3661, Time.getTotalSeconds("01:01:01"));
        assertEquals(3600, Time.getTotalSeconds("01:00:00"));
        assertEquals(59, Time.getTotalSeconds("00:00:59"));
    }

    @Test
    void testGetSeconds() {
        assertEquals(30, Time.getSeconds("12:34:30"));
        assertEquals(0, Time.getSeconds("05:45:00"));
    }

    @Test
    void testGetTotalMinutes() {
        assertEquals(34, Time.getTotalMinutes("12:34:30"));
        assertEquals(0, Time.getTotalMinutes("05:00:59"));
    }

    @Test
    void testGetTotalHours() {
        assertEquals(12, Time.getTotalHours("12:34:30"));
        assertEquals(5, Time.getTotalHours("05:45:00"));
    }

    @Test
    void testGetMilliseconds() {
        assertEquals(99, Time.getMilliseconds("12:34:30:99"));
        assertEquals(50, Time.getMilliseconds("05:45:00:50"));
    }

    @Test
    void testInvalidTimeFormat() {
        assertThrows(NumberFormatException.class, () -> Time.getTotalSeconds("12:34"));
        assertThrows(NumberFormatException.class, () -> Time.getTotalMinutes("abcd:ef:gh"));
        assertThrows(IllegalArgumentException.class, () -> Time.getMilliseconds("12:34:56"));
    }
}