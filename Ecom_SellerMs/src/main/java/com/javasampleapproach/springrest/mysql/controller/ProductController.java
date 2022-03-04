package com.javasampleapproach.springrest.mysql.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javasampleapproach.springrest.mysql.model.Product;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

public static final String getall="http://localhost:9596/product/getproduct";
public static final String create="http://localhost:9596/product/create";
public static final String putProd="http://localhost:9596/product/updateProduct/";
public static final String deleteProd="http://localhost:9596/product/delete/";



RestTemplate restTemplate=new RestTemplate();
@GetMapping("/get")
//http://localhost:8916/product/get

public List<Product> getAllProducts() {

HttpHeaders headers = new HttpHeaders();
headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
HttpEntity<String> entity = new HttpEntity<String>(headers);
ResponseEntity<List<Product>> response = restTemplate.exchange(
getall, HttpMethod.GET,entity,
new ParameterizedTypeReference<List<Product>>() {});

return response.getBody();
	
}

@PostMapping(value = "/create")
public Product postProduc(@RequestBody Product product) {

System.out.println("create");
Product createdUser = restTemplate.postForObject(create, product, Product.class);
return createdUser;
}

@DeleteMapping(value="/delete/{id}")
public String deleteProduct(@PathVariable("id") String id) {
	RestTemplate restTemplate= new RestTemplate();
	
	HttpHeaders headers= new HttpHeaders();
	HttpEntity<Product> entity= new HttpEntity<Product>(headers);
	
	ResponseEntity<String> rcustomer=restTemplate.exchange(deleteProd + id,HttpMethod.DELETE,entity, String.class);
	return id;
	
}

@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
public String updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
	product.setpId(id);
	
   HttpHeaders headers = new HttpHeaders();
   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
   HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
   
   System.out.println();
   return restTemplate.exchange(putProd +id, HttpMethod.PUT, entity, String.class).getBody();
}

@PostMapping("/createProduct")
public String postCheck(@RequestBody Product product)
{
    RestTemplate restTemplate = new RestTemplate();
     
    URI uri =  null;
	try {
		uri = new URI(create);
	} catch (URISyntaxException e) {
		e.printStackTrace();
	}
    ResponseEntity<Product> result = restTemplate.postForEntity(uri, product, Product.class);
    return "Status Code: "+result.getStatusCodeValue()+ result;
}


}