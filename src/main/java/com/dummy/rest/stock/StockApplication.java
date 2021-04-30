package com.dummy.rest.stock;

import javax.annotation.PostConstruct;

import com.dummy.rest.stock.entity.Address;
import com.dummy.rest.stock.entity.User;
import com.dummy.rest.stock.repository.AddressRepository;
import com.dummy.rest.stock.repository.UserRepository;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

import static com.dummy.rest.stock.constant.Role.*;

import java.util.Optional;
@SpringBootApplication
@Slf4j
public class StockApplication {

	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private UserRepository userRepo;

	@PostConstruct	
	public void initData(){
		log.info("Accessing Post Construct!"); 
		Faker faker = new Faker();

		for(int i= 0 ; i< 10 ; i++){

			User tempUser= new User();
			tempUser.setUsername(faker.name().username()+"@gmail.com");
			tempUser.setPassword("password");
			tempUser.setFirstname(faker.name().firstName());
			tempUser.setLastname(faker.name().lastName());
			if(i%2==0){
				tempUser.setRole(ROLE_USER.name());
				tempUser.setAuthorities(ROLE_USER.getAuthorities());
			}else{
				tempUser.setRole(ROLE_ADMIN.name());
				tempUser.setAuthorities(ROLE_ADMIN.getAuthorities());
			}

			tempUser.setActive(true);
			tempUser.setNotLocked(true);
			
			Address address = new Address();
			address.setStreet(faker.address().streetName());
			address.setSuite(faker.address().streetAddressNumber());
			address.setCity(faker.address().city());
			address.setState(faker.address().state());
			address.setZipcode(faker.address().zipCode());
		
			tempUser.setAddress(address);
		
			log.info(tempUser.getUsername()); 
			this.userRepo.save(tempUser);
		}


		// set new aadress for user
		User userForupdate = new User();
		userForupdate.setUsername("quy@gmail.com");
		userForupdate.setPassword("password");
		userForupdate.setFirstname(faker.name().firstName());
		userForupdate.setLastname(faker.name().lastName());
		userForupdate.setRole(ROLE_ADMIN.name());
		userForupdate.setAuthorities(ROLE_ADMIN.getAuthorities());
		userForupdate.setActive(true);
		userForupdate.setNotLocked(true);
		Address address = new Address();
		address.setStreet(faker.address().streetName());
		address.setSuite(faker.address().streetAddressNumber());
		address.setCity(faker.address().city());
		address.setState(faker.address().state());
		address.setZipcode(faker.address().zipCode());
		userForupdate.setAddress(address);

		this.userRepo.save(userForupdate);

		// UPDATE
		// find user
		// create new address // SET THE USER ADDRESS ID TO NEW ADDRESS ID
		// add new address to that user
		// save(newuserInfo)		
		
		// ! NEW Update
		Optional<User> userFounded = this.userRepo.findByUsername("quy@gmail.com");

		
		if(userFounded.isPresent()){
			// Found
			// UPDATE
			User user = userFounded.get();

			Address newAddress = new Address();
			newAddress.setId(user.getAddress().getId());
			address.setStreet(faker.address().streetName());
			address.setSuite(faker.address().streetAddressNumber());
			newAddress.setCity("new new  city");
			address.setState(faker.address().state());
			address.setZipcode(faker.address().zipCode());

			user.setAddress(newAddress);
			this.userRepo.save(user);
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

}


