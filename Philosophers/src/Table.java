public class Table {
    int rice;
    boolean loker;
    public Table(){
        this.rice = 0;
        loker = true;
    }
    public void setLock(){
        loker = false;
    }
    public void setUnLock(){
        loker = true;
    }
    public boolean getLock(){
        return(loker);
    }
    public void addRice(){
        this.rice++;
    }
    public int getRice(){
        return(this.rice);
    }
}
