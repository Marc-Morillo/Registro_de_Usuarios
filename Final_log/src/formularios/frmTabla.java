package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Final_log.Conexion;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

public class frmTabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnActualizar;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JButton btnEliminar;
	private JButton btnNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTabla frame = new frmTabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmTabla() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
		
		JButton btnCerrar = new JButton("Cerrar Seccion");
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBackground(SystemColor.activeCaptionText);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adios();
			}
		});
		contentPane.add(btnCerrar, BorderLayout.SOUTH);
		
		splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.NORTH);
		
		splitPane_1 = new JSplitPane();
		splitPane.setRightComponent(splitPane_1);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar();
			}
		});
		btnEliminar.setBackground(new Color(250, 128, 114));
		splitPane_1.setLeftComponent(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		splitPane_1.setRightComponent(btnActualizar);
		btnActualizar.setBackground(SystemColor.info);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actualizar();
			}
		});
		
		btnNuevo = new JButton("+ Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adios1();
			}
		});
		btnNuevo.setBackground(new Color(144, 238, 144));
		splitPane.setLeftComponent(btnNuevo);
	}
	private void ShowData()
	{
		Connection con = Conexion.conectar();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("user_id");
		model.addColumn("nombreUsuario");
		model.addColumn("nombre");
		model.addColumn("apellido");
		model.addColumn("telefono");
		model.addColumn("correo");
		model.addColumn("contraseña");
		model.addColumn("confirmarcontraseña");
		
		try
		{
			String sql = "Select * from usuario";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("user_id"),
						rs.getString("nombreusuario"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("telefono"),
						rs.getString("correo"),
						rs.getString("contraseña"),
						rs.getString("confirmarcontraseña")
						
				});
			}
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(60);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(80);
			table.getColumnModel().getColumn(6).setPreferredWidth(60);

		}
		catch(Exception e)
		{
			System.out.println("Error: "+ e);
		}
	}
	protected void Adios()
	{
		this.dispose();
		frmLogin login = new frmLogin();
		login.setVisible(true);
	}
	
	protected void Adios1()
	{
		this.dispose();
		frmDatos datos = new frmDatos();
		datos.setVisible(true);
	}
	
	protected void Eliminar()
	{
		int fila = table.getSelectedRow();
		String valor = table.getValueAt(fila, 0).toString();
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		String sql = "Delete From usuario Where user_id = '" + valor+"'";
		try
		{
			PreparedStatement eliminar = con.prepareStatement(sql);
			eliminar.executeUpdate();
			ShowData();
		}catch(Exception es)
		{
			JOptionPane.showMessageDialog(null, es + "No se logro generar el registro");
		}
	}
	
	protected void Actualizar()
	{
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		
		int fila = table.getSelectedRow();
		int id = Integer.parseInt((String) this.table.getValueAt(fila, 0).toString());
		String nombreUsuario = table.getValueAt(fila, 1).toString();
		String nombre = table.getValueAt(fila, 2).toString();
		String apellido = table.getValueAt(fila, 3).toString();
		String telefono = table.getValueAt(fila, 4).toString();
		String correo = table.getValueAt(fila, 5).toString();
		String contraseña = table.getValueAt(fila, 6).toString();
		String confirmarcontraseña = table.getValueAt(fila, 7).toString();
		
		String sql = "Update usuario Set nombreUsuario = '" + nombreUsuario + "', nombre = '" + nombre + "', apellido = '"+apellido+"', telefono = '"+telefono+"', correo = '"+correo+"', contraseña = '"+contraseña+"', confirmarcontraseña = '"+confirmarcontraseña+"' Where user_id = '"+id+"'";
		
		try
		{
			PreparedStatement actualizar = con.prepareStatement(sql);
			actualizar.executeUpdate();
			ShowData();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e + "No se pudieron editar los datos");
		}
	}
}
