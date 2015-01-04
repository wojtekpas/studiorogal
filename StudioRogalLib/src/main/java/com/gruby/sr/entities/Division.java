package com.gruby.sr.entities;

import com.gruby.sr.enums.Branches;
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
@EqualsAndHashCode(exclude = "articlesList")
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "divisions")
@NamedQueries({
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d"),
    @NamedQuery(name = "Division.findById", query = "SELECT d FROM Division d WHERE d.id = :id"),
    @NamedQuery(name = "Division.findByName", query = "SELECT d FROM Division d WHERE d.name = :name"),
    @NamedQuery(name = "Division.findByDivisionId", query = "SELECT d FROM Division d WHERE d.branchId = :branchId")
})
public class Division implements Serializable, EntityElement {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @NotNull
    @JoinColumn(name = "branchId", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Branch branchId;
    
    @OneToMany(mappedBy = "divisionId", cascade = CascadeType.ALL)
    private List<Comment> articlesList;
}
