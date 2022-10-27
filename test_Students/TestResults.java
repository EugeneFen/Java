import java.util.*;

public class TestResults {
    private ArrayList<String> sheets; //лист ответов

    public String highestScoringStudent(ArrayList<String> key, StudentAnswerSheet student1, StudentAnswerSheet student2) //должен возвращать имя учащегося
    {
        double buff = student1.getScore(key);
        double buff2 = student2.getScore(key);
        
        if (buff > buff2) return student1.getName();
        else return student2.getName();
    }
    TestResults()
    {
        ArrayList<String> sheets1 = new ArrayList<String>(10);
    }
}
