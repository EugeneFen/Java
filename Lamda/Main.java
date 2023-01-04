/*
Лямбда-выражение — это такая функция. Можете считать, что это обычный метод в Java,
только его особенность в том, что его можно передавать в другие методы в качестве аргумента.

возвращающего ту строку, которая длиннее. ++++++
возвращающего строку с наибольшим числом гласных букв, +++
возвращающего строку с наибольшим числом заглавных букв. ++++

Продемонстрировать работу интерфейса на задачах поиска в файле, соответственно,
самой длинной строки, +++++
строки с наибольшим числом гласных букв,
строки с наибольшим числом заглавных букв.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> write_line = new ArrayList<String>();
        Operationable operation_1 = (x,y) -> { //выясняем какая строка длинее
            if(x.length() > y.length()) return x;
            else return y;
        };
        Operationable operation_2 = (x,y) -> {
            int count_1 = 0;
            int count_2 = 0;
            String vowels = "[а,о,и,е,ё,ы,я,э,у,ю]";
            Pattern pattern = Pattern.compile(vowels);
            Matcher matcher_1 = pattern.matcher(x);
            Matcher matcher_2 = pattern.matcher(y);
            while(matcher_1.find()) count_1++;
            while(matcher_2.find()) count_2++;
            //System.out.println(count_1 + "  3");
            //System.out.println(count_2 + "  3");
            if(count_1 > count_2) return x;
            else return y;
        };
        Operationable operation_3 = (x,y) -> {
            int count_1 = 0;
            int count_2 = 0;
            String capital_letters = "[А-Я]";
            Pattern pattern = Pattern.compile(capital_letters);
            Matcher matcher_1 = pattern.matcher(x);
            Matcher matcher_2 = pattern.matcher(y);
            while(matcher_1.find()) count_1++;
            while(matcher_2.find()) count_2++;
            //System.out.println(count_1 + "  3");
            //System.out.println(count_2 + "  3");
            if(count_1 > count_2) return x;
            else return y;
        };

        try {
            File doc = new File("Line.txt");
            Scanner sc = new Scanner(doc);
        while(sc.hasNext()) {
            write_line.add(sc.nextLine());
            }
            sc.close();  // Закрываем сканер
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }

        String max = " ";
        String max_vowels = " ";
        String max_capital_letters = " ";
        for(int i=0; i<write_line.size(); i++) {
            //System.out.println(write_line.get(i));
            max = operation_1.choice(write_line.get(i), max);
            max_vowels = operation_2.choice(write_line.get(i), max_vowels);
            max_capital_letters = operation_3.choice(write_line.get(i), max_capital_letters);
        }
        System.out.println(max);
        System.out.println(max_vowels);
        System.out.println(max_capital_letters);
        //System.out.println(operation_1.choice("Привет", "Пооооока"));
        //System.out.println(operation_2.choice("Привеот", "Пока"));
        //System.out.println(operation_3.choice("ПриВеКРТт", "Пока"));
    }
}
interface Operationable{
    String choice(String x, String y);
}
