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
@Table(name = "peia_sec_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeiaSecRole.findAll", query = "SELECT p FROM PeiaSecRole p"),
    @NamedQuery(name = "PeiaSecRole.findById", query = "SELECT p FROM PeiaSecRole p WHERE p.id = :id"),
    @NamedQuery(name = "PeiaSecRole.findByName", query = "SELECT p FROM PeiaSecRole p WHERE p.name = :name")})
public class PeiaSecRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "name")
    private String name;

    public PeiaSecRole() {
    }

    public PeiaSecRole(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof PeiaSecRole)) {
            return false;
        }
        PeiaSecRole other = (PeiaSecRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.peia.entity.PeiaSecRole[ id=" + id + " ]";
    }
    
}
