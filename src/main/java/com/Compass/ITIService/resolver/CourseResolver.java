package com.Compass.ITIService.resolver;

import com.Compass.ITIService.model.CompassId;
import com.Compass.ITIService.model.Course;
import com.Compass.ITIService.service.CourseService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

public class CourseResolver {

    private CourseResolver() {
    }

    @Component
    public static class Query implements GraphQLQueryResolver {

        private final CourseService courseService;

        @Autowired
        public Query(CourseService courseService) {
            this.courseService = courseService;
        }

        public List<Course> courses(int page, int size) {
            return courseService.findAll();
        }

        public Optional<Course> course(CompassId id) {
            return courseService.findById(id);
        }

//        public Page<Course> courseHistory(CompassId id, int page, int size) {
//            return courseService.history(id, PageRequest.of(page, size));
//        }
    }

    @Component
    public static class Mutation implements GraphQLMutationResolver {

        private final CourseService courseService;

        @Autowired
        public Mutation(CourseService courseService) {
            this.courseService = courseService;
        }

        public Course createCourse(Course course) {
            return courseService.create(course);
        }

        public Course updateCourse(Course course) {
            return courseService.update(course, course.getId());
        }
    }
}
