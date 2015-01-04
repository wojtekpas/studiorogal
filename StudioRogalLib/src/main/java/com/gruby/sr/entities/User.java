package com.gruby.sr.entities;

import com.gruby.sr.enums.Roles;
import com.gruby.sr.interfaces.EntityElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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

@ToString(of = "login")
@EqualsAndHashCode(exclude = "articlesList")
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role")
})
public class User implements Serializable, EntityElement {
   
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name = "registrationDate")
    private Date registrationDate;
    
    @NotNull
    @Column(name = "lastLoginDate")
    private Date lastLoginDate;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Column(name = "login", unique = true)
    private String login;

    @NotNull
    @Column(name = "role")
    private String role = Roles.user.toString();
    
    @NotNull
    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    List<Article> articlesList;
}
