package com.smbms.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "smbms_bill", schema = "smbms", catalog = "")
public class SmbmsBill {
    private long id;
    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private BigDecimal productCount;
    private BigDecimal totalPrice;
    private Integer isPayment;
    private Long createdBy;
    private Timestamp creationDate;
    private Long modifyBy;
    private Timestamp modifyDate;
    private Long providerId;
    private String providerName;

    @Override
    public String toString() {
        return "SmbmsBill{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productCount=" + productCount +
                ", totalPrice=" + totalPrice +
                ", isPayment=" + isPayment +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", providerId=" + providerId +
                ", providerName='" + providerName + '\'' +
                '}';
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
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
    @Column(name = "billCode", nullable = true, length = 20)
    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    @Basic
    @Column(name = "productName", nullable = true, length = 20)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "productDesc", nullable = true, length = 50)
    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Basic
    @Column(name = "productUnit", nullable = true, length = 10)
    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    @Basic
    @Column(name = "productCount", nullable = true, precision = 2)
    public BigDecimal getProductCount() {
        return productCount;
    }

    public void setProductCount(BigDecimal productCount) {
        this.productCount = productCount;
    }

    @Basic
    @Column(name = "totalPrice", nullable = true, precision = 2)
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "isPayment", nullable = true)
    public Integer getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Integer isPayment) {
        this.isPayment = isPayment;
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
    @Column(name = "providerId", nullable = true)
    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmbmsBill smbmsBill = (SmbmsBill) o;
        return id == smbmsBill.id &&
                Objects.equals(billCode, smbmsBill.billCode) &&
                Objects.equals(productName, smbmsBill.productName) &&
                Objects.equals(productDesc, smbmsBill.productDesc) &&
                Objects.equals(productUnit, smbmsBill.productUnit) &&
                Objects.equals(productCount, smbmsBill.productCount) &&
                Objects.equals(totalPrice, smbmsBill.totalPrice) &&
                Objects.equals(isPayment, smbmsBill.isPayment) &&
                Objects.equals(createdBy, smbmsBill.createdBy) &&
                Objects.equals(creationDate, smbmsBill.creationDate) &&
                Objects.equals(modifyBy, smbmsBill.modifyBy) &&
                Objects.equals(modifyDate, smbmsBill.modifyDate) &&
                Objects.equals(providerId, smbmsBill.providerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId);
    }
}
