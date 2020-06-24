package factories;

import articulos.Articulo;
import publicaciones.Publicacion;

public abstract class FactoryPublicacionArticulos {
	public abstract Articulo crearArticulo(String autor, String nombre);
	public abstract Publicacion crearPublicacion(String nombre);
}
