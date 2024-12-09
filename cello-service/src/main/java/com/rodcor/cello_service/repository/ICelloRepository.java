package com.rodcor.cello_service.repository;

import com.rodcor.cello_service.model.Cello;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICelloRepository extends MongoRepository<Cello,String> {

}
