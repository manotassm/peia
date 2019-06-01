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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmanotas
 */
@Entity
@Table(name = "peia_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeiaEmployee.findAll", query = "SELECT p FROM PeiaEmployee p"),
    @NamedQuery(name = "PeiaEmployee.findById", query = "SELECT p FROM PeiaEmployee p WHERE p.id = :id"),
    @NamedQuery(name = "PeiaEmployee.findByIdentification", query = "SELECT p FROM PeiaEmployee p WHERE p.identification = :identification"),
    @NamedQuery(name = "PeiaEmployee.findByIdTypeIdentification", query = "SELECT p FROM PeiaEmployee p WHERE p.idTypeIdentification = :idTypeIdentification"),
    @NamedQuery(name = "PeiaEmployee.findByFirstName", query = "SELECT p FROM PeiaEmployee p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "PeiaEmployee.findByLastName", query = "SELECT p FROM PeiaEmployee p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "PeiaEmployee.findByActive", query = "SELECT p FROM PeiaEmployee p WHERE p.active = :active"),
    @NamedQuery(name = "PeiaEmployee.findByIdSecUser", query = "SELECT p FROM PeiaEmployee p WHERE p.idSecUser = :idSecUser")})
public class PeiaEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "identification")
    private Integer identification;
    @Column(name = "id_type_identification")
    private Integer idTypeIdentification;
    @Size(max = 200)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 200)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "id_sec_user")
    private Integer idSecUser;

    public PeiaEmployee() {
    }

    public PeiaEmployee(Integer id) {
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

    public Integer getIdSecUser() {
        return idSecUser;
    }

    public void setIdSecUser(Integer idSecUser) {
        this.idSecUser = idSecUser;
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
        if (!(object instanceof PeiaEmployee)) {
            return false;
        }
        PeiaEmployee other = (PeiaEmployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.peia.entity.PeiaEmployee[ id=" + id + " ]";
    }
    
}
