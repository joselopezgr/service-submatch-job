package com.jlg.submatch.service.user.customRepository;

import com.jlg.submatch.service.user.model.JobEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


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

}
