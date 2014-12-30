package com.gruby.sr.entities;

import com.gruby.sr.entities.Comment;
import com.gruby.sr.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-30T01:24:43")
@StaticMetamodel(CommentLike.class)
public class CommentLike_ { 

    public static volatile SingularAttribute<CommentLike, Comment> commentId;
    public static volatile SingularAttribute<CommentLike, Integer> id;
    public static volatile SingularAttribute<CommentLike, Integer> value;
    public static volatile SingularAttribute<CommentLike, User> userId;

}