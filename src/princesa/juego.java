package princesa;

import entities.princesa;
import entities.fondo;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class juego extends InterfaceJuego {
	private Entorno entorno;
	// Variables y metodos propios de cada grupo
	private princesa princesa = new princesa();
	private fondo fondo = new fondo();
	

	public juego() {
		// Inicializa el objeto entorno
		entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 3 - v1", 800, 600);
		princesa = new princesa();
		princesa.setIma("imagenes/princesa3.png");
		princesa.cargarImagen();
		
		fondo = new fondo();
		fondo.setIma("imagenes/fondoMario3b.png");
		fondo.cargarImagen();
		
		// Inicia el juego
		entorno.iniciar();
	}
	
	public void tick() {
		fondo.dibujarse(entorno);
		princesa.dibujarse(entorno);
		
        if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
        	princesa.setIma("imagenes/princesa3.png");
        	princesa.cargarImagen();
        	princesa.mover();
        	
        } else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
        	princesa.setIma("imagenes/princesa2.png");
        	princesa.cargarImagen();
        	princesa.retroceder();    
        	
        } else if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
        	princesa.setIma("imagenes/princesa3.png");
        	princesa.cargarImagen();
        	princesa.saltar();
        	
        } else if (entorno.estaPresionada(entorno.TECLA_ABAJO)) {
        	princesa.setIma("imagenes/princesa3.png");
        	princesa.cargarImagen();
        	//princesa.agacharse();        	
        }
        
	}

	public static void main(String[] args) {
		juego juego = new juego();
	}
}