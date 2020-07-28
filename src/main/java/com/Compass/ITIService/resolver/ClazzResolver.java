package com.Compass.ITIService.resolver;


import com.Compass.ITIService.service.ClazzService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import com.Compass.ITIService.model.*;


import java.util.List;
import java.util.Optional;

public class ClazzResolver {

    private ClazzResolver() {
    }

    @Component
    public static class Query implements GraphQLQueryResolver {

        private final ClazzService clazzService;

        @Autowired
        public Query(ClazzService clazzService) {
            this.clazzService = clazzService;
        }

        public List<Clazz> clazzes(int page, int size) {
            return clazzService.findAll();
        }

        public Optional<Clazz> clazz(CompassId id) {
            return clazzService.findById(id);
        }

//        public Page<Clazz> clazzHistory(CompassId id, int page, int size) {
//            return clazzService.history(id, PageRequest.of(page, size));
//        }
    }

    @Component
    public static class Mutation implements GraphQLMutationResolver {

        private final ClazzService clazzService;

        @Autowired
        public Mutation(ClazzService clazzService) {
            this.clazzService = clazzService;
        }

        public Clazz createClazz(Clazz clazz) {
            return clazzService.create(clazz);
        }

        public Clazz updateClazz(Clazz clazz) {
            return clazzService.update(clazz, clazz.getId());
        }
    }
}
