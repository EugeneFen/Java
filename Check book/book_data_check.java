import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class book_data_check {
    public static boolean Autor(String name)
    {
        Pattern pattern = Pattern.compile("(\\s*[A-ZА-Я][a-zа-я]{1,20}\\s[A-ZА-Я][a-zа-я]{1,20}\\s[A-ZА-Я][a-zа-я]{1,20}\\s*){1,5}[#]");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean Publishing_house(String name)
    {
        /*
        Одно слово с заглавной буквы без пробелов.
        "Эсмо" "Карл"
         */
        Pattern pattern = Pattern.compile("\\s*[A-ZА-Я][a-zа-я]{3,25}\\s*[#]");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean Place(String name)
    {
        /*
        Название города. Слово, два слова или название через дефиз. После слова может быть пробел
         */
        Pattern pattern = Pattern.compile("\\s*[A-ZА-Я][a-zа-я]{2,25}([-][A-ZА-Я][a-zа-я]{2,25})?(\\s[A-ZА-Я]?[a-zа-я]{2,25}){0,2}\\s*[#]");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean IBM(String num)
    {
        /*

        */
        Pattern pattern = Pattern.compile("\\s*97[89]5([0-9]{9})\\s*[#]");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }

    public static boolean Year(String year)
    {
        /*
        Формат "1789"
        Только 4 цифры. Никаких пробелов.
        */
        Pattern pattern = Pattern.compile("\\s*[12][098][0-9]{2}\\s*[#]");
        Matcher matcher = pattern.matcher(year);
        return matcher.matches();
    }

    public static boolean Name(String name)
    {
        /*
        Фармат "Иванов Иван Иванович"
        в каждом слове мин 3 символа. только 3 слова, через 1 пробел каждое.
        каждое слово пишется с заглавной буквы
        перед словом и после пробедов быть не должно
         */
        Pattern pattern = Pattern.compile("\\s*([A-ZА-Я][a-zа-я]{0,15}(\\s[A-ZА-Я]?[a-zа-я]{0,16}){0,10})?([0-9]{1,4})?\\s*[#]");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean Number_of_pages(String number)
    {
        /*
        Формат "1" "13" "125"
        Страниц до 1000.
         */
        Pattern pattern = Pattern.compile("\\s*[0-9]{1,3}\\s*[#]");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
