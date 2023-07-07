package com.amritbabu.busticketcounter.helpers;

import com.amritbabu.busticketcounter.Utils.exception.InvalidPrimaryKeyException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

public class DaoHelpers {

    public static <T> void validatePrimaryKey(JpaRepository jpaRepository, T id){
        if(!jpaRepository.existsById(id)){
            throw new InvalidPrimaryKeyException();
        }
    }

    public static <T> void validatePrimaryKey(JpaRepository jpaRepository, T id, String message){
        if(!jpaRepository.existsById(id)){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,message) ;
        }
    }

    public static <T, R,S> T validateIdAndGetItem(JpaRepository<R,S> jpaRepository, S id){
        validatePrimaryKey(jpaRepository, id);
        return (T) jpaRepository.findById(id).get();
    }

    public static <T> void validateIdAndDeleteItem(JpaRepository jpaRepository, T id){
        validatePrimaryKey(jpaRepository,id);
       jpaRepository.deleteById(id);
    }


}
