package com.appcrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcrud.entity.AppcrudEntity;
import com.appcrud.model.AppcrudModel;
import com.appcrud.service.AppcrudService;

@RestController
@RequestMapping("api/product")
public class AppcrudController {

	@Autowired
	private AppcrudService service;
	
	@PostMapping("/save/product")
	public String saveProduct(@RequestBody AppcrudModel model) {
		service.saveProduct(model);
		return "save product succussfully";
	}
	
	
//	@PostMapping("/save/list")
	public List<AppcrudEntity>  saveListProduct(List<AppcrudModel> listModel){ 
		return service.saveListProduct(listModel);
	}
	
	//save list with message
	 @PostMapping("/save/list")
	    public Map<String, Object> saveListsProduct(@RequestBody List<AppcrudModel> modelList) {
	        List<AppcrudEntity> savedList = service.saveListProduct(modelList);
	        
	        Map<String, Object> listResponse = new HashMap<>();
	        
	        listResponse.put("message", "Product list save successfully!");
	        listResponse.put("savelist", savedList);
	        
	        return listResponse;
	    }
	 
	 @GetMapping("/product/{id}")
	 public Optional<AppcrudEntity> getProductById(@PathVariable Integer id) {
		 
		 Optional<AppcrudEntity> getById = service.getProductById(id);
		 
		 if(getById.isPresent()) {
			 return service.getProductById(id);
		 }
		 return null;
	 }
	 
	 @PutMapping("/update/{id}")
	 public List<AppcrudEntity> updateProduct(@PathVariable Integer id, @RequestBody AppcrudModel model ) {
		 return service.updateProduct(id , model);
	 }
	 
	 
	 @DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		boolean isDelete = service.deleteProduct(id);
		
		if(isDelete) {
			return "product with ID " + id + "Delete successfully";
		}else {
			return "product with ID " + id + "Not found";
		}
	}
	
}
