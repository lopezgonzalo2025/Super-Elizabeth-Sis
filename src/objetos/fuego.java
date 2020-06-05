package objetos;

import java.awt.Image;

import entorno.Entorno;
import javax.imageio.ImageIO;

public class fuego {
		private String ima;
		private Image im ;
		private double x;
		private double y;
		private double velocidad;
		
		public fuego() {
			this.x = 0;
			this.y = 0;
			this.velocidad = 9;
		}
		
		public void cargarImagen(){
			try {
			im = ImageIO.read(getClass().getClassLoader().getResource(ima));
			}
			catch(Exception e){
				System.out.println("error en lectura de imagen");
			}
		}

		public void dibujarse(Entorno entorno, int posX, int posY)
		{
			this.x = posX;
			this.y = posY;
			entorno.dibujarImagen(this.im, this.x, this.y, 0);
		}
		
		public void avanzar() {
			if (x < 700) {
				this.x+= this.velocidad*1/2;
			}
		}
		
		public String getIma() {
			return ima;
		}

		public void setIma(String ima) {
			this.ima = ima;
		}
		
		public double getX() {
			return this.x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return this.y;
		}
		public void setY(double y) {
			this.y = y;
		}
}

