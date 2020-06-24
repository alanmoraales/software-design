package factories;

import articulos.Articulo;
import articulos.ArticuloDivulgacion;
import publicaciones.Blog;
import publicaciones.Publicacion;

public class FactoryDivulgacion extends FactoryPublicacionArticulos {

	@Override
	public Articulo crearArticulo(String autor, String nombre) {
		return new ArticuloDivulgacion(autor, nombre);
	}

	@Override
	public Publicacion crearPublicacion(String nombre) {
		return new Blog(nombre);
	}
	
}
