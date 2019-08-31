package otus.spring.albot.lesson1.handler;

import otus.spring.albot.lesson1.handler.ChoiceQH;
import otus.spring.albot.lesson1.handler.CommonQH;
import otus.spring.albot.lesson1.handler.MultipleChoiceQH;
import otus.spring.albot.lesson1.handler.QuestionHandler;
import otus.spring.albot.lesson1.handler.TrueFalseQH;
import otus.spring.albot.lesson1.model.QuestionType;

/**
 * @author Dmitrii Albot
 */
public class QuestionHandlerFactory {
    private QuestionHandler choiceQH;
    private QuestionHandler multChoiceQH;
    private QuestionHandler trueFalseQH;
    private QuestionHandler commonQH;

    public QuestionHandler getHandler(QuestionType type) {
        switch (type) {
            case C:
                return getChoiceQH();
            case MC:
                return getMultChoiceQH();
            case TF:
                return getTrueFalseQH();
            default:
                return getCommonQH();
        }
    }

    private QuestionHandler getChoiceQH() {
        if (choiceQH == null) {
            choiceQH = new ChoiceQH();
        }
        return choiceQH;
    }

    private QuestionHandler getMultChoiceQH() {
        if (multChoiceQH == null) {
            multChoiceQH = new MultipleChoiceQH();
        }
        return multChoiceQH;
    }

    private QuestionHandler getTrueFalseQH() {
        if (trueFalseQH == null) {
            trueFalseQH = new TrueFalseQH();
        }
        return trueFalseQH;
    }

    private QuestionHandler getCommonQH() {
        if (commonQH == null) {
            commonQH = new CommonQH();
        }
        return commonQH;
    }
}
