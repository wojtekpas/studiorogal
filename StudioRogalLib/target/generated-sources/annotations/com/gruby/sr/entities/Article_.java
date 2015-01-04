package com.gruby.sr.entities;

import com.gruby.sr.entities.ArticleLike;
import com.gruby.sr.entities.Comment;
import com.gruby.sr.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-31T00:35:24")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile ListAttribute<Article, Comment> commentsList;
    public static volatile SingularAttribute<Article, Integer> numberOfViews;
    public static volatile SingularAttribute<Article, Integer> id;
    public static volatile SingularAttribute<Article, String> title;
    public static volatile ListAttribute<Article, ArticleLike> articleLikesList;
    public static volatile SingularAttribute<Article, User> userId;
    public static volatile SingularAttribute<Article, String> content;

}