package otus.spring.albot.lesson1.game;

import otus.spring.albot.lesson1.handler.QuestionHandler;
import otus.spring.albot.lesson1.handler.QuestionHandlerFactory;
import otus.spring.albot.lesson1.model.ParsedLine;

import java.util.List;
import java.util.Scanner;

/**
 * @author Dmitrii Albot
 */
public class GameManager {
    private QuestionHandlerFactory factory;
    private Scanner scanner;
    private int counter;
    private int correctAnswers;

    public GameManager(QuestionHandlerFactory factory) {
        this.factory = factory;
        this.scanner = new Scanner(System.in);
    }

    public void startGame(List<ParsedLine> questions) {
        describeRules();
        askQuestions(questions);
        showResults();
    }

    private void describeRules() {
        System.out.println("hi");
    }

    private void askQuestions(List<ParsedLine> questions) {
        for (ParsedLine question : questions) {
            QuestionHandler handler = factory.getHandler(question.getType());
            handler.askQuestion(++counter, question);
            String answer = waitForAnswer();
            handleAnswer(question, answer);
        }
    }

    private void handleAnswer(ParsedLine question, String answer) {
        QuestionHandler handler = factory.getHandler(question.getType());
        boolean correct = handler.handleQuestion(question, answer);
        if (correct) {
            correctAnswers++;
        }
    }

    private String waitForAnswer() {
        return scanner.next();
    }

    private void showResults() {
        System.out.printf("You correctly answered on %d from %d questions", correctAnswers, counter);
    }
}
