package otus.spring.albot.lesson1.handler;

import otus.spring.albot.lesson1.model.ParsedLine;

/**
 * @author Dmitrii Albot
 */
public class ChoiceQH extends QuestionHandler {

    @Override
    protected void addExtraPartForQuestion(ParsedLine question, StringBuilder sb) {
        char letter = 97;
        for (String choice : question.getChoices()) {
            sb.append("\n");
            sb.append(letter++);
            sb.append(")");
            sb.append(choice);
        }
    }
}
