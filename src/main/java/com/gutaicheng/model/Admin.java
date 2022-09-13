package com.gutaicheng.model;

/**
 * 管理员实体类：admin
 * id : id
 * username : 用户名
 * password : 密码
 * permissions : 权限级别
 */
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private Integer permissions;

    public Admin(Integer id, String username, String password, Integer permissions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
