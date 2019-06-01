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
@Table(name = "peia_sec_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeiaSecUser.findAll", query = "SELECT p FROM PeiaSecUser p"),
    @NamedQuery(name = "PeiaSecUser.findById", query = "SELECT p FROM PeiaSecUser p WHERE p.id = :id"),
    @NamedQuery(name = "PeiaSecUser.findByNick", query = "SELECT p FROM PeiaSecUser p WHERE p.nick = :nick"),
    @NamedQuery(name = "PeiaSecUser.findByPass", query = "SELECT p FROM PeiaSecUser p WHERE p.pass = :pass"),
    @NamedQuery(name="PeiaSecUser.loginUser", query = "select p from PeiaSecUser p where p.nick=:nick and p.pass=:pass and p.idPaieSecRole=:idRol "),
    @NamedQuery(name = "PeiaSecUser.findByIdPaieSecRole", query = "SELECT p FROM PeiaSecUser p WHERE p.idPaieSecRole = :idPaieSecRole")})
public class PeiaSecUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "nick")
    private String nick;
    @Size(max = 200)
    @Column(name = "pass")
    private String pass;
    @Column(name = "id_paie_sec_role")
    private Integer idPaieSecRole;

    public PeiaSecUser() {
    }

    public PeiaSecUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getIdPaieSecRole() {
        return idPaieSecRole;
    }

    public void setIdPaieSecRole(Integer idPaieSecRole) {
        this.idPaieSecRole = idPaieSecRole;
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
        if (!(object instanceof PeiaSecUser)) {
            return false;
        }
        PeiaSecUser other = (PeiaSecUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.peia.entity.PeiaSecUser[ id=" + id + " ]";
    }
    
}
