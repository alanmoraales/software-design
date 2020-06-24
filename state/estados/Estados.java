package estados;

import model.MEF;

public interface Estados {
	
	void moneda(MEF mef);
	void pasar(MEF mef);
	void listo(MEF mef);
	void reset(MEF mef);
	
}
