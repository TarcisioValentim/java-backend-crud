package com.franciscocalaca.backendcrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactRest {

	@Autowired
	private ContactDao contactDao;
	
	@GetMapping
	public List<Contact> get(){
		return this.contactDao.findAll();
	}
	
	@PostMapping
	public void post(@RequestBody Contact contact) {
		this.contactDao.save(contact);
	}
	
}
