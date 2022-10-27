
import java.util.*;


public class StudentAnswerSheet {
    private ArrayList<String> answers; //лист ответов учащегося
    private String name; // имя учащегося

    StudentAnswerSheet()
    {
        ArrayList<String> answers = new ArrayList<String>(10);
    }

    public double getScore(ArrayList<String> key) // правильный ключ передается
    {
        int correct = 0;
        int wrong = 0;
        int no = 0;
        int i = 0;

        while(i < key.size())
        {
            if(answers.get(i) == "?") no++;
            else if(answers.get(i) == key.get(i)) correct++;
            else wrong++;
            i++;
        }
        return ((correct*1)-(wrong*0.25));
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAnswers(ArrayList<String> answers)
    {
        this.answers = answers;
    }
}
