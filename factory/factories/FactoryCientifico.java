package factories;

import articulos.Articulo;
import articulos.ArticuloCientifico;
import publicaciones.Publicacion;
import publicaciones.RevistaCientifica;

public class FactoryCientifico extends FactoryPublicacionArticulos {

	@Override
	public Articulo crearArticulo(String autor, String nombre) {
		return new ArticuloCientifico(autor, nombre);
	}

	@Override
	public Publicacion crearPublicacion(String nombre) {
		return new RevistaCientifica(nombre);
	}

}
