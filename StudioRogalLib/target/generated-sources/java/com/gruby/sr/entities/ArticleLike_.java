package com.gruby.sr.entities;

import com.gruby.sr.entities.Article;
import com.gruby.sr.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-30T01:24:43")
@StaticMetamodel(ArticleLike.class)
public class ArticleLike_ { 

    public static volatile SingularAttribute<ArticleLike, Article> articleId;
    public static volatile SingularAttribute<ArticleLike, Integer> id;
    public static volatile SingularAttribute<ArticleLike, Integer> value;
    public static volatile SingularAttribute<ArticleLike, User> userId;

}