package com.avaliacao.federacoes.utils;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateTimeAttributeConverterTest {

    private static final int YEAR = 2019;
    private static final Month MONTH = Month.NOVEMBER;
    private static final int DAY = 28;
    private static final int HOUR = 20;
    private static final int MINUTE = 36;
    private static final int SECOND = 40;
    private static final int MILLIS = 0;

    @Test
    void testConvertToDatabaseColumnEquals() throws ParseException {
        LocalDateTimeAttributeConverter localDate = new LocalDateTimeAttributeConverter();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = dateFormat.parse(YEAR + "-" + MONTH.getValue() + "-" + DAY + " " +
                HOUR + ":" + MINUTE + ":" + SECOND + "." + MILLIS);
        Timestamp todayTimestamp = new Timestamp(parsedDate.getTime());
        LocalDateTime result = localDate.convertToEntityAttribute(todayTimestamp);

        LocalDateTime todayLocalDateTime = LocalDateTime.of(YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, MILLIS);
        assertEquals(result, todayLocalDateTime);
    }

    @Test
    void testConvertToDatabaseColumnDiff() throws ParseException {
        LocalDateTimeAttributeConverter localDate = new LocalDateTimeAttributeConverter();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = dateFormat.parse(YEAR + "-" + MONTH.getValue() + "-" + DAY + " " +
                HOUR + ":" + MINUTE + ":" + SECOND + "." + MILLIS);
        Timestamp todayTimestamp = new Timestamp(parsedDate.getTime());
        LocalDateTime result = localDate.convertToEntityAttribute(todayTimestamp);

        LocalDateTime todayLocalDateTime = LocalDateTime.now();
        assertNotEquals(result, todayLocalDateTime);
    }

    @Test
    void testConvertToDatabaseColumnNull() {
        LocalDateTimeAttributeConverter localDate = new LocalDateTimeAttributeConverter();
        LocalDateTime result = localDate.convertToEntityAttribute(null);
        assertNull(result);
    }

    @Test
    void testConvertToEntityAttributeEquals() throws ParseException {
        LocalDateTime todayLocalDateTime = LocalDateTime.of(YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, MILLIS);
        LocalDateTimeAttributeConverter localDate = new LocalDateTimeAttributeConverter();
        Timestamp result = localDate.convertToDatabaseColumn(todayLocalDateTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = dateFormat.parse(YEAR + "-" + MONTH.getValue() + "-" + DAY + " " +
                HOUR + ":" + MINUTE + ":" + SECOND + "." + MILLIS);
        Timestamp todayTimestamp = new Timestamp(parsedDate.getTime());
        assertEquals(result, todayTimestamp);
    }

    @Test
    void testConvertToEntityAttributeDiff() throws ParseException {
        LocalDateTime todayLocalDateTime = LocalDateTime.now();
        LocalDateTimeAttributeConverter localDate = new LocalDateTimeAttributeConverter();
        Timestamp result = localDate.convertToDatabaseColumn(todayLocalDateTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = dateFormat.parse(YEAR + "-" + MONTH.getValue() + "-" + DAY + " " +
                HOUR + ":" + MINUTE + ":" + SECOND + "." + MILLIS);
        Timestamp todayTimestamp = new Timestamp(parsedDate.getTime());
        assertNotEquals(result, todayTimestamp);
    }

    @Test
    void testConvertToEntityAttributeNull() {
        LocalDateTimeAttributeConverter localDate = new LocalDateTimeAttributeConverter();
        Timestamp result = localDate.convertToDatabaseColumn(null);
        assertNull(result);
    }
}