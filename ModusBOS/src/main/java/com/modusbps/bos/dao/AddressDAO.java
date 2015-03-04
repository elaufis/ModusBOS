package com.modusbps.bos.dao;

import java.util.List;

import com.modusbps.bos.entity.Address;

public interface AddressDAO {
	public List<Address> getAllAddressesForCustomer(int customerId);
	
	public void addCustomerAddress(Address address);

}
