package escriptamiento;

public abstract class AlgoEncriptamiento {
	public abstract void configurar();
	public abstract String encriptar(String str);
	public abstract String desencriptar(String str);
}
