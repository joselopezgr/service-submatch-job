package com.jlg.submatch.service.job.customRepository;

import com.jlg.submatch.service.job.model.JobEntity;
import com.jlg.submatch.service.job.model.helpers.SearchJobQuery;
import com.jlg.submatch.service.job.model.helpers.SearchParameters;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class CustomJobRepositoryImpl implements CustomJobRepository {

    private final MongoTemplate mongoTemplate;

    public CustomJobRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public JobEntity softDelete(ObjectId id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        LocalDateTime now = LocalDateTime.now();

        JobEntity entity = mongoTemplate.findOne(query, JobEntity.class);

        assert entity != null;
        entity.setDeletedAt(now);

        return mongoTemplate.save(entity);
    }

    public List<JobEntity> customSearch(SearchJobQuery query) {
        Query searchQuery = new Query();
        Query queryWithExists = addExists(searchQuery);
        Query queryWithFilter = buildSearchFilter(query.getParameters(), queryWithExists);
        Query completeQuery = addSearchQueryParams(query, queryWithFilter);

        return mongoTemplate.find(completeQuery, JobEntity.class).stream().toList();
    }

    private Query addSearchQueryParams(SearchJobQuery query, Query queryWithFilter) {
        String orderByWithDefault = Optional.ofNullable(query.getOrderBy()).orElse("createdAt");
        String sortOrderWithDefault = Optional.ofNullable(query.getSortOrder()).orElse("desc");
        queryWithFilter.with(Sort.by(sortOrderWithDefault.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderByWithDefault));

        int maxResultsWithLimit = Optional.ofNullable(query.getMaxResults()).orElse(100);
        Integer pageWithDefault = Optional.ofNullable(query.getPage()).orElse(0);

        queryWithFilter.limit(maxResultsWithLimit);
        queryWithFilter.skip((long) pageWithDefault * maxResultsWithLimit);

        return queryWithFilter;
    }

    private static Query buildSearchFilter(SearchParameters searchParameters, Query query) {

        Optional.ofNullable(searchParameters.getJobTitle())
                .map(data -> Criteria.where("jobTitle").is(data))
                .ifPresent(query::addCriteria);

        Optional.ofNullable(searchParameters.getOrganization())
                .map(data -> Criteria.where("organization").is(data))
                .ifPresent(query::addCriteria);

        Optional.ofNullable(searchParameters.getExperience())
                .map(data -> Criteria.where("experience").is(data))
                .ifPresent(query::addCriteria);

        Optional.ofNullable(searchParameters.getSalary())
                .map(data -> Criteria.where("salary").is(data))
                .ifPresent(query::addCriteria);

        Optional.ofNullable(searchParameters.getLocation())
                .map(data -> Criteria.where("location").is(data))
                .ifPresent(query::addCriteria);

        return query;
    }

    private static Query addExists(Query searchQuery) {
        searchQuery.addCriteria(Criteria.where("deletedAt").isNull());
        return searchQuery;
    }



}
