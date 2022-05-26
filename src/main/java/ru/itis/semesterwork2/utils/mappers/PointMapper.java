package ru.itis.semesterwork2.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.semesterwork2.dto.response.PointResponse;
import ru.itis.semesterwork2.models.Point;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface PointMapper {
    @Mapping(target = "testName", source = "point.test.name")
    @Mapping(target = "maxScore", source = "point.test.maxScore")
    PointResponse toResponse(Point point);

    Set<PointResponse> toResponseSet(Set<Point> points);

}
