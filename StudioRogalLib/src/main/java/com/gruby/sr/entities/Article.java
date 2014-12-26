/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruby.sr.entities;

import com.gruby.sr.interfaces.EntityElement;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ja
 */

@ToString(of = "id")
@EqualsAndHashCode(exclude = "commentsCollection")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "articles")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id = :id"),
    @NamedQuery(name = "Article.findByTitle", query = "SELECT a FROM Article a WHERE a.title = :title"),
    @NamedQuery(name = "Article.findByContent", query = "SELECT a FROM Article a WHERE a.content = :content")
    //@NamedQuery(name = "Article.findByNumberOfViews", query = "SELECT a FROM Article a WHERE a.numberOfViews = :numberOfViews")
})
public class Article implements Serializable, EntityElement {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "content")
    private String content;
    
    //@Column(name = "numberOfViews", columnDefinition = "default '0'")   
    //private Integer numberOfViews;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleId")
    private Collection<Comment> commentsCollection;
    
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "articleId")
    //private Collection<ArticleLike> articlesLikesCollection;
/*
    public Article() {
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumberofviews() {
        return numberofviews;
    }

    public void setNumberofviews(Integer numberofviews) {
        this.numberofviews = numberofviews;
    }

    @XmlTransient
    public Collection<Comment> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comment> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<ArticleLike> getArticlesLikesCollection() {
        return articlesLikesCollection;
    }

    public void setArticlesLikesCollection(Collection<ArticleLike> articlesLikesCollection) {
        this.articlesLikesCollection = articlesLikesCollection;
    }
*/
    
}
