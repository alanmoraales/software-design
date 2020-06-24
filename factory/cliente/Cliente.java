package cliente;

import articulos.Articulo;
import factories.FactoryPublicacionArticulos;
import publicaciones.Publicacion;

public class Cliente {
	private Articulo art;
	private Publicacion pub;	
	
	public Cliente(String autor, String tituloArticulo, 
			String tituloRevista, FactoryPublicacionArticulos factory) {
		
		this.art = factory.crearArticulo(autor, tituloArticulo);
		this.pub = factory.crearPublicacion(tituloRevista);
	}

	public void printClasses() {
		System.out.println(art.getClass());
		System.out.println(pub.getClass());
	}
}

