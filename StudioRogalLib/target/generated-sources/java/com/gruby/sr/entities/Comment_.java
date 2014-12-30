package com.gruby.sr.entities;

import com.gruby.sr.entities.Article;
import com.gruby.sr.entities.CommentLike;
import com.gruby.sr.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-30T01:24:43")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Article> articleId;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile ListAttribute<Comment, CommentLike> commentLikesList;
    public static volatile SingularAttribute<Comment, User> userId;
    public static volatile SingularAttribute<Comment, String> content;

}