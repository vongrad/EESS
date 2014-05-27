/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "TEACHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByCpr", query = "SELECT t FROM Teacher t WHERE t.cpr = :cpr"),
    @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "Teacher.deleteAll", query = "DELETE FROM Teacher"),
    @NamedQuery(name = "Teacher.findByLastName", query = "SELECT t FROM Teacher t WHERE t.lastName = :lastName")})
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CPR")
    private String cpr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "LAST_NAME")
    private String lastName;
    @JoinTable(name = "TEACHER_SKILL", joinColumns = {
        @JoinColumn(name = "CPR", referencedColumnName = "CPR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Skill> skillCollection;
    @OneToMany(mappedBy = "teacher")
    private Collection<Elective> electiveCollection;

    public Teacher() {
    }

    public Teacher(String cpr) {
        this.cpr = cpr;
    }

    public Teacher(String cpr, String firstName, String lastName) {
        this.cpr = cpr;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }
    
    public void addSkill(Skill skill){
        if (skillCollection == null){
            skillCollection = new ArrayList<>();
        }
        skillCollection.add(skill);
    }

    @XmlTransient
    public Collection<Elective> getElectiveCollection() {
        return electiveCollection;
    }

    public void setElectiveCollection(Collection<Elective> electiveCollection) {
        this.electiveCollection = electiveCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpr != null ? cpr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.cpr == null && other.cpr != null) || (this.cpr != null && !this.cpr.equals(other.cpr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Teacher[ cpr=" + cpr + " ]";
    }
    
}
