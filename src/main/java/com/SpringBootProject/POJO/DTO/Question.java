package com.SpringBootProject.POJO.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.NoArgsConstructor;

@Data
//@Getter
//@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class Question
{
    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
