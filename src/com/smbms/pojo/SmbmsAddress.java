package com.smbms.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "smbms_address", schema = "smbms", catalog = "")
public class SmbmsAddress {
    private long id;
    private String contact;
    private String addressDesc;
    private String postCode;
    private String tel;
    private Long createdBy;
    private Timestamp creationDate;
    private Long modifyBy;
    private Timestamp modifyDate;
    private Long userId;

    @Override
    public String toString() {
        return "SmbmsAddress{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", addressDesc='" + addressDesc + '\'' +
                ", postCode='" + postCode + '\'' +
                ", tel='" + tel + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", userId=" + userId +
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
    @Column(name = "contact", nullable = true, length = 15)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "addressDesc", nullable = true, length = 50)
    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    @Basic
    @Column(name = "postCode", nullable = true, length = 15)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    @Basic
    @Column(name = "userId", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmbmsAddress that = (SmbmsAddress) o;
        return id == that.id &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(addressDesc, that.addressDesc) &&
                Objects.equals(postCode, that.postCode) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(modifyBy, that.modifyBy) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contact, addressDesc, postCode, tel, createdBy, creationDate, modifyBy, modifyDate, userId);
    }
}
