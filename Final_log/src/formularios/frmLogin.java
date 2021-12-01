package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimientos.GestionUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(49, 78, 82, 24);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setBounds(49, 113, 69, 24);
		contentPane.add(lblContrasena);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(119, 78, 136, 24);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(119, 113, 135, 24);
		contentPane.add(txtContrasena);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setForeground(Color.RED);
		btnSalir.setBounds(298, 11, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setForeground(Color.BLUE);
		btnIngresar.setBounds(49, 179, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar();
			}
		});
		btnRegistrar.setForeground(SystemColor.desktop);
		btnRegistrar.setBounds(207, 179, 89, 23);
		contentPane.add(btnRegistrar);
	}

	protected void salir() {
		System.exit(0);
	}

	protected void registrar() {
		this.dispose();
		frmDatos datos = new frmDatos();
		datos.setVisible(true);
	}

	protected void ingresar() {
		String usuario = txtUsuario.getText();
		String contraseña = String.valueOf(txtContrasena.getPassword());
		GestionUsuario Gestion = new GestionUsuario();
		Usuario usux = new Usuario();
		usux.setNombreUsuario(usuario);
		usux.setContraseña(contraseña);
		
		Usuario usu = Gestion.obtenerUsuario(usux);
		if(usu != null)
		{
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			this.dispose();
			frmTabla tabla = new frmTabla();
			tabla.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(contentPane, "“debe ingresar su usuario\r\n"
					+ "y contraseña, si no está registrado debe registrarse”", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected void Registrar()
	{
		this.dispose();
		frmDatos datos = new frmDatos();
		datos.setVisible(true);
	}
}
