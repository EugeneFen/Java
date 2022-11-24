import static java.sql.Types.NULL;

//класс массива
public class Excepti  {
    private static int[] count; //массив цифр
    static int size = 5; //размер массива
    
    Excepti() //конструктор
    {
        count = new int[size]; //определение массива
        for(int i = 0; i<size; i++) //обнуление ячеек массива
        {
            count[i] = NULL;
        }
    }
    //добавление элементов в массив
    public static void setAdd(int number) throws MasException //мотод с исключение (пожтому тот написано throws). MasException - класс (см. следующий файл)
    {
        int i = 0; //счетчик для хождения по масссиву
        try
        {
            while (count[i] != NULL ) { //ищем пустую ячейку
                i++;
                if (i >= size) throw new MasException(); //если при поиске счетчик выодит за пределы массива, то кидается исключение
            }
            count[i] = number; //если нашли пустое место, то заполняем его
        } catch (MasException e) //создается обект исключения
        {
            System.out.println("Exception: "+e.toString1()); //выписывается сообщение
        }
    }
    //удаление элемента
    public static void DelElement() throws MasException
    {
        int i = 4; //начинаем с конца
        try {
            while (count[i] == NULL ) { //ищем заполненую ячейку
                i--;
                if (i <= size) throw new MasException(); //если при поиске счетчик выодит за пределы массива, то кидается исключение
            }
            count[i] = NULL; //если нашли заполненое место, то обнуляем его
        } catch (MasException e)
        {
            System.out.println("Exception: "+e.toString2()); //выводим сообщение об ошибке
        }
    }
    //поиск эл
    public static void Search(int num) throws MasException
    {
        int i = 0; //для хождения по массиву
        try {
            if (count[1] == NULL) throw new MasException(); //если массив оказался пуст, то выдаем ошибку
            while (count[i] != num && i < size) i++; //пока не найдем элемент в массиве ИЛИ не дошли до конца
            if (count[i] == num) System.out.println("There is such an element. Index: " + i); //если нашли эл, то выдаем сообщение
            else if(i == size) System.out.println("No such element"); //если прошли весь массив, то выдаем сообщение
        }
        catch (MasException e) //создается обект исключения
        {
            System.out.println("Exception: "+e.toString3()); //выписывается сообщение
        }
    }
    
    //дальше идет код, для реализации без доп класса (или своего отдельного класса), но это не по заданию)
  /*  public void setAdd(int number)
    {
        try
        {
            int i = 0;
            while (this.count[i] != 0 ) i++;
            this.count[i] = number;
            //System.out.print(i);
        } catch (IndexOutOfBoundsException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public int getElement(int i)
    {
        try
        {
            return(this.count[i]);
        } catch (IndexOutOfBoundsException e)
        {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }
    public void Del()
    {
        try
        {
            int i = 4;
            while (this.count[i] == 0) i--;
            this.count[i] = 0;
        } catch (IndexOutOfBoundsException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }*/
}
