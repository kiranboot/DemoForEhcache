package com.example.kiran.address;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {

	public List<Address> findByBusinessId(String id);

}
