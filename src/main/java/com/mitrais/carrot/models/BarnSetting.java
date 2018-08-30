package com.mitrais.carrot.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

/**
 *
 * @author rudy@mitrais.com
 */
@Entity
@Table(name = "barn_setting")
public class BarnSetting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "role_name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    private Integer carrot;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @Column(name = "is_released")
    private Integer isReleased;

    @OneToOne
    private Barn barn;

    @OneToOne
    private Rewards rewards;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCarrot() {
        return carrot;
    }

    public void setCarrot(Integer carrot) {
        this.carrot = carrot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(Integer isReleased) {
        this.isReleased = isReleased;
    }

    public Barn getBarn() {
        return barn;
    }

    public void setBarn(Barn barn) {
        this.barn = barn;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
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
