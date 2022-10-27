public class Main {
    public static void main(String[] args) {
        HorseBarn a = new HorseBarn(10);
a.add("mary", 15678);
        a.add("karl", 15678);
        a.add("tima", 15678);
        a.add("mary", 15678);
        a.add("rae", 15678);
        a.add("wak", 15678);
        a.add("padr", 15678);
        //System.out.println(a.findHorseSpace("mary"));
        a.delete_hors("karl");
        a.delete_hors("rae");
        a.delete_hors("wak");
        for(int i=0; i<10; i++)
            System.out.println(a.getName(i));
a.consolidate();
for(int i=0; i<10; i++)
    System.out.println(a.getName(i));
    }
}