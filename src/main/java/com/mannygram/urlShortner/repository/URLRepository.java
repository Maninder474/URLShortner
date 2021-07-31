package com.mannygram.urlShortner.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mannygram.urlShortner.valueObject.URLDetails;

public interface URLRepository extends CrudRepository<URLDetails,Integer>{
	
	@Query("select w from URLDetails w where w.id=:id")
	public URLDetails getURLDetails( @Param("id") String id);
	
}
