package com.gruby.sr.entities;

import com.gruby.sr.interfaces.EntityElement;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
@EqualsAndHashCode()
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "article_rates")
@NamedQueries({
    @NamedQuery(name = "ArticleRate.findAll", query = "SELECT a FROM ArticleRate a"),
    @NamedQuery(name = "ArticleRate.findById", query = "SELECT a FROM ArticleRate a WHERE a.id = :id"),
    @NamedQuery(name = "ArticleRate.findByUserId", query = "SELECT a FROM ArticleRate a WHERE a.userId = :userId"),
    @NamedQuery(name = "ArticleRate.findByArticleId", query = "SELECT a FROM ArticleRate a WHERE a.articleId = :articleId")
})
public class ArticleRate implements Serializable, EntityElement {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "value")
    private Integer value = 0;
  
    @NotNull
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User userId;
    
    @NotNull
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Article articleId;
}