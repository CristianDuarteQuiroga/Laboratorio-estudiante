/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cristian Duarte
 */
@Embeddable
public class EstudianteCursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CURSOID")
    private int cursoid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTUDIANTEID")
    private int estudianteid;

    public EstudianteCursoPK() {
    }

    public EstudianteCursoPK(int cursoid, int estudianteid) {
        this.cursoid = cursoid;
        this.estudianteid = estudianteid;
    }

    public int getCursoid() {
        return cursoid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public int getEstudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(int estudianteid) {
        this.estudianteid = estudianteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cursoid;
        hash += (int) estudianteid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteCursoPK)) {
            return false;
        }
        EstudianteCursoPK other = (EstudianteCursoPK) object;
        if (this.cursoid != other.cursoid) {
            return false;
        }
        if (this.estudianteid != other.estudianteid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entity.EstudianteCursoPK[ cursoid=" + cursoid + ", estudianteid=" + estudianteid + " ]";
    }
    
}
