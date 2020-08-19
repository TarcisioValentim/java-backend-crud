package com.franciscocalaca.backendcrud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact, Long>{

}
