package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {

    Role getRoleById(long id);
    List<Role> getAllRoles();
    Role getRoleByName(String name);
    Set<Role> findRoles(List<Long> roles);


}
