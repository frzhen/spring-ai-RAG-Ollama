package guru.ysy.ragollama.services;

import guru.ysy.ragollama.models.Answer;
import guru.ysy.ragollama.models.Question;

/**
 * @Author: Fred R. Zhen
 * @Date: 2024/5/14 21:28
 * @Email: fred.zhen@gmail.com
 */
public interface OllamaAIService {

    Answer getAnswer(Question question);
}
