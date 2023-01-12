package com.example.SpringBootDemoProject.Controller;
import com.example.SpringBootDemoProject.Model.Products;
import com.example.SpringBootDemoProject.Service.CustomersService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin(origins = "http://localhost:53827")
public class CustomerController {

    @Autowired
    CustomersService customersService;

    @PostMapping(path = "/products")
    public ResponseEntity<String> createCustomers(@RequestBody Products customers) throws JSONException {
        JSONObject response = new JSONObject();
      response.put("Created Succesfully",customersService.postCustomers(customers));
      return new ResponseEntity(response.toString(), HttpStatus.CREATED);
    }


    @GetMapping(path = "/products")
    public ResponseEntity getCustomerDetails(){
       return new ResponseEntity(customersService.dispalyCustomerDetails(),HttpStatus.FOUND);
    }

    @GetMapping(path="/getProducts/{id}")
    public ResponseEntity getCustomerById(@PathVariable(value="id") Long id){
      return new ResponseEntity(customersService.getCustomerById(id),HttpStatus.OK );
    }

    @PutMapping(path="/updateProducts/{id}")
    public ResponseEntity updateCustomersById(@PathVariable(value="id") Long id,@RequestBody Products customers) {
        return new ResponseEntity(customersService.updateCustomerById(id,customers),HttpStatus.OK);
    }

    @DeleteMapping(path="deleteProducts/{id}")
    public ResponseEntity<String> deleteCustomersById(@PathVariable(value = "id") Long id){
       return new ResponseEntity<>(customersService.deleteCusterById(id),HttpStatus.OK);
    }
}
