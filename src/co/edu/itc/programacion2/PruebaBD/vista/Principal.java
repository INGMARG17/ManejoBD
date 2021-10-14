
package co.edu.itc.programacion2.PruebaBD.vista;

import co.edu.itc.programacion2.PruebaBD.negocio.EstudianteDAO;
import co.edu.itc.programacion2.PruebaBD.vo.EstudianteVO;
import java.util.List;
import java.util.Scanner;


public class Principal {
    private static Scanner sc =  new Scanner(System.in);
    
    public static void main(String[] args) {
        EstudianteVO objRet= null;
        EstudianteDAO objDao =  new EstudianteDAO();
        
//        // lee estudiantes
//        List<EstudianteVO> misEst = objDao.estudiantesFindAll();
//        for(EstudianteVO e : misEst){
//            System.out.println("codigo "+e.getCodigo());
//            System.out.println("nombre "+e.getNombre());
//            System.out.println("apellido "+e.getApellido());
//        }
        
//       Ingresar un estudiante

//        System.out.println("Ingresar Estudiante");
//        System.out.println("Digite el codigo");
//        Integer cod =  Integer.parseInt(sc.next());
//        System.out.println("Digite el nombre");
//        String nom = sc.next();
//        System.out.println("Digite el apellido");
//        String apel = sc.next();
//        System.out.println("Digite el numero telefonico");
//        String numTel = sc.next();
//        System.out.println("digite el email");
//        String email =  sc.next();
//        EstudianteVO objEst =  new EstudianteVO(cod, nom, apel, numTel, email);
//        objRet = objDao.ingresarEstudiante(objEst);
//        if(objRet != null){
//        System.out.println("Guardado exitoso");
//        System.out.println("Lista de estudiantes");
//        List<EstudianteVO> misEst = objDao.estudiantesFindAll();
//        for(EstudianteVO e : misEst){
//            System.out.println("codigo "+e.getCodigo());
//            System.out.println("nombre "+e.getNombre());
//            System.out.println("apellido "+e.getApellido());
//        }
//        }else{
//            System.out.println("Se present+o un error");
//        }
        
        
       // Buscar por codigo 
        
//        System.out.println("Digite el código del estudiante a actualizar");
//        int codigoEst = Integer.parseInt(sc.next());
//        EstudianteVO miEst = objDao.estudianteFindByCodigo(codigoEst);
//        System.out.println("Los datos recuperados son ");
//        System.out.println("codigo "+miEst.getCodigo());
//        System.out.println("nombre "+miEst.getNombre());
//        System.out.println("apellido "+miEst.getApellido());
//        System.out.println("numero Telefonico "+miEst.getNumeroTelefonico());
//        System.out.println("email "+miEst.getEmail());
//        
//        System.out.println("Actualice el numero telefonico");
//        miEst.setNumeroTelefonico(sc.next());
//        System.out.println("actualice el email");
//        miEst.setEmail(sc.next());
//        
//        objDao.actualizarEstudiante(miEst);
//        
//        EstudianteVO miEstAct = objDao.estudianteFindByCodigo(codigoEst);
//        System.out.println("Los datos recuperados son ");
//        System.out.println("codigo "+miEstAct.getCodigo());
//        System.out.println("nombre "+miEstAct.getNombre());
//        System.out.println("apellido "+miEstAct.getApellido());
//        System.out.println("numero Telefonico "+miEstAct.getNumeroTelefonico());
//        System.out.println("email "+miEstAct.getEmail());

//          Eliminar estudiante
        System.out.println("Digite el código del estudiante a eliminar");
        int codigoEst = Integer.parseInt(sc.next());
        EstudianteVO miEst = objDao.estudianteFindByCodigo(codigoEst);
        System.out.println("Los datos recuperados del estudiante a eliminar son:  ");
        System.out.println("codigo "+miEst.getCodigo());
        System.out.println("nombre "+miEst.getNombre());
        System.out.println("apellido "+miEst.getApellido());
        System.out.println("numero Telefonico "+miEst.getNumeroTelefonico());
        System.out.println("email "+miEst.getEmail());
        
        objDao.eliminiarEstudiante(miEst);
        System.out.println("El estudiante ha sido eliminado de la base de datos  ");
        
        
    }
    
}
