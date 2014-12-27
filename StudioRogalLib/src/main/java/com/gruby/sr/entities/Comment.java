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
import javax.persistence.FetchType;
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

@ToString()
@EqualsAndHashCode()
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comments")
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findById", query = "SELECT c FROM Comment c WHERE c.id = :id"),
    @NamedQuery(name = "Comment.findByContent", query = "SELECT c FROM Comment c WHERE c.content = :content"),
    @NamedQuery(name = "Comment.findByArticleId", query = "SELECT c FROM Comment c WHERE c.articleId = :articleId"),
    @NamedQuery(name = "Comment.findByUserId", query = "SELECT c FROM Comment c WHERE c.userId = :userId")
    //@NamedQuery(name = "Comment.findByNumberOfLikes", query = "SELECT c FROM Comment c WHERE c.numberOfLikes = :numberOfLikes"),
    //@NamedQuery(name = "Comment.findByNumberOfDislikes", query = "SELECT c FROM Comment c WHERE c.numberOfDislikes = :numberOfDislikes")
})
public class Comment implements Serializable, EntityElement {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "content")
    private String content;
   
   // @Column(name = "numberOfLikes", columnDefinition = "default '0'")
    //private Integer numberOfLikes;
    
    //@Column(name = "numberOfDislikes", columnDefinition = "default '0'")
    //private Integer numberOfDislikes;
    
    @JoinColumn(name = "articleId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Article articleId;
    
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "commentId")
    //private List<CommentLike> commentsLikesCollection;
/*
    public Comment() {
    }

    public Comment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumberoflikes() {
        return numberoflikes;
    }

    public void setNumberoflikes(Integer numberoflikes) {
        this.numberoflikes = numberoflikes;
    }

    public Integer getNumberofdislikes() {
        return numberofdislikes;
    }

    public void setNumberofdislikes(Integer numberofdislikes) {
        this.numberofdislikes = numberofdislikes;
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
/*
    @XmlTransient
    public Collection<CommentLike> getCommentsLikesCollection() {
        return commentsLikesCollection;
    }

    public void setCommentsLikesCollection(Collection<CommentLike> commentsLikesCollection) {
        this.commentsLikesCollection = commentsLikesCollection;
    }
*/
    
}
