package client;

import composite.*;
import menu.*;
import comidascenas.*;
import kids.*;
import desayunosalmuerzos.*;

public class Client {
	
	public Client(MenuItem menu) {
		System.out.println(menu.print());
	}

	public static void main(String[] args) {
		Menu menu = new MainMenu();
		
		Menu kids = new Kids();
		Menu disney = new MenuInfantilDisney();
		Platillo gatito = new Gatito();
		Platillo hotCakes = new HotCakesJr();
		
		disney.addItem(gatito);
		disney.addItem(hotCakes);
		kids.addItem(disney);
		
		
		Menu desayunos = new DesayunosAlmuerzos();
		
		Menu sandwiches = new Sandwiches();
		Platillo verona = new Verona();
		Platillo cincoQuesos = new CincoQuesos();
		sandwiches.addItem(verona);
		sandwiches.addItem(cincoQuesos);
		
		Menu huevos = new HuevosEspeciales();
		Platillo oaxaca = new Oaxaca();
		Platillo suizos = new Suizos();
		huevos.addItem(oaxaca);
		huevos.addItem(suizos);
		
		desayunos.addItem(sandwiches);
		desayunos.addItem(huevos);
		
		
		Menu comidas = new ComidasCenas();
		Menu carnes = new Carnes();
		Platillo asada = new CarneAsada();
		Platillo arrachera = new ArracheraVips();
		
		carnes.addItem(asada);
		carnes.addItem(arrachera);
		
		Menu delMar = new DelMar();
		Platillo camarones = new CamaronesEmpanizados();
		delMar.addItem(camarones);
		
		comidas.addItem(carnes);
		comidas.addItem(delMar);
		
		menu.addItem(kids);
		menu.addItem(desayunos);
		menu.addItem(comidas);
		
		new Client(menu);
	}

}
