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
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCursoid", query = "SELECT c FROM Curso c WHERE c.cursoid = :cursoid"),
    @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Curso.findByNCreditos", query = "SELECT c FROM Curso c WHERE c.nCreditos = :nCreditos"),
    @NamedQuery(name = "Curso.findBySemestre", query = "SELECT c FROM Curso c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Curso.findByEstudiantesAdmitidos", query = "SELECT c FROM Curso c WHERE c.estudiantesAdmitidos = :estudiantesAdmitidos")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURSOID")
    private Integer cursoid;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "N_CREDITOS")
    private Integer nCreditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "ESTUDIANTES_ADMITIDOS")
    private Integer estudiantesAdmitidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<EstudianteCurso> estudianteCursoCollection;

    public Curso() {
    }

    public Curso(Integer cursoid) {
        this.cursoid = cursoid;
    }

    public Integer getCursoid() {
        return cursoid;
    }

    public void setCursoid(Integer cursoid) {
        this.cursoid = cursoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNCreditos() {
        return nCreditos;
    }

    public void setNCreditos(Integer nCreditos) {
        this.nCreditos = nCreditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getEstudiantesAdmitidos() {
        return estudiantesAdmitidos;
    }

    public void setEstudiantesAdmitidos(Integer estudiantesAdmitidos) {
        this.estudiantesAdmitidos = estudiantesAdmitidos;
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
        hash += (cursoid != null ? cursoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursoid == null && other.cursoid != null) || (this.cursoid != null && !this.cursoid.equals(other.cursoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entity.Curso[ cursoid=" + cursoid + " ]";
    }
    
}
