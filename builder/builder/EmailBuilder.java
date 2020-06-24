package builder;

import java.util.HashSet;
import java.util.Set;


public class EmailBuilder {
	private Set<String> destinatarios;
	private String titulo;
	private String mensaje;
	
	
	public EmailBuilder() {
		this.destinatarios = new HashSet<String>();
		this.mensaje = "";
	}
	
	public EmailBuilder addDestinatario(String destinatario) {
		this.destinatarios.add(destinatario);
		return this;
	}
	
	public EmailBuilder addTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	
	public EmailBuilder addSaludo(String saludo) {
		this.mensaje += saludo;
		return this;
	}
	
	public EmailBuilder addTexto(String texto) {
		this.mensaje += texto;
		return this;
	}
	
	public EmailBuilder addDespedida(String despedida) {
		this.mensaje += despedida;
		return this;
	}
	
	private String getDestinatarios() {
		Object[] destinatariosArray = this.destinatarios.toArray(); 
			
		String destinatarios = (String)destinatariosArray[0];
		
		for(int i=1; i<destinatariosArray.length; i++) {
			destinatarios += ";" + destinatariosArray[i]; 
		}
		
		return destinatarios;
	}
	
	public Email build() {
		
		System.out.println("Construyendo email...");
		Email email = new Email(titulo, getDestinatarios(), mensaje);
		return email;
	}
	
	
}
