/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Duarte
 */
@Entity
@Table(name = "ESTUDIANTE_CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudianteCurso.findAll", query = "SELECT e FROM EstudianteCurso e"),
    @NamedQuery(name = "EstudianteCurso.findByCursoid", query = "SELECT e FROM EstudianteCurso e WHERE e.estudianteCursoPK.cursoid = :cursoid"),
    @NamedQuery(name = "EstudianteCurso.findByEstudianteid", query = "SELECT e FROM EstudianteCurso e WHERE e.estudianteCursoPK.estudianteid = :estudianteid"),
    @NamedQuery(name = "EstudianteCurso.findByNota", query = "SELECT e FROM EstudianteCurso e WHERE e.nota = :nota")})
public class EstudianteCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudianteCursoPK estudianteCursoPK;
    @Column(name = "NOTA")
    private Integer nota;
    @JoinColumn(name = "CURSOID", referencedColumnName = "CURSOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "ESTUDIANTEID", referencedColumnName = "STUDENID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public EstudianteCurso() {
    }

    public EstudianteCurso(EstudianteCursoPK estudianteCursoPK) {
        this.estudianteCursoPK = estudianteCursoPK;
    }

    public EstudianteCurso(int cursoid, int estudianteid) {
        this.estudianteCursoPK = new EstudianteCursoPK(cursoid, estudianteid);
    }

    public EstudianteCurso(EstudianteCursoPK pk,int nota) {
        this.estudianteCursoPK = pk;
        this.nota = nota;
    }

    public EstudianteCursoPK getEstudianteCursoPK() {
        return estudianteCursoPK;
    }

    public void setEstudianteCursoPK(EstudianteCursoPK estudianteCursoPK) {
        this.estudianteCursoPK = estudianteCursoPK;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteCursoPK != null ? estudianteCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteCurso)) {
            return false;
        }
        EstudianteCurso other = (EstudianteCurso) object;
        if ((this.estudianteCursoPK == null && other.estudianteCursoPK != null) || (this.estudianteCursoPK != null && !this.estudianteCursoPK.equals(other.estudianteCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entity.EstudianteCurso[ estudianteCursoPK=" + estudianteCursoPK + " ]";
    }
    
}
