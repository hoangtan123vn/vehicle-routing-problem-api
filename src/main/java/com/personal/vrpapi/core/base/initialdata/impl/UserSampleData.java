package com.personal.vrpapi.core.base.initialdata.impl;

import com.personal.vrpapi.core.authorization.entity.Admin;
import com.personal.vrpapi.core.authorization.entity.Customer;
import com.personal.vrpapi.core.authorization.entity.Driver;
import com.personal.vrpapi.core.authorization.entity.Role;
import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.authorization.repository.AbstractUserRepository;
import com.personal.vrpapi.core.authorization.repository.RoleRepository;
import com.personal.vrpapi.core.base.entity.AbstractUser;
import com.personal.vrpapi.core.base.initialdata.SampleData;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class UserSampleData implements SampleData {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private AbstractUserRepository userRepository;

    @Override
    public void createData() {
        Role existed = roleRepository.findByRoleName(RoleEnum.ADMIN);
        if (Objects.isNull(existed)) {
            Role role = new Role();
            role.setRoleName(RoleEnum.ADMIN);

            Role role1 = new Role();
            role1.setRoleName(RoleEnum.CUSTOMER);

            Role role2 = new Role();
            role2.setRoleName(RoleEnum.DRIVER);

            Customer customer = new Customer();
            saveUser("", "customer", "customer", "Aa123456", customer, role1);

            Driver driver = new Driver();
            saveUser("", "driver", "driver", "Aa123456", driver, role2);

            Admin admin = new Admin();
            saveUser("", "admin", "admin", "Aa123456", admin, role);
        }
    }

    private void saveUser(String firstName, String lastName, String userName, String password, AbstractUser user, Role role) {
        roleRepository.save(role);
        user.setPassword(passwordEncoder.encode(password));
        user.setUserName(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        user.setIsActive(false);
        userRepository.save(user);
    }

}
