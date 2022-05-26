package ru.itis.semesterwork2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntryTestForm {
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
}
