/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Elective.findByCreationDate", query = "SELECT e FROM Elective e WHERE e.creationDate = :creationDate"),
    @NamedQuery(name = "Elective.findByDescription", query = "SELECT e FROM Elective e WHERE e.description = :description"),
    @NamedQuery(name = "Elective.findByPool", query = "SELECT e FROM Elective e WHERE e.pool = :pool"),
    @NamedQuery(name = "Elective.findByProposed", query = "SELECT e FROM Elective e WHERE e.proposed = :proposed"),
    @NamedQuery(name = "Elective.findByTitle", query = "SELECT e FROM Elective e WHERE e.title = :title"),
    @NamedQuery(name = "Elective.deleteAll", query = "DELETE FROM Elective"),
    @NamedQuery(name = "Elective.findByElectiveId", query = "SELECT e FROM Elective e WHERE e.electiveId = :electiveId")})
public class Elective implements Serializable {
   
    @JoinTable(name = "STUDEN_ELECTIVE", joinColumns = {
        @JoinColumn(name = "ELECTIVE_ID", referencedColumnName = "ELECTIVE_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CPR", referencedColumnName = "CPR")})
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Student> studentCollection;

    private static final long serialVersionUID = 1L;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "POOL")
    private String pool;
    @Size(max = 255)
    @Column(name = "PROPOSED")
    private String proposed;
    @Column(name = "TAUGHT")
    private Short taught;
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELECTIVE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int electiveId;
    @JoinColumn(name = "TEACHER", referencedColumnName = "CPR")
    @ManyToOne(cascade = CascadeType.ALL)
    
    private Teacher teacher;

    public Elective(Integer electiveId, String title, String description, Date creationDate, String proposed) {
        this.creationDate = creationDate;
        this.description = description;
        this.proposed = proposed;
        this.title = title;
        this.electiveId = electiveId;
    }
    
     public Elective(Integer electiveId, String title, String description, Date creationDate) {
        this.creationDate = creationDate;
        this.description = description;
        this.title = title;
        this.electiveId = electiveId;
    }

    public Elective(String title, String description, Date creationDate, String proposed) {
        this.title = title;
        this.creationDate = creationDate;
        this.description = description;
        this.electiveId = electiveId;
    }
    

    public Elective(String description, String proposed, String title, int electiveId) {
        this.description = description;
        this.proposed = proposed;
        this.title = title;
        this.electiveId = electiveId;
    }
    
    

    public Elective() {
    }

    public Elective(Integer electiveId) {
        this.electiveId = electiveId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getProposed() {
        return proposed;
    }

    public void setProposed(String proposed) {
        this.proposed = proposed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getElectiveId() {
        return electiveId;
    }

    public void setElectiveId(int electiveId) {
        this.electiveId = electiveId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }
    
    public boolean addStudent(Student student){
        return studentCollection.add(student);
    }

    public Short getTaught() {
        return taught;
    }

    public void setTaught(Short taught) {
        this.taught = taught;
    }

    @Override
    public String toString() {
        return "entities.Elective[ electiveId=" + electiveId + " ]";
    }

}
