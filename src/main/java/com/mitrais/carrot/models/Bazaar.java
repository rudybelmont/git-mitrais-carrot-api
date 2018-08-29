package com.mitrais.carrot.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Febri_MW251@mitrais.com
 */
@Entity
@Table(name = "bazaar")
public class Bazaar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotNull
    @Size(max = 50)
    @Column(name = "bazar_name")
    private String bazarName;

    @Column(name = "start_period")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startPeriode;

    @Column(name = "end_period")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endPeriode;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    private Integer status;

    @Column(name = "is_deleted")
    protected Integer isDeteled;

    @OneToOne
    private BazaarItem bazaarItem;

    @Column(name = "created_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date createdTime;

    @Column(name = "created_by")
    protected Integer createdBy;

    @Column(name = "last_modified_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date lastModifiedTime;

    @Column(name = "last_modified_by")
    protected Integer lastModifiedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBazarName() {
        return bazarName;
    }

    public void setBazarName(String bazarName) {
        this.bazarName = bazarName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
