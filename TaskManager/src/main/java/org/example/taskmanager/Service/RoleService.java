package org.example.taskmanager.Service;

import org.example.taskmanager.Repository.Interface.RoleRepository;
import org.example.taskmanager.Repository.UserRepository;
import org.example.taskmanager.model.Role;
import org.example.taskmanager.model.User;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public Role getById(Integer id){
        return roleRepository.getById(id);
    }
    public Role addRole(String roleName){
        return roleRepository.addRole(new Role(roleName));
    }
    public void editRole(Integer roleId, String newRoleName){
        var role = roleRepository.getById(roleId);
        role.setName(newRoleName);
        roleRepository.editRole(role);
    }
    public void deleteRole(int roleId){
        var role = roleRepository.getById(roleId);
        roleRepository.deleteRole(role);
    }
    public void setUserRole(int userId, int roleId){
        var role = roleRepository.getById(roleId);
        var user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        roleRepository.setUserRole(user, role);
    }
}
