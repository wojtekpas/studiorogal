package com.gruby.sr.entities;

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
import javax.validation.constraints.Size;
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
@Table(name = "probes")
@NamedQueries({
    @NamedQuery(name = "Probe.findAll", query = "SELECT p FROM Probe p"),
    @NamedQuery(name = "Probe.findById", query = "SELECT p FROM Probe p WHERE p.id = :id")
})
public class Probe implements Serializable, EntityElement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "question")
    private String question;
    
    @OneToMany(mappedBy = "probeId", cascade = CascadeType.ALL)
    private List<TagUse> answersList;
}
