package GHAI.ai;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Question text cannot be blank")
    private String text;

    @NotBlank(message = "Question type cannot be blank")
    private String type; // TEXT, MULTIPLE_CHOICE

    @NotBlank(message = "Survey type cannot be blank")
    private String surveyType;

    @ElementCollection
    private List<String> options;

    @NotBlank(message = "Category cannot be blank")
    private String category; // GBS, Asthma, TB, Pneumonia, COVID-19, etc.

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getSurveyType() { return surveyType; }
    public void setSurveyType(String surveyType) { this.surveyType = surveyType; }
    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
