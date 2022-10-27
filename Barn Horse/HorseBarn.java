public class HorseBarn {//implements Horse{
    private Horse[] spaces;
    private int size_mas;
    public HorseBarn(int n)
    {
        this.size_mas = n;
        this.spaces = new Horse[n];
        for (int i =0; i< size_mas; i++)
        {
            this.spaces[i] = new Horse();
        }
    }
    public int findHorseSpace (String name) //вазвращает пространство содержащее лошадь с указаным именем
    {
        for(int i = 0; i<size_mas; i++)
        {
            String bname = spaces[i].getName();
            if (bname == name) return i;
        }
        return -1;
    }
    public void consolidate() //убирает пробелы между лошадьми
    {
        String bname, buff;
        for(int i=0; i<size_mas; i++)
        {
            bname = spaces[i].getName();
            if (bname == "-")
            {
                int j = i;
                buff = spaces[j].getName();
                while (j < size_mas-1 && buff == "-")
                {
                    j++;
                    buff = spaces[j].getName();
                }
                spaces[i].setName(spaces[j].getName());
                spaces[i].setWeight(spaces[j].getWeight());
                spaces[j].setName("-");
                spaces[j].setWeight(0);
            }
        }
    }
    public String getName(int n) //выдает имя лошади
    {
        return this.spaces[n].getName();
    }
    public int getWeight(int n) //выдает вес лошади
    {
        return this.spaces[n].getWeight();
    }
    public void add(String name, int weight)
    {
        boolean might = true;
        for(int i = 0; i<size_mas; i++)
        {
            String bname = this.spaces[i].getName();
            if (bname == name) might = false;
        }
        if (might == true)
        {
            int i =-1;
            String bname;
            do {
                i++;
                bname = this.spaces[i].getName();
            } while (bname != "-" && i<size_mas);
                if (i == size_mas-1) System.out.println("No more");
                else if (bname == "-")
                {
                    this.spaces[i].setName(name);
                    this.spaces[i].setWeight(weight);
                }
        }
        else System.out.println("repetition");
    }
    public void delete_hors(String name)
    {
        int i =-1;
        String bname;
        do {
            i++;
            bname = this.spaces[i].getName();
        } while (bname != name && i<size_mas);
        if(i<size_mas-1)
        {
            this.spaces[i].setName("-");
            this.spaces[i].setWeight(0);
            System.out.println("OK");
        }
        else System.out.println("NO");
    }
}
