package princesa;

import entorno.Entorno;
import entorno.InterfaceJuego;
import objetos.fondo;
import objetos.fuego;
import objetos.princesa;

public class juego extends InterfaceJuego {
	private Entorno entorno;
	// Variables y metodos propios de cada grupo
	private princesa princesa = new princesa();
	private fondo fondo = new fondo();
	private fuego fuego = new fuego();
	
	boolean disparar = false;
	boolean avanzar= false;
	public juego() {
		// Inicializa el objeto entorno
		entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 3 - v1", 800, 600);
		
		princesa = new princesa();
		princesa.setIma("imagenes/princesa3.png");
		princesa.cargarImagen();
		
		fondo = new fondo();
		fondo.setIma("imagenes/fondoMario3b.png");
		fondo.cargarImagen();
		
		fuego = new fuego();
		fuego.setIma("imagenes/fuego2.png");
		fuego.cargarImagen();
		
		// Inicia el juego
		entorno.iniciar();
	}
	
	public void tick() {
		entorno.escribirTexto("VIDAS: ", 50, 50);
		entorno.escribirTexto("PUNTOS: " , 650, 50);
		
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
        }  else if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) { 	
        	disparar = true;
        }  else {
        	princesa.setIma("imagenes/princesa3.png");
        	princesa.cargarImagen();        	
        }        
        if (disparar) {
        	if (!avanzar) {
            	int posY = ((int) princesa.getY() - 30);
            	int posX = ((int) princesa.getX() + 30);
            	fuego.dibujarse(entorno, posX, posY);
        	} 
        	else {
            	int posY = (int) fuego.getY();
            	int posX = (int) fuego.getX();
            	fuego.dibujarse(entorno, posX, posY);
        	}
        	avanzar = true;
        }
        if(avanzar) {
        	fuego.avanzar();
        	if (fuego.getX() > 700) {
        		avanzar = false;
        		disparar = false;
        	}
        }
	}

	public static void main(String[] args) {
		juego juego = new juego();
	}
}