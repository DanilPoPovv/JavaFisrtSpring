package org.example.taskmanager.controller;

import org.example.taskmanager.Service.RoleService;
import org.example.taskmanager.model.Role;
import org.example.taskmanager.request.CreateRoleRequest;
import org.example.taskmanager.request.EditRoleRequest;
import org.example.taskmanager.request.SetRoleRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("role")
    public Role addRole(@RequestBody CreateRoleRequest createRoleRequest) {
        return roleService.addRole(createRoleRequest.getRoleName());
    }
    @GetMapping("role/{roleId}")
    public Role getById(@PathVariable Integer roleId) {
        return roleService.getById(roleId);
    }
    @PutMapping("/role/{roleId}")
    public void editRole(@PathVariable Integer roleId, @RequestBody EditRoleRequest editRoleRequest){
        roleService.editRole(roleId, editRoleRequest.getRoleName());
    }
    @DeleteMapping("role/{roleId}")
    public void deleteRole(@PathVariable int roleId){

        roleService.deleteRole(roleId);
    }
    @PostMapping("role/setRole")
    public void setRole(@RequestBody SetRoleRequest setRoleRequest){
        roleService.setUserRole(setRoleRequest.getUserId(),setRoleRequest.getRoleId());
    }
}
