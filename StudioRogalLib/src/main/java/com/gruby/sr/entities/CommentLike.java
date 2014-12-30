/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "comment_likes")
@NamedQueries({
    @NamedQuery(name = "CommentLike.findAll", query = "SELECT c FROM Comment_Likes c"),
    @NamedQuery(name = "CommentLike.findById", query = "SELECT c FROM Comment_Likes c WHERE c.id = :id"),
    //@NamedQuery(name = "CommentLike.countLikes", query = "SELECT COUNT(c) FROM Comment_ Likes c WHERE c.value > 0"),
    //@NamedQuery(name = "CommentLike.countDislikes", query = "SELECT COUNT(c) FROM Comment_Likes c WHERE c.value < 0"),
    @NamedQuery(name = "CommentLike.findByUserId", query = "SELECT c FROM Comment_Likes c WHERE c.user_id = :user_id"),
    @NamedQuery(name = "CommentLike.findByCommentId", query = "SELECT c FROM Comment_Likes c WHERE c.comment_id = :comment_id")
})
public class CommentLike implements Serializable, EntityElement {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id = 0;

    @NotNull
    @Column(name = "value")
    private int value = 0;
  
    @NotNull
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User userId;
    
    @NotNull
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Comment commentId;
}