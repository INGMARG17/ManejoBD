package co.edu.itc.programacion2.PruebaBD.negocio;

import co.edu.itc.programacion2.PruebaBD.vo.EstudianteVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public Connection conexion;
    /**
     * nombre del usuario para conectarse a la base de datos.
     */
    private String usuario;
    /**
     * clave de conexi?n a la base de datos.
     */
    private String clave;
    /**
     * URL al cual se debe conectar para acceder a la base de datos.
     */
    private String cadenaConexion;

    public EstudianteDAO() {
        inicializar();
    }

    public void inicializar() {
        try {
            cadenaConexion = "jdbc:mysql://localhost:3306/itc";
            usuario = "root";
            clave = "admin";
            final String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void establecerConexion() {
        try {
            conexion = DriverManager.getConnection(cadenaConexion, usuario, clave);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            conexion.close();
            conexion = null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public EstudianteVO ingresarEstudiante(EstudianteVO e) {
        EstudianteVO objEst = null;
        establecerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement("INSERT INTO itc.estudiante VALUES(?, ?, ?, ?, ?)");
            ps.setInt(1, e.getCodigo());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido());
            ps.setString(4, e.getNumeroTelefonico());
            ps.setString(5, e.getEmail());

            ps.executeUpdate();
            objEst = e;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return objEst;
    }

    public List<EstudianteVO> estudiantesFindAll() {
        List<EstudianteVO> misEstudiantes = new ArrayList<EstudianteVO>();
        EstudianteVO objEstudiante;
        ResultSet resultados = null;
        establecerConexion();
        try {

            resultados = conexion.createStatement().
                    executeQuery("SELECT * FROM itc.estudiante");

            while (resultados.next()) {
                Integer codigo = resultados.getInt(1);
                String nombre = resultados.getString(2);
                String apellido = resultados.getString(3);
                String numeroTelefonico = resultados.getString(4);
                String email = resultados.getString(5);
                objEstudiante = new EstudianteVO(codigo, nombre, apellido, numeroTelefonico, email);
                misEstudiantes.add(objEstudiante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultados.close();
                cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return misEstudiantes;

    }

    public EstudianteVO estudianteFindByCodigo(int codigo) {

        EstudianteVO objEstudiante = null;
        ResultSet resultados = null;
        establecerConexion();
        try {

            resultados = conexion.createStatement().executeQuery("SELECT * FROM itc.estudiante WHERE codigo =" + codigo);

            while (resultados.next()) {
                Integer cod = resultados.getInt(1);
                String nombre = resultados.getString(2);
                String apellido = resultados.getString(3);
                String numeroTelefonico = resultados.getString(4);
                String email = resultados.getString(5);
                objEstudiante = new EstudianteVO(cod, nombre, apellido, numeroTelefonico, email);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultados.close();
                cerrarConexion();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return objEstudiante;
    }

    public void actualizarEstudiante(EstudianteVO e) {
        establecerConexion();
        PreparedStatement stm = null;

        try {
            stm = conexion.prepareStatement("UPDATE estudiante SET codigo=?, "
                    + "nombre=?, apellido=?, numeroTelefonico=?, email=? WHERE codigo=?");
            stm.setInt(1, e.getCodigo());
            stm.setString(2, e.getNombre());
            stm.setString(3, e.getApellido());
            stm.setString(4, e.getNumeroTelefonico());
            stm.setString(5, e.getEmail());
            stm.setInt(6, e.getCodigo());
            stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    cerrarConexion();
                    stm.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void eliminiarEstudiante (EstudianteVO e) {
        establecerConexion();
        PreparedStatement stm = null;

        try {
            stm = conexion.prepareStatement("DELETE FROM itc.estudiante WHERE codigo = ?");
            stm.setInt(1, e.getCodigo());
            stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    cerrarConexion();
                    stm.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
