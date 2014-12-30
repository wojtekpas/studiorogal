/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruby.sr.entities;

import com.gruby.sr.interfaces.EntityElement;
import java.io.Serializable;
import java.util.List;
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
@EqualsAndHashCode(exclude = {"commentsList", "articleLikesList"})
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
})
public class Article implements Serializable, EntityElement {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id = 0;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "content")
    private String content;
    
    @NotNull
    @Column(name = "numberOfViews")   
    private int numberOfViews = 0;
    
    @NotNull
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User userId;
    
    @OneToMany(mappedBy = "articleId", cascade = CascadeType.ALL)
    private List<Comment> commentsList;
    
    @OneToMany(mappedBy = "articleId", cascade = CascadeType.ALL)
    private List<ArticleLike> articleLikesList;
    
    public int getNumberOfComments(){
        return commentsList.size();
    }
    
    public void incNumberOfViews(){
        numberOfViews++;
    }
}
