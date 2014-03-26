/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "ELECTIVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elective.findAll", query = "SELECT e FROM Elective e"),
    @NamedQuery(name = "Elective.findByTitle", query = "SELECT e FROM Elective e WHERE e.title = :title"),
    @NamedQuery(name = "Elective.findByDiscription", query = "SELECT e FROM Elective e WHERE e.discription = :discription"),
    @NamedQuery(name = "Elective.findByPool", query = "SELECT e FROM Elective e WHERE e.pool = :pool"),
    @NamedQuery(name = "Elective.findByCreationDate", query = "SELECT e FROM Elective e WHERE e.creationDate = :creationDate")})
public class Elective implements Serializable {
    @Size(max = 5)
    @Column(name = "PROPOSED")
    private String proposed;
   
        
      private static final long serialVersionUID = 1L;
    @Id
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
    @Size(max = 1)
    @Column(name = "POOL")
    private String pool;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    private int countFirstPriority=0;
    private int countSecondPriority=0;

    

    public Elective() {
    }


    public Elective(String title) {
        this.title = title;
    }

    public Elective(String title, String discription, Date creationDate) {
        this.title = title;
        this.discription = discription;
        this.creationDate = creationDate;
    }

    public Elective(String title, String discription) {
        this.title = title;
        this.discription = discription;
    }

    public int getCountFirstPriority() {
        return countFirstPriority;
    }

    public int getCountSecondPriority() {
        return countSecondPriority;
    }

    public void setCountFirstPriority(int countFirstPriority) {
        this.countFirstPriority = countFirstPriority;
    }

    public void setCountSecondPriority(int countSecondPriority) {
        this.countSecondPriority = countSecondPriority;
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

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
        return "entities.Electives[ title=" + title + " ]";
    }

    public String getProposed() {
        return proposed;
    }

    public void setProposed(String proposed) {
        this.proposed = proposed;
    }


     
}
