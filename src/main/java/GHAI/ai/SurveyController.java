package GHAI.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    // Fetch general questions
    @GetMapping("/questions/general")
    public List<Question> getGeneralQuestions() {
        return surveyService.getGeneralQuestions();
    }

    // Fetch follow-up questions based on previous answers
    @PostMapping("/questions/followup")
    public List<Question> getFollowUpQuestions(@RequestBody List<Response> responses) {
        return surveyService.getFollowUpQuestions(responses);
    }

    // Submit responses and get the probable diagnosis
    @PostMapping("/submit")
    public String submitSurvey(@RequestBody List<Response> responses) {
        return surveyService.analyzeResponses(responses);
    }

    // Get all questions
    @GetMapping("/questions/all")
    public List<Question> getAllQuestions() {
        return surveyService.getAllQuestions();
    }

    // Get questions by survey type
    @GetMapping("/questions")
    public List<Question> getQuestionsBySurveyType(@RequestParam String surveyType) {
        return surveyService.getQuestionsBySurveyType(surveyType);
    }

    // Get questions by category
    @GetMapping("/questions/category")
    public List<Question> getQuestionsByCategory(@RequestParam String category) {
        return surveyService.getQuestionsByCategory(category);
    }
}