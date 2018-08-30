package com.mitrais.carrot.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author rudy@mitrais.com
 */
@Entity
@Table(name = "transactions")
public class Transactions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", columnDefinition = "enum('reward','shared','bazaar')")
    private String type;

    @Column(name = "to_from")
    private String toFrom;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    private Integer carrot;

    @Column(name = "transaction_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transactionDate;

    private Integer status;

    @OneToOne
    private User user;

    @OneToOne
    private Bazaar bazaar;
    
    @OneToOne
    private Rewards rewards;

    @Column(name = "created_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedTime;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToFrom() {
        return toFrom;
    }

    public void setToFrom(String toFrom) {
        this.toFrom = toFrom;
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
        return transactionDate;
    }

    public void setDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bazaar getBazaar() {
        return bazaar;
    }

    public void setBazaar(Bazaar bazaar) {
        this.bazaar = bazaar;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy(){
        return createdBy;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getLastModifiedBy(){
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy){
        this.lastModifiedBy = lastModifiedBy;
    }

}
