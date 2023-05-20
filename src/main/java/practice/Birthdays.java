package practice;

import net.sf.saxon.expr.parser.Loc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        LocalDate birhday = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("E").localizedBy(Locale.forLanguageTag("en"));
        String text = "";

        for (int i = 0; ; i++){
            if (now.isBefore(birhday)){
                break;
            }
            text = text + i + " - " + dateFormat.format(birhday) + " - " + formatter.format(birhday)
                    + System.lineSeparator();

            if (now.isEqual(birhday)){
                break;
            }
            birhday = birhday.plusYears(1);
        }
        return text;
    }
}
