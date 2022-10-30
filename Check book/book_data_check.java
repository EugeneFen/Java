import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class book_data_check {
    public static boolean Name(String name)
    {
        Pattern pattern = Pattern.compile("[\sA-Za-zа-яА-Я0-9]*");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean Publishing_house(String name)
    {
        /*
        Одно слово с заглавной буквы без пробелов.
        "Эсмо" "Карл"
         */
        Pattern pattern = Pattern.compile("[A-ZА-Я]([a-zA-Zа-яА-Я]*)");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean Place(String name)
    {
        /*
        Название города. Слово, два слова или название через дефиз. После слова может быть пробел
         */
        Pattern pattern = Pattern.compile("[A-ZА-Я]([a-zA-Zа-яА-Я]*)([-]*)([\sa-zA-Zа-яА-Я]*)");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean IBM(String num)
    {
        /*

        */
        Pattern pattern = Pattern.compile("[0-9]{13}");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }

    public static boolean Year(String year)
    {
        /*
        Формат "1789"
        Только 4 цифры. Никаких пробелов.
        */
        Pattern pattern = Pattern.compile("[0-9]{4}");
        Matcher matcher = pattern.matcher(year);
        return matcher.matches();
    }

    public static boolean Author(String name)
    {
        /*
        Фармат "Иванов Иван Иванович"
        в каждом слове мин 3 символа. только 3 слова, через 1 пробел каждое.
        каждое слово пишется с заглавной буквы
        перед словом и после пробедов быть не должно
         */
        Pattern pattern = Pattern.compile("[A-ZА-Я]([a-zA-Zа-яА-Я]{3})([a-zA-Zа-яА-Я]*)\\s([A-ZА-Я]([a-zA-Zа-яА-Я]{3})([a-zA-Zа-яА-Я]*))\\s([A-ZА-Я]([a-zA-Zа-яА-Я]{3})([a-zA-Zа-яА-Я]*))");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean Number_of_pages(String number)
    {
        /*
        Формат "1" "13" "125"
        Страниц до 1000.
         */
        Pattern pattern = Pattern.compile("[0-9]{1,3}");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
