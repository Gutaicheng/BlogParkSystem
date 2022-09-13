package com.gutaicheng.controller;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyFormatter implements Formatter<Date> {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return dateFormat.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }
}
