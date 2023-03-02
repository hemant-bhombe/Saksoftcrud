package com.saksoft.crud.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saksoft.crud.app.model.SaksoftModel;

@Repository
public interface SaksoftRepo extends JpaRepository<SaksoftModel, Integer>{

}
