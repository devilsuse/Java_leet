package com.nano.core;

import java.text.DateFormat;
import java.text.spi.DateFormatProvider;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

public class DateTester {
    public static void main(String[] args) {

        DateTimeFormatter df = null; // new DateTimeFormatter();  Builder();
        Date date = new Date();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        DateFormatProvider a = new DateFormatProvider() {
            @Override
            public DateFormat getTimeInstance(int style, Locale locale) {
                return null;
            }

            @Override
            public DateFormat getDateInstance(int style, Locale locale) {
                return null;
            }

            @Override
            public DateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale locale) {
                return null;
            }

            @Override
            public Locale[] getAvailableLocales() {
                return new Locale[0];
            }
        }
    }
}
