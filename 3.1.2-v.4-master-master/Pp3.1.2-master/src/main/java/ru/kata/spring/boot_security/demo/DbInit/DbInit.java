package ru.kata.spring.boot_security.demo.DbInit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.roleService.RoleService;

import java.util.HashSet;

@Component
public class DbInit implements InitializingBean {
    private final UserService userService;
    private final RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        HashSet <Role> roles = new HashSet<>();
        Role role = roleService.getRoleById(1);
        roles.add(role);
        try {
            userService.save(new User("Alexander", "Kondratyev", "info@ivawood.com", "admin"), roles);
        } catch (Exception e) {
            System.err.println("При попытке заполнить базу данных возникла ошибка!");
        }
    }
}





