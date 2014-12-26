/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruby.sr.entities;

import com.gruby.sr.interfaces.EntityElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@ToString(of = "login")
@EqualsAndHashCode(exclude = "articles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role")})
public class User implements Serializable, EntityElement {
    
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
        
    @Column(name = "name")
    private String name;
    
    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "role")//, columnDefinition = "default 'user'")
    private String role;
    
    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Article> articles;
    
    /*
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ROLE")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Comment> commentsCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Article> articlesCollection;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    //private Collection<ArticleLike> articlesLikesCollection;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    //private Collection<CommentLike> commentsLikesCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String login, String password, String role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<Comment> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comment> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @XmlTransient
    public Collection<Article> getArticlesCollection() {
        return articlesCollection;
    }

    public void setArticlesCollection(Collection<Article> articlesCollection) {
        this.articlesCollection = articlesCollection;
    }

    @XmlTransient
    public Collection<ArticleLike> getArticlesLikesCollection() {
        return articlesLikesCollection;
    }

    public void setArticlesLikesCollection(Collection<ArticleLike> articlesLikesCollection) {
        this.articlesLikesCollection = articlesLikesCollection;
    }

    @XmlTransient
    public Collection<CommentLike> getCommentsLikesCollection() {
        return commentsLikesCollection;
    }

    public void setCommentsLikesCollection(Collection<CommentLike> commentsLikesCollection) {
        this.commentsLikesCollection = commentsLikesCollection;
    }
*/
    
}
