package ru.itis.semesterwork2.services;

import ru.itis.semesterwork2.dto.request.CheburashkaTestForm;
import ru.itis.semesterwork2.dto.request.EntryTestForm;
import ru.itis.semesterwork2.models.Point;
import ru.itis.semesterwork2.models.User;

import java.util.List;

public interface TestCheckService {
    String checkEntryTest(EntryTestForm form, User user);

    String checkCheburashkaTest(CheburashkaTestForm form, User user);
}
