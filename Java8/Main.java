/*
Разработать приложение, осуществляющее обмен данными с БД.
Программа должна запрашивать у пользователя данные, записывать их в базу,
а затем осуществлять запрос к БД и выводить результат,
подтверждающий, что введённые данные находятся в базе.
БД и характер данных выбрать самостоятельно.

ввод данных в класс /-/
запись данных в БД  /+/
проверка на наличие данных в БД  / /
 */

import java.sql.*; //библиотека для работы с SQL

public class Main{

    public static void main(String[] args) {
            try{
                String url = "jdbc:mysql://localhost/book?serverTimezone=Asia/Vladivostok&useSSL=false"; //подключение к БД book с указанием региона
                String username = "root"; //логин к серверу с БД
                String password = "Eugene_21"; //пароль к серверу с БД
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance(); //поключение драйвера для работы с БД
                try (Connection conn = DriverManager.getConnection(url, username, password)){ //подключение к БД

                    System.out.println("Connection to Book DB succesfull!"); //в случае подключения к БД выводиться сообщение о успешном подключении
                    String name_v = "Karlin"; //имя для добавление в таблицу admin, созданную заранее в БД
                    int id_v = 1554; //уникальный номер админа
                    String pasword_v = "readl"; //уникальный пароль админа
                    int id_w = id_v; //переменная для проверки на наличие записи в таблице

                    Statement statement = conn.createStatement(); //класс для SQL запросов к таблице
                    int rows = statement.executeUpdate("INSERT admin VALUES ('" + name_v + "', " + id_v + ", '"+pasword_v+"')"); //дабавление записи в таблицу (или несколько записей)
                    System.out.println(rows); //сколько строк было добавленно в таблицу

                    ResultSet check = statement.executeQuery("SELECT * FROM admin WHERE id = " + id_w + ""); //поиск записи в таблице и вывод в переменную
                    while(check.next()) {
                        String name = check.getString(1); //вывод данных в переменную из 1 столбца
                        int id = check.getInt(2); //вывод данных в переменную из 2 столбца
                        System.out.printf("%s \n", name); //вывод имени из записи на консоль
                        if (id == id_v) System.out.println("Yes"); //в случае, если уникальный номер совпадает с искомым, то выводим на консоль подтверждение
                        else System.out.println("No"); //вы противном случае выводиться отрицание
                    }
                    boolean end = statement.execute("DELETE FROM admin WHERE id = " + id_v + ""); //удаление записи из таблицы
                }
            }
            catch(Exception ex) {
                System.out.println("Connection failed..."); //неудалось подключиться к БД или найти дравер
                System.out.println(ex); //вывод ошибки на экран
            }
    }
}
