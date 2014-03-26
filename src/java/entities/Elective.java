/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "ELECTIVE")
@Inheritance(strategy = InheritanceType.JOINED)

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elective.findAll", query = "SELECT e FROM Elective e"),
    @NamedQuery(name = "Elective.findByElectiveID", query = "SELECT e FROM Elective e WHERE e.electiveID = :electiveID"),
    @NamedQuery(name = "Elective.findByTitle", query = "SELECT e FROM Elective e WHERE e.title = :title"),
    @NamedQuery(name = "Elective.findByDiscription", query = "SELECT e FROM Elective e WHERE e.discription = :discription"),
    @NamedQuery(name = "Elective.findByCreationDate", query = "SELECT e FROM Elective e WHERE e.creationDate = :creationDate"),
    @NamedQuery(name = "Elective.findByProposed", query = "SELECT e FROM Elective e WHERE e.proposed = :proposed")})
public class Elective implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Elective_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)//, generator = "seq_acc")
    protected String electiveID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DISCRIPTION")
    private String discription;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Size(max = 5)
    @Column(name = "PROPOSED")
    private String proposed;

    public Elective() {
    }

    public Elective(String title, String discription) {
        this.title = title;
        this.discription = discription;
    }

    public Elective(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getProposed() {
        return proposed;
    }

    public void setProposed(String proposed) {
        this.proposed = proposed;
    }

    public String getElectiveID() {
        return electiveID;
    }

    public void setElectiveID(String electiveID) {
        this.electiveID = electiveID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (title != null ? title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elective)) {
            return false;
        }
        Elective other = (Elective) object;
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Elective[ title=" + title + " ]";
    }

}
