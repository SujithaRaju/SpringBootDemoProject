package com.example.SpringBootDemoProject.Service;

import com.example.SpringBootDemoProject.Model.Customers;
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

    public Customers postCustomers(Customers customers){
        Customers savedCustomers=customersRepository.save(customers);
        return savedCustomers;
    }

    public List<Customers> dispalyCustomerDetails(){
       List<Customers> displayAllCustomers= customersRepository.findAll();
       return displayAllCustomers;
    }

    public Customers getCustomerById(Long id){
        Customers getCustomersById=customersRepository.findByCustomerId(id);
        return getCustomersById;
    }

    public Customers updateCustomerById(Long id,Customers customers) {
        Customers getUpdatedCustomerById=customersRepository.findByCustomerId(id);
      if (customersRepository.findByCustomerId(id).getId().equals(getUpdatedCustomerById.getId())){
         getUpdatedCustomerById.setId(customers.getId());
         getUpdatedCustomerById.setFirstName(customers.getFirstName());
         getUpdatedCustomerById.setLastName(customers.getLastName());
         getUpdatedCustomerById.setBranch(customers.getBranch());
         Customers updatedCustomers=customersRepository.save(getUpdatedCustomerById);
         return updatedCustomers;
      }else{
         return getUpdatedCustomerById;
      }
    }

    public String deleteCusterById(Long id){
        Customers customers=customersRepository.findByCustomerId(id);
        if(customers!=null) {
            customersRepository.delete(customers);
            return "Customer deleted successfully";
        }
        return "Customer not found! Failed to delete.";
    }
}
