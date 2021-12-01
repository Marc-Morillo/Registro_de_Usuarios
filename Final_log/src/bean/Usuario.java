package bean;

public class Usuario {
	private String ID;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private String contrase�a;
	private String confirmarcontrase�a;

	public Usuario(String ID, String nombreUsuario, String nombre, String apellido, String telefono, String correo,
			String contrase�a, String confirmarcontrase�a) {
		this.ID = ID;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.confirmarcontrase�a = confirmarcontrase�a;
	}

	public Usuario() {
		
	}
	
	public String getID()
	{
		return ID;
	}
	
	public void setID(String ID)
	{
		this.ID = ID;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getConfirmarcontrase�a() {
		return confirmarcontrase�a;
	}

	public void setConfirmarcontrase�a(String confirmarcontrase�a) {
		this.confirmarcontrase�a = confirmarcontrase�a;
	}

}
