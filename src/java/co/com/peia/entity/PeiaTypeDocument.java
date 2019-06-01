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
@Table(name = "peia_type_document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeiaTypeDocument.findAll", query = "SELECT p FROM PeiaTypeDocument p"),
    @NamedQuery(name = "PeiaTypeDocument.findById", query = "SELECT p FROM PeiaTypeDocument p WHERE p.id = :id"),
    @NamedQuery(name = "PeiaTypeDocument.findByCode", query = "SELECT p FROM PeiaTypeDocument p WHERE p.code = :code"),
    @NamedQuery(name = "PeiaTypeDocument.findByName", query = "SELECT p FROM PeiaTypeDocument p WHERE p.name = :name")})
public class PeiaTypeDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "code")
    private String code;
    @Size(max = 200)
    @Column(name = "name")
    private String name;

    public PeiaTypeDocument() {
    }

    public PeiaTypeDocument(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        if (!(object instanceof PeiaTypeDocument)) {
            return false;
        }
        PeiaTypeDocument other = (PeiaTypeDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.peia.entity.PeiaTypeDocument[ id=" + id + " ]";
    }
    
}
