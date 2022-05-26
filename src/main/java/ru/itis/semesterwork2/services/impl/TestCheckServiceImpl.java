package ru.itis.semesterwork2.services.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork2.dto.request.CheburashkaTestForm;
import ru.itis.semesterwork2.dto.request.EntryTestForm;
import ru.itis.semesterwork2.models.Point;
import ru.itis.semesterwork2.models.Student;
import ru.itis.semesterwork2.models.Test;
import ru.itis.semesterwork2.models.User;
import ru.itis.semesterwork2.repositories.PointsRepository;
import ru.itis.semesterwork2.repositories.StudentsRepository;
import ru.itis.semesterwork2.repositories.TestsRepository;
import ru.itis.semesterwork2.services.TestCheckService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TestCheckServiceImpl implements TestCheckService {

    private static final Logger log = LoggerFactory.getLogger(TestCheckServiceImpl.class);

    private final String RESULT = "Ваш результат: ";

    private final String ENTRY_TEST_NAME = "Входной";
    private final String CHEBURASHKA_TEST_NAME = "Чебурашка";

    @Value("${entry_test_q1}")
    private String entryTestQ1;
    @Value("${entry_test_q2}")
    private String entryTestQ2;
    @Value("${entry_test_q3}")
    private String entryTestQ3;
    @Value("${entry_test_q4}")
    private String entryTestQ4;
    @Value("${entry_test_q5}")
    private String entryTestQ5;

    @Value("${cheb_test_q1}")
    private String chebTestQ1;
    @Value("${cheb_test_q2}")
    private String chebTestQ2;
    @Value("${cheb_test_q3}")
    private String chebTestQ3;
    @Value("${cheb_test_q4}")
    private String chebTestQ4;
    @Value("${cheb_test_q5}")
    private String chebTestQ5;

    private final TestsRepository testsRepository;
    private final StudentsRepository studentsRepository;
    private final PointsRepository pointsRepository;

    @Override
    public String checkEntryTest(EntryTestForm form, User user) {
        log.trace("Method checkEntryTest started");
        Test test = testsRepository.findByName(ENTRY_TEST_NAME);
        int result = getEntryTestResult(form);
        log.debug("Got result");
        if(user.getRole().equals(User.Role.STUDENT)){
            Student student = studentsRepository.getByUserId(user.getId());
            log.debug("Got student "+user.getEmail() );
            Optional<Point> pointOptional = pointsRepository.findByStudentAndTest(student.getId(),test.getId());
            Point point;
            if(pointOptional.isPresent()){
                point = pointOptional.get();
                point.setScores(result);
            }else{
                point = Point.builder()
                        .student(student)
                        .test(test)
                        .scores(result)
                        .build();
            }
            pointsRepository.save(point);
            log.debug("Updated database with point");
        }
        log.trace("Method checkEntryTest finished without mistakes");
        return RESULT + result + " из "+ test.getMaxScore();
    }

    @Override
    public String checkCheburashkaTest(CheburashkaTestForm form, User user) {
        log.trace("Method checkCheburashkaTest started");
        Test test = testsRepository.findByName(CHEBURASHKA_TEST_NAME);
        int result = getCheburashkaTestResult(form);
        log.debug("Got result");
        if(user.getRole().equals(User.Role.STUDENT)){
            Student student = studentsRepository.getByUserId(user.getId());
            log.debug("Got student "+user.getEmail() );
            Optional<Point> pointOptional = pointsRepository.findByStudentAndTest(student.getId(),test.getId());
            Point point;
            if(pointOptional.isPresent()){
                point = pointOptional.get();
                point.setScores(result);
            }else{
                point = Point.builder()
                        .student(student)
                        .test(test)
                        .scores(result)
                        .build();
            }
            pointsRepository.save(point);
            log.debug("Updated database with point");
        }
        log.trace("Method checkCheburashkaTest finished without mistakes");
        return RESULT + result + " из "+ test.getMaxScore();
    }

    private int getEntryTestResult(EntryTestForm form){
        int result = 0;
        if((form.getQ1()!=null)&&(form.getQ1().equals(entryTestQ1))){
            result++;
        }
        if((form.getQ2()!=null)&&(form.getQ2().equals(entryTestQ2))){
            result++;
        }
        if((form.getQ3()!=null)&&(form.getQ3().equals(entryTestQ3))){
            result++;
        }
        if((form.getQ4()!=null)&&(form.getQ4().equals(entryTestQ4))){
            result++;
        }
        if((form.getQ5()!=null)&&(form.getQ5().equals(entryTestQ5))){
            result++;
        }
        return result;
    }

    private int getCheburashkaTestResult(CheburashkaTestForm form){
        int result = 0;
        if((form.getQ1()!=null)&&(form.getQ1().equals(chebTestQ1))){
            result++;
        }
        if((form.getQ2()!=null)&&(form.getQ2().equals(chebTestQ2))){
            result++;
        }
        if((form.getQ3()!=null)&&(form.getQ3().equals(chebTestQ3))){
            result++;
        }
        if((form.getQ4()!=null)&&(form.getQ4().equals(chebTestQ4))){
            result++;
        }
        if((form.getQ5()!=null)&&(form.getQ5().equals(chebTestQ5))){
            result++;
        }
        return result;
    }
}
