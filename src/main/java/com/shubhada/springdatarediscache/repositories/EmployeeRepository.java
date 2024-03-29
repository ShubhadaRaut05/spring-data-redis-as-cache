package com.shubhada.springdatarediscache.repositories;

import com.shubhada.springdatarediscache.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   /* private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public EmployeeRepository(RedisTemplate redisTemplate) {
        this.hashOperations=redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }
    public void saveEmployee(Employee employee){
        hashOperations.put("EMPLOYEE",employee.getId(),employee);
    }
    public List<Employee> findAll(){
        return hashOperations.values("EMPLOYEE");
    }
    public Employee findById(int id){

        return (Employee) hashOperations.get("EMPLOYEE",id);
    }
    public void update(Employee employee){
        saveEmployee(employee);

    }
    public void delete(int id){
        hashOperations.delete("EMPLOYEE",id);

    }*/
}
