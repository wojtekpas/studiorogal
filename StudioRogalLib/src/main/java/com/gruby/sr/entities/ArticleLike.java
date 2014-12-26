/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruby.sr.entities;

import com.gruby.sr.interfaces.EntityElement;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ja
 */

public class ArticleLike{
    
}
/*
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "ARTICLES_LIKES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticleLike.findAll", query = "SELECT a FROM Articles_Likes a"),
    @NamedQuery(name = "ArticleLike.findById", query = "SELECT a FROM Articles_Likes a WHERE a.id = :id"),
    @NamedQuery(name = "ArticleLike.findByValue", query = "SELECT a FROM Articles_Likes a WHERE a.value = :value")})
public class ArticleLike implements Serializable, EntityElement {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VALUE")
    private Integer value;
    @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Article articleId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userId;

    public ArticleLike() {
    }

    public ArticleLike(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleLike)) {
            return false;
        }
        ArticleLike other = (ArticleLike) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gruby.sr.entities.ArticlesLikes[ id=" + id + " ]";
    }
    
}
*/