package com.smbms.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "smbms_user", schema = "smbms", catalog = "")
public class SmbmsUser {
    private long id;
    private String userCode;
    private String userName;
    private String userPassword;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String phone;
    private String address;
    private Long userRole;
    private Long createdBy;
    private Timestamp creationDate;
    private Long modifyBy;
    private Timestamp modifyDate;

    /*新增文件上传*/
    private  String idPicPath;

    public String getIdPicPath() {
        return idPicPath;
    }

    public void setIdPicPath(String idPicPath) {
        this.idPicPath = idPicPath;
    }

    private String userRoleName;
    // 新增字段 角色名称
    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    private List<SmbmsAddress> addressList;

    public List<SmbmsAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<SmbmsAddress> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "SmbmsUser{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userRole=" + userRole +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", addressList=" + addressList +
                '}';
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userCode", nullable = true, length = 15)
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Basic
    @Column(name = "userName", nullable = true, length = 15)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userPassword", nullable = true, length = 15)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 30)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "userRole", nullable = true)
    public Long getUserRole() {
        return userRole;
    }

    public void setUserRole(Long userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "createdBy", nullable = true)
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "creationDate", nullable = true)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "modifyBy", nullable = true)
    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Basic
    @Column(name = "modifyDate", nullable = true)
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmbmsUser smbmsUser = (SmbmsUser) o;
        return id == smbmsUser.id &&
                Objects.equals(userCode, smbmsUser.userCode) &&
                Objects.equals(userName, smbmsUser.userName) &&
                Objects.equals(userPassword, smbmsUser.userPassword) &&
                Objects.equals(gender, smbmsUser.gender) &&
                Objects.equals(birthday, smbmsUser.birthday) &&
                Objects.equals(phone, smbmsUser.phone) &&
                Objects.equals(address, smbmsUser.address) &&
                Objects.equals(userRole, smbmsUser.userRole) &&
                Objects.equals(createdBy, smbmsUser.createdBy) &&
                Objects.equals(creationDate, smbmsUser.creationDate) &&
                Objects.equals(modifyBy, smbmsUser.modifyBy) &&
                Objects.equals(modifyDate, smbmsUser.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate);
    }
}
