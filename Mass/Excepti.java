import static java.sql.Types.NULL;

public class Excepti  {
    private static int[] count; //массив цифр

    Excepti()
    {
        count = new int[5];
        for(int i = 0; i<5; i++)
        {
            count[i] = NULL;
        }
    } //определяет размер массива
    public static void setAdd(int number) throws MasException //мотод с исключение (пожтому тот написано throws). MasException - класс (см. следующий файл)
    {
        int i = 0; //счетчик для хождения по масссиву
        try
        {
            while (count[i] != NULL ) { //ищем пустую ячейку
                i++;
                if (i >= 5) throw new MasException(); //если при поиске счетчик выодит за пределы массива, то кидается исключение
            }
            count[i] = number; //если нашли пустое место, то заполняем его
        } catch (MasException e) //создается обект исключения
        {
            System.out.println("Exception: "+e.toString1()); //выписывается сообщение
        }
        //("Out of bounds 5");

    }

    public static void DelElement() throws MasException
    {
        int i = 4;
        try {
            while (count[i] == NULL ) { //ищем заполненую ячейку
                i--;
                if (i <= 5) throw new MasException(); //если при поиске счетчик выодит за пределы массива, то кидается исключение
            }
            count[i] = NULL; //если нашли заполненое место, то обнуляем его
        } catch (MasException e)
        {
            System.out.println("Exception: "+e.toString2()); //выводим сообщение об ошибке
        }
    }
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
