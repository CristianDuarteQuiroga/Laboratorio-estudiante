/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Duarte
 */
@Entity
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByStudenid", query = "SELECT e FROM Estudiante e WHERE e.studenid = :studenid"),
    @NamedQuery(name = "Estudiante.findByFirstname", query = "SELECT e FROM Estudiante e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Estudiante.findByLastname", query = "SELECT e FROM Estudiante e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Estudiante.findByYearlevel", query = "SELECT e FROM Estudiante e WHERE e.yearlevel = :yearlevel")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENID")
    private Integer studenid;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "YEARLEVEL")
    private Integer yearlevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<EstudianteCurso> estudianteCursoCollection;

    public Estudiante() {
    }

    public Estudiante(Integer studenid, String firstname, String lastname, Integer yearlevel) {
        this.studenid = studenid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearlevel = yearlevel;
    }

    public Estudiante(Integer studenid) {
        this.studenid = studenid;
    }

    public Integer getStudenid() {
        return studenid;
    }

    public void setStudenid(Integer studenid) {
        this.studenid = studenid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getYearlevel() {
        return yearlevel;
    }

    public void setYearlevel(Integer yearlevel) {
        this.yearlevel = yearlevel;
    }

    @XmlTransient
    public Collection<EstudianteCurso> getEstudianteCursoCollection() {
        return estudianteCursoCollection;
    }

    public void setEstudianteCursoCollection(Collection<EstudianteCurso> estudianteCursoCollection) {
        this.estudianteCursoCollection = estudianteCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studenid != null ? studenid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.studenid == null && other.studenid != null) || (this.studenid != null && !this.studenid.equals(other.studenid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entity.Estudiante[ studenid=" + studenid + " ]";
    }
    
}
