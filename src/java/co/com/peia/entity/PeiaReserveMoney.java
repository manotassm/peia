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
@Table(name = "peia_reserve_money")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeiaReserveMoney.findAll", query = "SELECT p FROM PeiaReserveMoney p"),
    @NamedQuery(name = "PeiaReserveMoney.findById", query = "SELECT p FROM PeiaReserveMoney p WHERE p.id = :id"),
    @NamedQuery(name = "PeiaReserveMoney.findByIdPeiaTickets", query = "SELECT p FROM PeiaReserveMoney p WHERE p.idPeiaTickets = :idPeiaTickets"),
    @NamedQuery(name = "PeiaReserveMoney.findByCant", query = "SELECT p FROM PeiaReserveMoney p WHERE p.cant = :cant"),
    @NamedQuery(name = "PeiaReserveMoney.findByIdCreacionUser", query = "SELECT p FROM PeiaReserveMoney p WHERE p.idCreacionUser = :idCreacionUser"),
    @NamedQuery(name = "PeiaReserveMoney.findByCreationDate", query = "SELECT p FROM PeiaReserveMoney p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "PeiaReserveMoney.findByTotal", query = "SELECT p FROM PeiaReserveMoney p WHERE p.total = :total")})
public class PeiaReserveMoney implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_peia_tickets")
    private Integer idPeiaTickets;
    @Column(name = "cant")
    private Integer cant;
    @Column(name = "id_creacion_user")
    private Integer idCreacionUser;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;

    public PeiaReserveMoney() {
    }

    public PeiaReserveMoney(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPeiaTickets() {
        return idPeiaTickets;
    }

    public void setIdPeiaTickets(Integer idPeiaTickets) {
        this.idPeiaTickets = idPeiaTickets;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Integer getIdCreacionUser() {
        return idCreacionUser;
    }

    public void setIdCreacionUser(Integer idCreacionUser) {
        this.idCreacionUser = idCreacionUser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        if (!(object instanceof PeiaReserveMoney)) {
            return false;
        }
        PeiaReserveMoney other = (PeiaReserveMoney) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.peia.entity.PeiaReserveMoney[ id=" + id + " ]";
    }
    
}
