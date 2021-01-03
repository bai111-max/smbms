package com.smbms.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "smbms_provider", schema = "smbms", catalog = "")
public class SmbmsProvider {
    private long id;
    private String proCode;
    private String proName;
    private String proDesc;
    private String proContact;
    private String proPhone;
    private String proAddress;
    private String proFax;
    private Long createdBy;
    private Timestamp creationDate;
    private Timestamp modifyDate;
    private Long modifyBy;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "proCode", nullable = true, length = 20)
    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    @Basic
    @Column(name = "proName", nullable = true, length = 20)
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Basic
    @Column(name = "proDesc", nullable = true, length = 50)
    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    @Basic
    @Column(name = "proContact", nullable = true, length = 20)
    public String getProContact() {
        return proContact;
    }

    public void setProContact(String proContact) {
        this.proContact = proContact;
    }

    @Basic
    @Column(name = "proPhone", nullable = true, length = 20)
    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    @Basic
    @Column(name = "proAddress", nullable = true, length = 50)
    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    @Basic
    @Column(name = "proFax", nullable = true, length = 20)
    public String getProFax() {
        return proFax;
    }

    public void setProFax(String proFax) {
        this.proFax = proFax;
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
    @Column(name = "modifyDate", nullable = true)
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "modifyBy", nullable = true)
    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmbmsProvider that = (SmbmsProvider) o;
        return id == that.id &&
                Objects.equals(proCode, that.proCode) &&
                Objects.equals(proName, that.proName) &&
                Objects.equals(proDesc, that.proDesc) &&
                Objects.equals(proContact, that.proContact) &&
                Objects.equals(proPhone, that.proPhone) &&
                Objects.equals(proAddress, that.proAddress) &&
                Objects.equals(proFax, that.proFax) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyBy, that.modifyBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy);
    }
}
