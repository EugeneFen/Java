public class Philosophers implements Runnable{
    private int id;
    private Table myTable;
    private int count;
    public Philosophers(int id,Table tab){
        this.id=id;
        myTable=tab;
        count = 0;
    }

    @Override
    public void run()	//Этот метод будет выполнен в побочном потоке
    {
        for(int j=0; j<6; j++) {
                try {
                    if(myTable.getLock()) {
                        myTable.setLock();
                        System.out.println("Philosopher " + id + " eat.");
                        count++;
                        myTable.addRice();
                        Thread.sleep(200);
                        myTable.setUnLock();
                        System.out.println("Philosopher " + id + " thinks!");
                        double a = Math.random()*6;
                        if(a > 3) Thread.sleep(500);
                        else Thread.sleep(300);
                    } else {
                        System.out.println("Philosopher " + id + " thinks.");
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
        }
        System.out.println("Philosopher " + id + "  " + count);
    }
}

 /*   Несколько философов сидят вокруг стола, посреди которого стоит тарелка с рисом +
        Каждый философ либо размышляет (спит), либо ест
        Брать рис из тарелки в один момент времени может только один философ (то есть тарелка - общий ресурс, с синхронизированным доступом к нему).
        Философы размышляют в течение случайного времени, потом едят рис из тарелки в течение фиксированного времени. На это время доступ к тарелке других философов блокируется.
        Программа должна выдавать (например, на консоль) информацию о том, что делает каждый философ и сколько риса он съел. Считать, что в тарелке бесконечный запас риса.
*/