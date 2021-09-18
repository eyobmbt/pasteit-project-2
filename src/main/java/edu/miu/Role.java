package edu.miu;

public abstract class Role {
 private String roleId;

 public String getRoleId() {
  return roleId;
 }

 public Role(String roleId) {
  this.roleId = roleId;
 }
}
