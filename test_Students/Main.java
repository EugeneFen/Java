import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> answers = new ArrayList<String>(10);
        ArrayList<String> answers2 = new ArrayList<String>(10);
        ArrayList<String> test    = new ArrayList<String>(10);
        answers.add("A"); answers.add("B"); answers.add("D");
		answers.add("E"); answers.add("A"); answers.add("C");
		answers.add("?"); answers.add("B"); answers.add("D");
		answers.add("C");
        answers2.add("A"); answers2.add("B"); answers2.add("D");
		answers2.add("E"); answers2.add("A"); answers2.add("C"); //answers2.add("E");
		answers2.add("?"); answers2.add("B"); answers2.add("D"); //answers2.add("B");
		answers2.add("C");
        test.add("A"); test.add("C");  test.add("D"); 
		test.add("E"); test.add("B");  test.add("C");
		test.add("E"); test.add("B");  test.add("B");
		test.add("C");

        StudentAnswerSheet smeat = new StudentAnswerSheet();
         StudentAnswerSheet karl = new StudentAnswerSheet();
         TestResults master = new TestResults();
        smeat.setName("Karlik");
        smeat.setAnswers(answers);
        karl.setName("mari");
        karl.setAnswers(answers2);
        
        System.out.println("Karlik  " + smeat.getScore(test));
        System.out.println("mari  " + karl.getScore(test));
        System.out.println(master.highestScoringStudent(test, smeat, karl));
    }
}
