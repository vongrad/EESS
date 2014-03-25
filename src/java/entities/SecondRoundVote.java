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
import javax.persistence.ManyToOne;
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
@Table(name = "SECOND_ROUND_VOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecondRoundVote.findAll", query = "SELECT s FROM SecondRoundVote s"),
    @NamedQuery(name = "SecondRoundVote.findByCpr", query = "SELECT s FROM SecondRoundVote s WHERE s.cpr = :cpr")})
public class SecondRoundVote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CPR")
    private String cpr;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "FIRST_PRIORITY_1")
    private String firstPriority1;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "FIRST_PRIORITY_2")
    private String firstPriority2;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "SECOND_PRIORITY_1")
    private String secondPriority1;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "SECOND_PRIORITY_2")
    private String secondPriority2;
    public SecondRoundVote() {
    }

    public SecondRoundVote(String cpr) {
        this.cpr = cpr;
    }
    public SecondRoundVote(String cpr, String firstPriority1, String firstPriority2, String secondPriority1, String secondPriority2) {
        this.cpr = cpr;
        this.firstPriority1 = firstPriority1;
        this.firstPriority2 = firstPriority2;
        this.secondPriority1 = secondPriority1;
        this.secondPriority2 = secondPriority2;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstPriority1() {
        return firstPriority1;
    }

    public String getFirstPriority2() {
        return firstPriority2;
    }

    public String getSecondPriority1() {
        return secondPriority1;
    }

    public String getSecondPriority2() {
        return secondPriority2;
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
        if (!(object instanceof SecondRoundVote)) {
            return false;
        }
        SecondRoundVote other = (SecondRoundVote) object;
        if ((this.cpr == null && other.cpr != null) || (this.cpr != null && !this.cpr.equals(other.cpr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SecondRoundVote[ cpr=" + cpr + " ]";
    }
    
}
