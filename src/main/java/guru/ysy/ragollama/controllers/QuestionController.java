package guru.ysy.ragollama.controllers;

import guru.ysy.ragollama.models.Answer;
import guru.ysy.ragollama.models.Question;
import guru.ysy.ragollama.services.OllamaAIService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Fred R. Zhen
 * @Date: 2024/5/14 21:32
 * @Email: fred.zhen@gmail.com
 */
@RequiredArgsConstructor
@RestController
@Tag(name = "Question Controller", description = "Endpoint for asking questions to Ollama AI for RAG.")
public class QuestionController {

    private final OllamaAIService ollamaAIService;

    @PostMapping("/ask")
    public Answer question(Question question) {
        return ollamaAIService.getAnswer(question);
    }

}
