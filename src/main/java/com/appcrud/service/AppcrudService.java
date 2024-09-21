package com.appcrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcrud.entity.AppcrudEntity;
import com.appcrud.model.AppcrudModel;
import com.appcrud.repo.Appcrud;

@Service
public class AppcrudService {

	@Autowired
	private Appcrud repo;
	

	
	public AppcrudEntity saveProduct(AppcrudModel model) {
		
		AppcrudEntity entity = new AppcrudEntity();
		
		entity.setProductName(model.getProductName());
		entity.setProductPrice(model.getProductPrice());
		entity.setManufAddress(model.getManufAddress());
		entity.setStoreAddress(model.getStoreAddress());
		
		return repo.save(entity);
	}
	
	public List<AppcrudEntity> saveListProduct(List<AppcrudModel> listModel){
		
		List<AppcrudEntity> listEntity = new ArrayList<>();
		
		for(AppcrudModel model : listModel) {
		AppcrudEntity entity = new AppcrudEntity();
		entity.setProductName(model.getProductName());
		entity.setProductPrice(model.getProductPrice());
		entity.setManufAddress(model.getManufAddress());
		entity.setStoreAddress(model.getStoreAddress());
		listEntity.add(entity);
		}
		return repo.saveAll(listEntity);
		
	}
	
	public Optional<AppcrudEntity> getProductById(Integer id){
		return repo.findById(id);
	}
	
	public List<AppcrudEntity> updateProduct(Integer id, AppcrudModel model){
		Optional<AppcrudEntity> getProductFromDatabase = repo.findById(id);
		
		if(getProductFromDatabase.isPresent()) {
			AppcrudEntity entity = getProductFromDatabase.get();
			
			entity.setProductName(model.getProductName());
			entity.setProductPrice(model.getProductPrice());
			entity.setManufAddress(model.getManufAddress());
			entity.setStoreAddress(model.getStoreAddress());
			
			AppcrudEntity saveUpdate = repo.save(entity);
			return List.of(saveUpdate);
		}
		return List.of();
		
	}
	
	 public boolean deleteProduct(Integer id) {
		 if(repo.existsById(id)) {
			 repo.deleteById(id);
			 return true;
		 }
		 return false;
	 }
	
	
}
