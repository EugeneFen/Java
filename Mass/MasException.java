//Класс с сообщениями об ошибке
public class MasException extends Exception {
    public String toString1() //при переполнении добавление
    {
        return ("Out of bounds array < 5");
    }
    public String toString2() //при пустом массиве удаление
    {
        return ("Out of bounds array > 5");
    }
    public String toString3() //при поиске в пустом массиве
    {
        return ("Array is empty");
    }
}
