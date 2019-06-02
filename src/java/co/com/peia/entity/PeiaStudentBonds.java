/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmanotas
 */
@Entity
@Table(name = "peia_student_bonds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeiaStudentBonds.findAll", query = "SELECT p FROM PeiaStudentBonds p"),
    @NamedQuery(name = "PeiaStudentBonds.findByCreationDate", query = "SELECT p FROM PeiaStudentBonds p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "PeiaStudentBonds.findById", query = "SELECT p FROM PeiaStudentBonds p WHERE p.id = :id"),
    @NamedQuery(name = "PeiaStudentBonds.findByIdCreationUser", query = "SELECT p FROM PeiaStudentBonds p WHERE p.idCreationUser = :idCreationUser"),
    @NamedQuery(name = "PeiaStudentBonds.findByIdStudent", query = "SELECT p FROM PeiaStudentBonds p WHERE p.idStudent = :idStudent"),
    @NamedQuery(name = "PeiaStudentBonds.findByValue", query = "SELECT p FROM PeiaStudentBonds p WHERE p.value = :value")
    
})
public class PeiaStudentBonds implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "id_creation_user")
    private Integer idCreationUser;
    
    
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    @ManyToOne
    private PeiaStudent idStudent;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Double value;

    public PeiaStudentBonds() {
    }

    public PeiaStudentBonds(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCreationUser() {
        return idCreationUser;
    }

    public void setIdCreationUser(Integer idCreationUser) {
        this.idCreationUser = idCreationUser;
    }

    public PeiaStudent getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(PeiaStudent idStudent) {
        this.idStudent = idStudent;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeiaStudentBonds)) {
            return false;
        }
        PeiaStudentBonds other = (PeiaStudentBonds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.peia.entity.PeiaStudentBonds[ id=" + id + " ]";
    }
    
}
