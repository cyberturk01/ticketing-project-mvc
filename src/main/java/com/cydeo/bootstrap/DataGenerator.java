package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RoleService roleService;

    private final UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole= new RoleDTO(1l,"Admin");
        RoleDTO managerRole= new RoleDTO(2l,"Manager");
        RoleDTO employeeRole= new RoleDTO(3l,"Employee");
        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO userDTO1= new UserDTO("Craig","Kesy","john@yigit.org","1231241213","ABC123",true,  Gender.MALE, managerRole);
        UserDTO userDTO2= new UserDTO("Elizabeth","Kesy1","john1@yigit.org","1211241213","ABC1234",true,  Gender.FEMALE, employeeRole);
        UserDTO userDTO3= new UserDTO("John","Kesy2","john2@yigit.org","1241241213","ABC1235",true,  Gender.MALE, managerRole);
        UserDTO userDTO4= new UserDTO("Mark","Kesy3","john3@yigit.org","1251241213","ABC1236",true,  Gender.MALE, adminRole);
        UserDTO userDTO5= new UserDTO("Thomas","Kesy4","john4@yigit.org","1261241213","ABC1237",true,  Gender.FEMALE, employeeRole);
        UserDTO userDTO6= new UserDTO("David","Kesy5","john5@yigit.org","1271241213","ABC1238",true,  Gender.MALE, employeeRole);
        UserDTO userDTO7= new UserDTO("Kevin","Kesy6","john6@yigit.org","1274541213","ABC5238",true,  Gender.FEMALE, employeeRole);

        userService.save(userDTO1);
        userService.save(userDTO2);
        userService.save(userDTO3);
        userService.save(userDTO4);
        userService.save(userDTO5);
        userService.save(userDTO6);
        userService.save(userDTO7);
    }
}
