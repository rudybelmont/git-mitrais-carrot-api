package com.mitrais.carrot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author rudy@mitrais.com
 */
@Entity
@Table(name = "barn")
@JsonIgnoreProperties(value = {"id", "createdTime"}, allowGetters = true)
public class Barn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "role_name")
    private String name;

    @Column(name = "start_periode")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startPeriode;

    @Column(name = "end_periode")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endPeriode;

    private String owner;

    @Column(name = "carrot_per_employee")
    private Integer carrotPerEmployee;

    @Column(name = "total_carrot")
    private Integer totalCarrot;

    private Integer status;

    @Column(name = "is_released")
    private Integer isReleased;

    @Column(name = "is_deleted")
    private Integer isDeteled;

    @Column(name = "created_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdTime;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "last_modified_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedTime;

    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartPeriode() {
        return startPeriode;
    }

    public void setStartPeriode(Date startPeriode) {
        this.startPeriode = startPeriode;
    }

    public Date getEndPeriode() {
        return endPeriode;
    }

    public void setEndPeriode(Date endPeriode) {
        this.endPeriode = endPeriode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCarrotPerEmployee() {
        return carrotPerEmployee;
    }

    public void setCarrotPerEmployee(Integer carrotPerEmployee) {
        this.carrotPerEmployee = carrotPerEmployee;
    }

    public Integer getTotalCarrot() {
        return totalCarrot;
    }

    public void setTotalCarrot(Integer totalCarrot) {
        this.totalCarrot = totalCarrot;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(Integer isReleased) {
        this.isReleased = isReleased;
    }

    public Integer getIsDeteled() {
        return isDeteled;
    }

    public void setIsDeteled(Integer isDeteled) {
        this.isDeteled = isDeteled;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

}
