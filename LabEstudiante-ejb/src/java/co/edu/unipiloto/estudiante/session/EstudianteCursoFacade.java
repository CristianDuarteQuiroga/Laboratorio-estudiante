/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.session;

import co.edu.unipiloto.estudiante.entity.EstudianteCurso;
import co.edu.unipiloto.estudiante.entity.EstudianteCursoPK;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristian Duarte
 */
@Stateless
public class EstudianteCursoFacade extends AbstractFacade<EstudianteCurso> implements EstudianteCursoFacadeLocal {

    @PersistenceContext(unitName = "EstudiantePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteCursoFacade() {
        super(EstudianteCurso.class);
    }

    @Override
    public boolean insertarEstudianteCurso(int codigoCurso, int codigoEstudiante, int nota) {

        EstudianteCursoPK pk = new EstudianteCursoPK(codigoCurso, codigoEstudiante);
        
        if (consultarEstudiantecurso(pk)!= null) {
            return false;
        }
        else{
            EstudianteCurso ec = new EstudianteCurso(pk, nota);
            em.persist(ec);
            return true;
        }
    }
   
    @Override
    public EstudianteCurso consultarEstudiantecurso(EstudianteCursoPK pk) {
        return em.find(EstudianteCurso.class, pk);
    }

}
