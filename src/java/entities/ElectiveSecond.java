/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "ELECTIVE_SECOND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElectiveSecond.findAll", query = "SELECT e FROM ElectiveSecond e"),
    @NamedQuery(name = "ElectiveSecond.findByTitle", query = "SELECT e FROM ElectiveSecond e WHERE e.title = :title"),
    @NamedQuery(name = "ElectiveSecond.findByPool", query = "SELECT e FROM ElectiveSecond e WHERE e.pool = :pool")})
public class ElectiveSecond extends Elective {
    private static final long serialVersionUID = 1L;
 
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "POOL")
    private String pool;
  
    public ElectiveSecond() {
    }

    public ElectiveSecond(String title) {
        this.title = title;
    }

    public ElectiveSecond(String title, String pool) {
        this.title = title;
        this.pool = pool;
    }

  

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
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
        if (!(object instanceof ElectiveSecond)) {
            return false;
        }
        ElectiveSecond other = (ElectiveSecond) object;
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ElectiveSecond[ title=" + title + " ]";
    }
    
}
