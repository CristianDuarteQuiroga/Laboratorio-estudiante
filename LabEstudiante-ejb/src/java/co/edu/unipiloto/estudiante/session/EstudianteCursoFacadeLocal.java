/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.session;

import co.edu.unipiloto.estudiante.entity.EstudianteCurso;
import co.edu.unipiloto.estudiante.entity.EstudianteCursoPK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian Duarte
 */
@Local
public interface EstudianteCursoFacadeLocal {

    void create(EstudianteCurso estudianteCurso);

    void edit(EstudianteCurso estudianteCurso);

    void remove(EstudianteCurso estudianteCurso);

    EstudianteCurso find(Object id);

    List<EstudianteCurso> findAll();

    List<EstudianteCurso> findRange(int[] range);

    int count();
    
    boolean insertarEstudianteCurso(int codigoCurso,int codigoEstudiante, int nota);

    EstudianteCurso consultarEstudiantecurso(EstudianteCursoPK pk);
    
}
