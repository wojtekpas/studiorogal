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
@Table(name = "tag_uses")
@NamedQueries({
    @NamedQuery(name = "TagUse.findAll", query = "SELECT t FROM TagUse t"),
    @NamedQuery(name = "TagUse.findById", query = "SELECT t FROM TagUse t WHERE t.id = :id"),
    @NamedQuery(name = "TagUse.findByArticleId", query = "SELECT t FROM TagUse t WHERE t.articleId = :articleId"),
    @NamedQuery(name = "TagUse.findByTagId", query = "SELECT t FROM TagUse t WHERE t.tagId = :tagId")   
})
public class TagUse implements Serializable, EntityElement {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
  
    @NotNull
    @JoinColumn(name = "articleId", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Article articleId;
    
    @NotNull
    @JoinColumn(name = "tagId", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Tag tagId;
}
