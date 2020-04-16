package modelo;
import  java.sql.Connection ;
import  java.sql.PreparedStatement ;
import  java.sql.ResultSet ;
import  java.util.ArrayList ;
import  java.util.List ;
public class EmpleadoDAO {
	 PreparedStatement ps;
	    ResultSet rs;
	    Connection con;
	    Conexion conectar = new Conexion ();
	    Empleado p = new Empleado();

	    public List listar () {
	        List <Empleado> datos = new ArrayList <> ();
	        String sql="select * from empleados";
	        try {
	            con = conectar.getConnection ();
	            ps = con.prepareStatement (sql);
	            rs = ps.executeQuery ();
	            while (rs.next ()) {
	                Empleado p = new Empleado ();
	                p.setId (rs.getInt (1));
	                p.setNom (rs.getString (2));
	                
	                datos.add (p);
	            }
	        } catch (Exception e) {
	        }
	        return datos;
	    }
}
	   