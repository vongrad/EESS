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
    @JoinColumn(name = "CPR", referencedColumnName = "CPR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Student student;
    @JoinColumn(name = "FIRST_PRIORITY_2", referencedColumnName = "TITLE")
    @ManyToOne(optional = false)
    private Elective firstPriority2;
    @JoinColumn(name = "FIRST_PRIORITY_1", referencedColumnName = "TITLE")
    @ManyToOne(optional = false)
    private Elective firstPriority1;
    @JoinColumn(name = "SECOND_PRIORITY_2", referencedColumnName = "TITLE")
    @ManyToOne(optional = false)
    private Elective secondPriority2;
    @JoinColumn(name = "SECOND_PRIORITY_1", referencedColumnName = "TITLE")
    @ManyToOne(optional = false)
    private Elective secondPriority1;

    public SecondRoundVote(String cpr, Student student, Elective firstPriority2, Elective firstPriority1, Elective secondPriority2, Elective secondPriority1) {
        this.cpr = cpr;
        this.student = student;
        this.firstPriority2 = firstPriority2;
        this.firstPriority1 = firstPriority1;
        this.secondPriority2 = secondPriority2;
        this.secondPriority1 = secondPriority1;
    }

    public SecondRoundVote() {
    }

    public SecondRoundVote(String cpr) {
        this.cpr = cpr;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Elective getFirstPriority2() {
        return firstPriority2;
    }

    public void setFirstPriority2(Elective firstPriority2) {
        this.firstPriority2 = firstPriority2;
    }

    public Elective getFirstPriority1() {
        return firstPriority1;
    }

    public void setFirstPriority1(Elective firstPriority1) {
        this.firstPriority1 = firstPriority1;
    }

    public Elective getSecondPriority2() {
        return secondPriority2;
    }

    public void setSecondPriority2(Elective secondPriority2) {
        this.secondPriority2 = secondPriority2;
    }

    public Elective getSecondPriority1() {
        return secondPriority1;
    }

    public void setSecondPriority1(Elective secondPriority1) {
        this.secondPriority1 = secondPriority1;
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
