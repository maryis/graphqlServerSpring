package com.Compass.ITIService.service;

import com.Compass.ITIService.model.CompassId;
import com.Compass.ITIService.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CompassService<Course,CompassId> {


    @Autowired
    public CourseService() {

    }

    @Override
    public Course create(Course entity) {
        LocalDate date = LocalDate.parse("9999-12-31");
        Instant instant = date.atStartOfDay(ZoneId.of("Asia/Tokyo")).toInstant();
        return new Course(new CompassId("fg", "sid"), instant, "12", "wed");
    }


    @Override
    public void delete(CompassId id) {

    }

    @Override
    public List<Course> findAll() {
        List<Course> list=new ArrayList<>();
        LocalDate date = LocalDate.parse("9999-12-31");
        Instant instant = date.atStartOfDay(ZoneId.of("Asia/Tokyo")).toInstant();
        list.add(new Course(new CompassId("fg", "sid"), instant, "12", "wed"));
        return list;
    }

    @Override
    public Optional<Course> findById(CompassId id) {
        LocalDate date = LocalDate.parse("9999-12-31");
        Instant instant = date.atStartOfDay(ZoneId.of("Asia/Tokyo")).toInstant();
        return Optional.of(new Course(new CompassId("fg", "sid"), instant, "12", "wed"));
    }


    @Override
    public Course update(Course entity, CompassId id) {
        LocalDate date = LocalDate.parse("9999-12-31");
        Instant instant = date.atStartOfDay(ZoneId.of("Asia/Tokyo")).toInstant();
        return new Course(new CompassId("fg", "sid"), instant, "12", "wed");

    }

}
