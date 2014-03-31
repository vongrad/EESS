/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByCpr", query = "SELECT s FROM Student s WHERE s.cpr = :cpr"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName")})
public class Student implements Serializable {

    @ManyToMany(mappedBy = "studentCollection")
    private Collection<Elective> electiveCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CPR")
    private String cpr;
    @Size(max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    @JoinColumn(name = "SECONDARY_ELECTIVE", referencedColumnName = "ELECTIVE_ID")
    @ManyToOne
    private Elective secondaryElective;
    @JoinColumn(name = "PRIMARY_ELECTIVE", referencedColumnName = "ELECTIVE_ID")
    @ManyToOne
    private Elective primaryElective;

    public Student() {
    }

    public Student(String cpr, String firstName, String lastName) {
        this.cpr = cpr;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String cpr) {
        this.cpr = cpr;
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

    public boolean addElective(Elective elective) {
        return electiveCollection.add(elective);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Elective getSecondaryElective() {
        return secondaryElective;
    }

    public void setSecondaryElective(Elective secondaryElective) {
        this.secondaryElective = secondaryElective;
    }

    public Elective getPrimaryElective() {
        return primaryElective;
    }

    public void setPrimaryElective(Elective primaryElective) {
        this.primaryElective = primaryElective;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.cpr == null && other.cpr != null) || (this.cpr != null && !this.cpr.equals(other.cpr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Student[ cpr=" + cpr + " ]";
    }

    @XmlTransient
    public Collection<Elective> getElectiveCollection() {
        return electiveCollection;
    }

    public void setElectiveCollection(Collection<Elective> electiveCollection) {
        this.electiveCollection = electiveCollection;
    }

}
