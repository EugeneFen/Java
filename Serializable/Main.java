import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Person ts = new Person();
        oos.writeObject(ts);
        oos.flush();
        oos.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("temp.txt"));
        Person ts1 = (Person) oin.readObject();
        System.out.println("Name= "+ts1.name);
        System.out.println("Surname= "+ts1.surname);
        System.out.println("Year= "+ts1.year);
        System.out.println("Address= "+ts1.address);
        System.out.println("Old= "+ts1.old); //вычилить возраст по году
    }
}
