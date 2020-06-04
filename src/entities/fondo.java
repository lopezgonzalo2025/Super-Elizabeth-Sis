package entities;

import java.awt.Image;
import entorno.Entorno;
import java.util.Random;
import javax.imageio.ImageIO;

public class fondo {
		private double x;
		private double y;
		private double angulo;
		private String ima;
		private Image im ;
		
		public fondo() {
			Random gen = new Random();
			this.x =  400;
			this.y =  300;
			this.angulo = 0;
		}
		
		public void cargarImagen(){
			try {
			im = ImageIO.read(getClass().getClassLoader().getResource(ima));
			}
			catch(Exception e){
				System.out.println("error en lectura de imagen");
			}
		}
		
		public String getIma() {
			return ima;
		}

		public void setIma(String ima) {
			this.ima = ima;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}

		public double getAngulo() {
			return angulo;
		}

		public void setAngulo(double angulo) {
			this.angulo = angulo;
		}

		public void dibujarse(Entorno entorno)
		{
		    entorno.dibujarImagen(this.im, this.x, this.y, this.angulo);
		}
}

