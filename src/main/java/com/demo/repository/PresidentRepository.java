package com.demo.repository;

import com.demo.domain.President;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PresidentRepository extends JpaSpecificationExecutor<President>, JpaRepository<President, Long>, PagingAndSortingRepository<President, Long>, CrudRepository<President, Long> {
}
