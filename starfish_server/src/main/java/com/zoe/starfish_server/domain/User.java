package com.zoe.starfish_server.domain;

public class User {
    private Long id;

    private String name;

    private String password;

    private String role;

    private String createTime;

    private String workNumber;

    private String email;

    private String address;

    private String phone;

    private String gender;

    private String umToken;

    private String tag;

    private Integer age;

    private Integer status;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUmToken() {
        return umToken;
    }

    public void setUmToken(String umToken) {
        this.umToken = umToken;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", role=").append(role);
        sb.append(", createTime=").append(createTime);
        sb.append(", workNumber=").append(workNumber);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", gender=").append(gender);
        sb.append(", umToken=").append(umToken);
        sb.append(", tag=").append(tag);
        sb.append(", age=").append(age);
        sb.append(", status=").append(status);
        sb.append(", token=").append(token);
        sb.append("]");
        return sb.toString();
    }
}
