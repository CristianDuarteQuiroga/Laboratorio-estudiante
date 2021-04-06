<%-- 
    Document   : studentInfo
    Created on : 5/04/2021, 05:08:24 PM
    Author     : Cristian Duarte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentInfo" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.studentid}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearlevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" /><br>

                    </td>
                </tr>
            </table>
        </form>

        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentid}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearlevel}</td>
                </tr>
                </c:forEach> 
        </table>
        <br>
        
          <form action="./EstudianteCursoInfo" method="POST">
            <table>
                <tr>
                    <td>Estudiante Id</td>
                    <td><input type="text" name="EstudianteId" value="${estudiante_curso.estudianteid}" /></td>
                </tr>
                <tr>
                    <td>Curso Id</td>
                    <td><input type="text" name="CursoId" value="${estudiante_curso.cursoid}" /></td>
                </tr>
                <tr>
                    <td>Nota</td>
                    <td><input type="text" name="Nota" value="${estudiante_curso.nota}" /></td>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>