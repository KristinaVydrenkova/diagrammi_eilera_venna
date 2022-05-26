package ru.itis.semesterwork2.services.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork2.dto.request.AddStudentsForm;
import ru.itis.semesterwork2.dto.request.DeleteStudentsForm;
import ru.itis.semesterwork2.dto.request.AddTaskRequest;
import ru.itis.semesterwork2.dto.request.DeleteTaskRequest;
import ru.itis.semesterwork2.dto.response.PointResponse;
import ru.itis.semesterwork2.dto.response.StudentResponse;
import ru.itis.semesterwork2.dto.response.TaskForStudentResponse;
import ru.itis.semesterwork2.dto.response.TaskForTeacherResponse;
import ru.itis.semesterwork2.exceptions.*;
import ru.itis.semesterwork2.models.Student;
import ru.itis.semesterwork2.models.Task;
import ru.itis.semesterwork2.models.Teacher;
import ru.itis.semesterwork2.models.User;
import ru.itis.semesterwork2.repositories.*;
import ru.itis.semesterwork2.services.StudentsService;
import ru.itis.semesterwork2.utils.mappers.PointMapper;
import ru.itis.semesterwork2.utils.mappers.TaskMapper;

import java.util.*;

@RequiredArgsConstructor
@Service
public class StudentsServiceImpl implements StudentsService {
    private static final Logger log = LoggerFactory.getLogger(StudentsServiceImpl.class);


    private final TeachersRepository teachersRepository;
    private final StudentsRepository studentsRepository;
    private final UsersRepository usersRepository;
    private final TasksRepository tasksRepository;
    private final PointsRepository pointsRepository;

    private final TaskMapper taskMapper;
    private final PointMapper pointMapper;

    @Override
    public List<StudentResponse> getStudents(User user) {
        log.trace("Method getStudents started");
        List<StudentResponse> responses = new ArrayList<>();
        if(!user.getRole().equals(User.Role.TEACHER)){
            log.debug("Access error");
            throw new AccessException("Ошибка!");
        }
        Set<Student> students = studentsRepository.findAllByTeacherUser(user.getId());
        log.debug("Got students from teacher");
        int i = 1;
        for (Student student : students) {
            StudentResponse studentResponse = StudentResponse.builder()
                    .number(i)
                    .fio(student.getUser().getLastName()+" "+student.getUser().getFirstName()+" "+student.getUser().getPatronymic())
                    .email(student.getUser().getEmail())
                    .build();
            responses.add(studentResponse);
            i++;
        }
        log.trace("Method getStudents finished without mistakes");
        return responses;
    }

    @Override
    public List<StudentResponse> addStudents(User user, AddStudentsForm form) {
        log.trace("Method addStudents started");
        List<StudentResponse> responses = new ArrayList<>();
        Optional<Teacher> teacherOptional = teachersRepository.findByUserId(user.getId());
        if(!teacherOptional.isPresent()){
            log.debug("Teacher not found " + user.getEmail());
            throw new TeacherException("Пользователь не найден");
        }
        Teacher teacher = teacherOptional.get();
        log.debug("Got teacher " + user.getEmail());
        String[] emails = form.getEmails().split(" ");
        int i = 1;
        for (String email : emails) {
            Optional<User> studentUserOpt = usersRepository.findByEmail(email);
            if (!studentUserOpt.isPresent()) {
                log.debug("User "+email+" doesn't exist");
                throw new NoSuchEmailException("Пользователя с email " + email + " не существует");
            }
            log.debug("Found user " + email);
            Student student = studentsRepository.getByUserId(studentUserOpt.get().getId());
            log.debug("Found student " + email);
            if(student.getTeacher()==null){
                student.setTeacher(teacher);
                studentsRepository.save(student);
                log.debug("Updated database with updating student");
                StudentResponse studentResponse = StudentResponse.builder()
                        .number(i)
                        .fio(student.getUser().getLastName()+" "+student.getUser().getFirstName()+" "+student.getUser().getPatronymic())
                        .email(student.getUser().getEmail())
                        .build();
                responses.add(studentResponse);
                i++;
            }else if(!student.getTeacher().equals(teacher)){
                log.debug("Teacher is not null");
                throw new StudentException("Ученик с email " + email + " уже прикреплен к другому учителю");
            }else if(student.getTeacher().equals(teacher)){
                log.debug("Student already has been applied");
                throw new StudentException("Ученик с email " + email + " уже прикреплен к Вам");
            }
        }
        log.trace("Method addStudents finished without mistakes");
        return responses;
    }

    @Override
    public List<StudentResponse> deleteStudents(User user, DeleteStudentsForm form) {
        log.trace("Method deleteStudents started");
        Optional<Teacher> teacherOptional = teachersRepository.findByUserId(user.getId());
        if(!teacherOptional.isPresent()){
            log.debug("Teacher not found " + user.getEmail());
            throw new TeacherException("Пользователь не найден");
        }
        Teacher teacher = teacherOptional.get();
        log.debug("Got teacher " + user.getEmail());
        for(String email:form.getDeleteStudents()){
            Optional<User> studentUserOpt = usersRepository.findByEmail(email);
            if (!studentUserOpt.isPresent()) {
                log.debug("User " + email+ " doesn't exist");
                throw new NoSuchEmailException("Пользователя с email " + email + " не существует");
            }
            Student student = studentsRepository.getByUserId(studentUserOpt.get().getId());
            log.debug("Got student " + email);
            if(!student.getTeacher().equals(teacher)){
                log.debug("The student is not applied to teacher");
                throw new StudentException("Ученик с email " + email + " не был прикреплен к Вам");
            }
            student.setTeacher(null);
            studentsRepository.save(student);
            log.debug("Updated database with updating student");
        }
        log.trace("Method deleteStudents finished without mistakes");
        return getStudents(user);
    }

    @Override
    public Set<TaskForTeacherResponse> getTeacherTasks(User user) {
        log.trace("Method getTeacherTasks started");
        Optional<Teacher> teacherOptional = teachersRepository.findByUserId(user.getId());
        if(!teacherOptional.isPresent()){
            log.debug("Teacher not found " + user.getEmail());
            throw new TeacherException("Пользователь не найден");
        }
        Teacher teacher = teacherOptional.get();
        log.trace("Method getTeacherTasks finished");
        return taskMapper.toResponseSet(tasksRepository.findAllByTeacher(teacher));
    }

    @Override
    public Set<TaskForTeacherResponse> addTask(User user, AddTaskRequest addTaskRequest) {
        log.trace("Method addTask started");
        Optional<Teacher> teacherOptional = teachersRepository.findByUserId(user.getId());
        if(!teacherOptional.isPresent()){
            log.debug("Teacher not found " + user.getEmail());
            throw new TeacherException("Пользователь не найден");
        }
        Teacher teacher = teacherOptional.get();
        log.debug("Got teacher " + user.getEmail());
        Task task = taskMapper.toEntity(addTaskRequest);
        task.setDeadline(formatDate(addTaskRequest.getDeadline()));
        task.setTeacher(teacher);
        tasksRepository.save(task);
        log.debug("Updated database with adding task");
        for(Student student:studentsRepository.findAllByTeacher(teacher)){
            student.getTasks().add(task);
            studentsRepository.save(student);
            log.debug("Updated database with updating students");
        }
        log.trace("Method addTask finished without mistakes");
        return getTeacherTasks(user);
    }

    @Override
    public Set<TaskForTeacherResponse> deleteTask(User user, DeleteTaskRequest deleteTaskRequest) {
        log.trace("Method deleteTask started");
        Optional<Teacher> teacherOptional = teachersRepository.findByUserId(user.getId());
        if(!teacherOptional.isPresent()){
            log.debug("Teacher not found " + user.getEmail());
            throw new TeacherException("Пользователь не найден");
        }
        Teacher teacher = teacherOptional.get();
        log.debug("Got teacher " + user.getEmail());
        for(Long id: deleteTaskRequest.getDeleteTasks()) {
            Optional<Task> taskOptional = tasksRepository.findById(id);
            if(!(taskOptional.isPresent())|!(taskOptional.get().getTeacher().equals(teacher))){
                log.debug("Task error");
                throw new TaskException("Произошла ошибка. Такого задания не существует.");
            }
            for(Student student:studentsRepository.findAllByTeacher(teacher)){
                student.getTasks().remove(taskOptional.get());
                studentsRepository.save(student);
                log.debug("Updated database with updating student");
            }
            tasksRepository.delete(taskOptional.get());
            log.debug("Updated database with deleting task");
        }
        log.trace("Method deleteTask finished without mistakes");
        return getTeacherTasks(user);
    }

    @Override
    public List<TaskForStudentResponse> getStudentTasks(User user) {
        log.trace("Method getStudentTasks started");
        Student student = studentsRepository.getByUserId(user.getId());
        log.debug("Got student " + user.getEmail());
        List<TaskForStudentResponse> tasks = new ArrayList<>();
        for(Task task: student.getTasks()){
            User teacher = student.getTeacher().getUser();
            TaskForStudentResponse response = TaskForStudentResponse.builder()
                    .teacherName(teacher.getLastName()+" "+teacher.getFirstName()+" "+teacher.getPatronymic())
                    .task(task.getTask())
                    .deadline(task.getDeadline())
                    .build();
            tasks.add(response);
        }
        log.trace("Method getStudentTasks finished without mistakes");
        return tasks;
    }

    @Override
    public Set<PointResponse> getStudentPoints(User user) {
        return pointMapper.toResponseSet(pointsRepository.findAllByStudentUser(user.getId()));
    }

    private String formatDate(String date){
        String[] numbers = date.split("-");
        return numbers[2]+"."+numbers[1]+"."+numbers[0];
    }
}
