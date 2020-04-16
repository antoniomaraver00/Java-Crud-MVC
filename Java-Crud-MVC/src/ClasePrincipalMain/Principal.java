package ClasePrincipalMain;

import controlador.Controlador;
import modelo.Empleado;
import vista.vista;

public class Principal {

	public static void main(String[] args) 
	{ 
		vista Vista = new vista();
		Empleado Modelo = new Empleado();
		new Controlador(Vista, Modelo); 
	}
}
