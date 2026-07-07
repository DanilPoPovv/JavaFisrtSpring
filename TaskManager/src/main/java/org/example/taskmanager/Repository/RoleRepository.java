package org.example.taskmanager.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.taskmanager.model.Role;
import org.example.taskmanager.model.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Transactional
public class RoleRepository implements org.example.taskmanager.Repository.Interface.RoleRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Role getById(int id) throws RuntimeException{
        var role = entityManager.find(Role.class, id);
        if(role == null){
            throw new RuntimeException("role not found");
        }
        return role;
    }

    @Override
    public Role addRole(Role role) {
        boolean exists = !entityManager.createQuery("""
    FROM Role r 
    WHERE r.name = :name
""", Role.class)
                .setParameter("name", role.getName())
                .getResultList()
                .isEmpty();
        if(exists){
            throw new RuntimeException("Role already exists");
        }
        entityManager.persist(role);
        return role;
    }

    @Override
    public void editRole(Role role) {}

    @Override
    public void deleteRole(Role role) {
        entityManager.remove(role);
    }

    @Override
    public void setUserRole(User user, Role role) {
        user.setRoles(Set.of(role));
    }
}
