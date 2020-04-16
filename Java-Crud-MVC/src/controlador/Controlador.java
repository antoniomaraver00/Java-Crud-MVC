package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Empleado;
import modelo.EmpleadoDAO;
public class Controlador implements ActionListener{

	EmpleadoDAO dao=new EmpleadoDAO();
	Empleado p=new Empleado();
	vista.vista vista=new vista.vista();
	DefaultTableModel modelo=new DefaultTableModel ();
	
	public Controlador(vista.vista v, Empleado modelo2) {
		this.vista=v;
		this.vista.btnListar.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vista.btnListar) {
			listar(vista.tabla);
		}
		
	}
	
	public void listar (JTable tabla) {
		modelo=(DefaultTableModel)tabla.getModel();
		List<Empleado>lista=dao.listar();
		Object[]object=new Object[2];
		for (int i = 0; i< lista.size() ; i++)	{
			object[0]=lista.get(i).getId();
			object[1]=lista.get(i).getNom();
			modelo.addRow(object);
		}
		vista.tabla.setModel(modelo);
	}

}
