package com.vipsfoodcourt.order.service;


import com.vipsfoodcourt.order.entity.Sequence;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@AllArgsConstructor
public class SequenceGenerator {

    MongoOperations mongoOperations;


    public int generateNextOrderId() {

     /*   Sequence counter = mongoOperations.findAndModify(query(where("_id").is("sequence")),
                new Update().inc("sequence",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
*/

        Sequence counter = mongoOperations.findAndModify(
                query(where("_id").is("sequence")),
                new Update().inc("sequence", 1),
                options().returnNew(true).upsert(true),
                Sequence.class);


        return !Objects.isNull(counter)? counter.getSequence():1;


    }

}
