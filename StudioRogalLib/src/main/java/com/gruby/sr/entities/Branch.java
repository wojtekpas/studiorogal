package com.gruby.sr.entities;

import com.gruby.sr.enums.Branches;
import com.gruby.sr.interfaces.EntityElement;
import java.io.Serializable;
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

@ToString(of = "name")
@EqualsAndHashCode(exclude = "divisionsList")
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "branches")
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findById", query = "SELECT b FROM Branch b WHERE b.id = :id"),
    @NamedQuery(name = "Branch.findByName", query = "SELECT b FROM Branch b WHERE b.name = :name")
})
public class Branch implements Serializable, EntityElement {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Column(name = "name")
    private String name = Branches.football.toString();
    
    @OneToMany(mappedBy = "branchId", cascade = CascadeType.ALL)
    private List<Division> divisionsList;  
}
