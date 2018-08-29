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
@Table(name = "rewards")
public class Rewards implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 50)
    @Column(name = "type_name")
    private String typeName;

    @NotNull
    @Column(name = "sharing_level")
    private Integer sharingLevel;

    @Column(name = "carrot")
    private Integer carrot;

    /**
     * open,close
     */
    @Size(max = 10)
    @Column(name = "status", columnDefinition = "enum('OPEN','CLOSE')")
    private String status;

    @Column(name = "reward_type_name")
    private String rewardTypeName;

    @Size(max = 25)
    private String type;

    @Size(max = 25)
    private String event;

    @Size(max = 25)
    @Column(name = "status_close_reason")
    private String statusCloseReason;

    @Column(name = "max_claim")
    private Integer maxClaim;

    @Column(name = "expired_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expiredDate;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSharingLevel() {
        return sharingLevel;
    }

    public void setSharingLevel(Integer sharingLevel) {
        this.sharingLevel = sharingLevel;
    }

    public Integer getCarrot() {
        return carrot;
    }

    public void setCarrot(Integer carrot) {
        this.carrot = carrot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRewardTypeName() {
        return rewardTypeName;
    }

    public void setRewardTypeName(String rewardTypeName) {
        this.rewardTypeName = rewardTypeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStatusCloseReason() {
        return statusCloseReason;
    }

    public void setStatusCloseReason(String statusCloseReason) {
        this.statusCloseReason = statusCloseReason;
    }

    public Integer getMaxClaim() {
        return maxClaim;
    }

    public void setMaxClaim(Integer maxClaim) {
        this.maxClaim = maxClaim;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
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
