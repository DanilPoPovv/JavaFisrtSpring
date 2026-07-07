package org.example.taskmanager.Repository.Interface;

import org.example.taskmanager.model.Role;
import org.example.taskmanager.model.User;

public interface RoleRepository {
    Role getById(int id) throws RuntimeException;
    Role addRole(Role role);
    void editRole(Role role);
    void deleteRole(Role role);
    void setUserRole(User user, Role role);
}
