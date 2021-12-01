package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimientos.RegistrarUsuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmDatos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtcorreo;
	private JPasswordField txtContrasena;
	private JPasswordField txtConContrasena;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDatos frame = new frmDatos();
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
	public frmDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("REGISTRAR NUEVO USUARIO");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(86, 11, 254, 31);
		contentPane.add(lblTitulo);
		
		JLabel lblNombreUsuarui = new JLabel("Nombre de Usuario:");
		lblNombreUsuarui.setBounds(26, 51, 124, 14);
		contentPane.add(lblNombreUsuarui);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(78, 76, 68, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(76, 101, 70, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(78, 126, 68, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblcorreo = new JLabel("Correo:");
		lblcorreo.setBounds(78, 151, 68, 14);
		contentPane.add(lblcorreo);
		
		JLabel lblcontrasena = new JLabel("Contrase\u00F1a:");
		lblcontrasena.setBounds(78, 176, 72, 14);
		contentPane.add(lblcontrasena);
		
		JLabel lblconfcontrasena = new JLabel("Confirmar constrase\u00F1a:");
		lblconfcontrasena.setBounds(15, 201, 135, 14);
		contentPane.add(lblconfcontrasena);
		
		txtNomUsuario = new JTextField();
		txtNomUsuario.setBounds(153, 48, 139, 20);
		contentPane.add(txtNomUsuario);
		txtNomUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(153, 73, 139, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(153, 98, 139, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(153, 123, 139, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(153, 148, 139, 20);
		contentPane.add(txtcorreo);
		txtcorreo.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(153, 173, 139, 20);
		contentPane.add(txtContrasena);
		
		txtConContrasena = new JPasswordField();
		txtConContrasena.setBounds(153, 198, 139, 20);
		contentPane.add(txtConContrasena);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarUsuario();
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setBounds(221, 231, 139, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adios();
			}
		});
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBounds(38, 231, 135, 23);
		contentPane.add(btnCancelar);
	}
	
	protected void registrarUsuario()
	{
		String nombreUsuario = txtNomUsuario.getText().toString();
		String nombre = txtNombre.getText().toString();
		String apellido = txtApellido.getText().toString();
		String telefono = txtTelefono.getText().toString();
		String correo = txtcorreo.getText().toString();
		String contraseña = String.valueOf(txtContrasena.getPassword());
		String concontraseña = String.valueOf(txtConContrasena.getPassword());
		
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setTelefono(telefono);
		usuario.setCorreo(correo);
		usuario.setContraseña(contraseña);
		usuario.setConfirmarcontraseña(concontraseña);
		
		if(txtNomUsuario.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtcorreo.getText().isEmpty() || String.valueOf(txtContrasena.getPassword()).isEmpty() || String.valueOf(txtConContrasena.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Favor no dejar campos vacios");
		}
		else {
		
		if(contraseña.equals(concontraseña))
		{
			RegistrarUsuario registro = new RegistrarUsuario();
			int ok = registro.registrar(usuario);
			
			if(ok > 0)
			{
				JOptionPane.showMessageDialog(contentPane, "Usuario Registrado");
				Adios();
			}
			else
			{
				JOptionPane.showMessageDialog(contentPane, "No se registro el usuario", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(contentPane, "Contraseñas diferentes", "Error", JOptionPane.ERROR_MESSAGE);
			Adios1();
		}
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
}
