/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.peia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmanotas
 */
@Entity
@Table(name = "peia_student", catalog = "peia", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeiaStudent.findAll", query = "SELECT p FROM PeiaStudent p"),
    @NamedQuery(name = "PeiaStudent.findById", query = "SELECT p FROM PeiaStudent p WHERE p.id = :id"),
    @NamedQuery(name = "PeiaStudent.findByIdentification", query = "SELECT p FROM PeiaStudent p WHERE p.identification = :identification"),
    @NamedQuery(name = "PeiaStudent.findByIdTypeIdentification", query = "SELECT p FROM PeiaStudent p WHERE p.idTypeIdentification = :idTypeIdentification"),
    @NamedQuery(name = "PeiaStudent.findByFirstName", query = "SELECT p FROM PeiaStudent p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "PeiaStudent.findByLastName", query = "SELECT p FROM PeiaStudent p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "PeiaStudent.findByActive", query = "SELECT p FROM PeiaStudent p WHERE p.active = :active")})
public class PeiaStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "identification")
    private Integer identification;
    @Column(name = "id_type_identification")
    private Integer idTypeIdentification;
    @Size(max = 300)
    @Column(name = "first_name", length = 300)
    private String firstName;
    @Size(max = 300)
    @Column(name = "last_name", length = 300)
    private String lastName;
    @Column(name = "active")
    private Boolean active;

    public PeiaStudent() {
    }

    public PeiaStudent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdentification() {
        return identification;
    }

    public void setIdentification(Integer identification) {
        this.identification = identification;
    }

    public Integer getIdTypeIdentification() {
        return idTypeIdentification;
    }

    public void setIdTypeIdentification(Integer idTypeIdentification) {
        this.idTypeIdentification = idTypeIdentification;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        if (!(object instanceof PeiaStudent)) {
            return false;
        }
        PeiaStudent other = (PeiaStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.peia.entity.PeiaStudent[ id=" + id + " ]";
    }
    
}
