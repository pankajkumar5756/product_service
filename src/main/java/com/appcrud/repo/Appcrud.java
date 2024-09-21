package com.appcrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appcrud.entity.AppcrudEntity;

public interface Appcrud extends JpaRepository<AppcrudEntity, Integer> {

}
