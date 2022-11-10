import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean Name(String name)
    {
        Pattern pattern = Pattern.compile("(\\s*[A-ZА-Я][a-zа-я]{1,20}\\s[A-ZА-Я][a-zа-я]{1,20}\\s[A-ZА-Я][a-zа-я]{1,20}\\s*){1,5}[#]\\s*([A-ZА-Я][a-zа-я]{0,15}(\\s[A-ZА-Я]?[a-zа-я]{0,16}){0,10})?([0-9]{1,4})?\\s*[#]\\s*[A-ZА-Я][a-zа-я]{3,25}\\s*[#]\\s*[A-ZА-Я][a-zа-я]{2,25}([-][A-ZА-Я][a-zа-я]{2,25})?(\\s[A-ZА-Я]?[a-zа-я]{2,25}){0,2}\\s*[#]\\s*[12][098][0-9]{2}\\s*[#]\\s*[0-9]{1,3}\\s*[#]\\s*97[89]5([0-9]{9})\\s*");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static void main(String[] args) {

        System.out.println(Name("Иванов Иван Иванович Rad Kail Martin#We are# Screan # Moscow-Siti#"));
		System.out.println(Name("Иванов Иван Иванович4 # We are are you # Series # Moscow# 1956 # 145 # 1459346274839"));
		System.out.println(Name("Иванов Иван Иванович # We are are you3 # Series # Moscow# 1956 # 145 # 1459346274839"));
		System.out.println(Name("Иванов Иван Иванович # We are are you # Series ha # Moscow# 1956 # 145 # 1459346274839"));
		System.out.println(Name("Иванов Иван Иванович # We are are you # Series # Moscow and Vlad# 1956 # 145 # 1459346274839"));
		System.out.println(Name("Иванов Иван Иванович # We are are you # Series # Moscow# 19564 # 145 # 1459346274839"));
		System.out.println(Name("Иванов Иван Иванович # We are are you # Series # Moscow# 1956 # 1453 # 1459346274839"));
        System.out.println(Name("Иванов Иван Иванович # We are are you # Series # Moscow# 1956 # 145 # 9795346274839"));
		System.out.println(Name(" Семченко Иванна Олеговна  #  We are you # Russia # Russia in Franse # 1956 # 145 # 9785450789045"));
    
    
   // book_data_check a = new book_data_check();
    //System.out.println(book_data_check.Autor("  Семченко Иванна Олеговна   #"));
    //System.out.println(book_data_check.Name(" We are you #"));
    //System.out.println(book_data_check.Publishing_house(" Russia #"));
    //System.out.println(book_data_check.Place(" Russia #"));
    //System.out.println(book_data_check.Place(" Russia-Moscow #"));
    //System.out.println(book_data_check.Place(" Russia in Franse #"));
   // System.out.println(book_data_check.Year(" 1955 #"));
    //System.out.println(book_data_check.IBM(" 9785450789045 #"));
    //System.out.println(book_data_check.Number_of_pages(" 1 #"));
    }
}
