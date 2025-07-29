package com.vedant.config;

import com.vedant.beans.Address;
import com.vedant.beans.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        Address addr = new Address();
        addr.setStreet("Fashion Street");
        addr.setCity("Pune");
        addr.setState("Maharashtra");
        addr.setZipcode("411017");
        return addr;
    }

    @Bean
    public Employee employee() {
        Employee emp = new Employee();
        emp.setAddress(address());
        return emp;
    }
}
