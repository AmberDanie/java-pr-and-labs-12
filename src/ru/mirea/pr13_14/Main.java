package ru.mirea.pr13_14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* задание 1 */
        System.out.println("1 задание");
        Calendar now = new GregorianCalendar(2022, 10, 17);
        Date cur = now.getTime();
        System.out.println("Сейчас: " + cur);
        System.out.println("Введите дату в формате (день.месяц.год)");
        String input_datetime = new Scanner(System.in).nextLine();

        String[] inp_date = input_datetime.split("\\.");
        Calendar input_datetime_obj = new GregorianCalendar(Integer.parseInt(inp_date[2]),
                Integer.parseInt(inp_date[1]), Integer.parseInt(inp_date[0]));
        System.out.println(input_datetime_obj.getTime());
        System.out.println(cur);
        int comp = cur.compareTo(input_datetime_obj.getTime());
        if (comp == 0) {
            System.out.println("Даты совпадают");
        } else if (comp < 0) {
            System.out.println("Даты не совпадают. Введенная дата позже");
        } else {
            System.out.println("Даты не совпадают. Введенная дата раньше");
        }
        /* задание 2 */
        System.out.println("Задание 2");
        System.out.println("Введите дату (yyyyMMddHHmm): ");
        try {
            String input = new Scanner(System.in).nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
            Date inputted_datetime_obj = formatter.parse(input);
            System.out.println("DATE OBJ: " + inputted_datetime_obj);
            Calendar inputted_calendar_obj = Calendar.getInstance();
            inputted_calendar_obj.setTime(formatter.parse(input));
            System.out.println("CALENDAR OBJ: " + inputted_calendar_obj.getTime());
        } catch (ParseException e) {
            System.out.println(e);
        }
    }
}
