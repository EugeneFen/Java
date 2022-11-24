import java.io.Serializable;

/*
только одна вещь отличается от создания нормального класса,
это реализация интерфейса java.io.Serializable. Интерфейс Serializable это интерфейс-маркер;
в нём не задекларировано ни одного метода. Но говорит сериализующему механизму,
что класс может быть сериализован.
 */
public class Person implements Serializable{
    public String name = "Kevin";
    public String surname = "Minion";
    public int year = 1985;
    public String address = "New York, Deribasovskaya street, 43, apartment 12";
    public int old = 36;

}

