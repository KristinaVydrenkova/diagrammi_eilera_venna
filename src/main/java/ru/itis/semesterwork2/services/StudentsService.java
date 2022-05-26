package ru.itis.semesterwork2.services;

import ru.itis.semesterwork2.dto.request.AddStudentsForm;
import ru.itis.semesterwork2.dto.request.AddTaskRequest;
import ru.itis.semesterwork2.dto.request.DeleteStudentsForm;
import ru.itis.semesterwork2.dto.request.DeleteTaskRequest;
import ru.itis.semesterwork2.dto.response.PointResponse;
import ru.itis.semesterwork2.dto.response.StudentResponse;
import ru.itis.semesterwork2.dto.response.TaskForStudentResponse;
import ru.itis.semesterwork2.dto.response.TaskForTeacherResponse;
import ru.itis.semesterwork2.models.User;

import java.util.List;
import java.util.Set;

public interface StudentsService {
    List<StudentResponse> getStudents(User user);

    List<StudentResponse> addStudents(User user, AddStudentsForm form);

    List<StudentResponse> deleteStudents(User user, DeleteStudentsForm form);

    Set<TaskForTeacherResponse> getTeacherTasks(User user);

    Set<TaskForTeacherResponse> addTask(User user, AddTaskRequest addTaskRequest);

    Set<TaskForTeacherResponse> deleteTask(User user, DeleteTaskRequest deleteTaskRequest);

    List<TaskForStudentResponse> getStudentTasks(User user);

    Set<PointResponse> getStudentPoints(User user);
//    List<Task> getTasks(int teacherId);
//    void addStudents(List<String> students, User user);
//    void deleteStudents(List<String> students, User user);
//    void deleteTask(List<String> tasks);
//    void addTask(Task task);
//    List<Task> getStudentTasks(int studentId);
//    void signOut(User user);
}
