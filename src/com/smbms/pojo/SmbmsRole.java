package com.smbms.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "smbms_role", schema = "smbms", catalog = "")
public class SmbmsRole {
    private long id;
    private String roleCode;
    private String roleName;
    private Long createdBy;
    private Timestamp creationDate;
    private Long modifyBy;
    private Timestamp modifyDate;
    /*一个类里面包含宁外一个类*/
    private SmbmsUser smbmsUser;

    @Override
    public String toString() {
        return "SmbmsRole{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", smbmsUser=" + smbmsUser +
                '}';
    }

    public SmbmsUser getSmbmsUser() {
        return smbmsUser;
    }

    public void setSmbmsUser(SmbmsUser smbmsUser) {
        this.smbmsUser = smbmsUser;
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
    @Column(name = "roleCode", nullable = true, length = 15)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "roleName", nullable = true, length = 15)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        SmbmsRole smbmsRole = (SmbmsRole) o;
        return id == smbmsRole.id &&
                Objects.equals(roleCode, smbmsRole.roleCode) &&
                Objects.equals(roleName, smbmsRole.roleName) &&
                Objects.equals(createdBy, smbmsRole.createdBy) &&
                Objects.equals(creationDate, smbmsRole.creationDate) &&
                Objects.equals(modifyBy, smbmsRole.modifyBy) &&
                Objects.equals(modifyDate, smbmsRole.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleCode, roleName, createdBy, creationDate, modifyBy, modifyDate);
    }
}
