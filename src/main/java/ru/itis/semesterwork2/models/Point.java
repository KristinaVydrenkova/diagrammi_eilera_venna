package ru.itis.semesterwork2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;

    private int scores;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
