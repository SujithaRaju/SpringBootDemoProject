package com.example.SpringBootDemoProject.Service;
import com.example.SpringBootDemoProject.Model.Products;
import com.example.SpringBootDemoProject.Repository.CustomersRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    @Autowired
    CustomersRepository customersRepository;

    public Products postCustomers(Products customers){
        Products savedCustomers=customersRepository.save(customers);
        return savedCustomers;
    }

    public List<Products> dispalyCustomerDetails(){
       List<Products> displayAllCustomers= customersRepository.findAll();
       return displayAllCustomers;
    }

    public Products getCustomerById(Long id){
        Products getCustomersById=customersRepository.findByCustomerId(id);
        return getCustomersById;
    }

    public Products updateCustomerById(Long id,Products customers) {
        Products getUpdatedCustomerById=customersRepository.findByCustomerId(id);
      if (customersRepository.findByCustomerId(id).getId().equals(getUpdatedCustomerById.getId())){
         getUpdatedCustomerById.setId(customers.getId());
         getUpdatedCustomerById.setProductName(customers.getProductName());
         getUpdatedCustomerById.setProductCode(customers.getProductCode());
         getUpdatedCustomerById.setReleaseDate(customers.getReleaseDate());
          getUpdatedCustomerById.setDescription(customers.getDescription());
          getUpdatedCustomerById.setPrice(customers.getPrice());
          getUpdatedCustomerById.setImageUrl(customers.getImageUrl());
          getUpdatedCustomerById.setStarRating(customers.getStarRating());
         Products updatedCustomers=customersRepository.save(getUpdatedCustomerById);
         return updatedCustomers;
      }else{
         return getUpdatedCustomerById;
      }
    }

    public String deleteCusterById(Long id){
        Products customers=customersRepository.findByCustomerId(id);
        if(customers!=null) {
            customersRepository.delete(customers);
            return "Customer deleted successfully";
        }
        return "Customer not found! Failed to delete.";
    }
}
