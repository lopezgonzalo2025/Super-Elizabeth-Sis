package entities;

import java.awt.Image;
import entorno.Entorno;
import java.util.Random;
import javax.imageio.ImageIO;

public class princesa 
	{
		private double x;
		private double y;
		private double angulo;
		private String ima;
		private Image im ;
		
		public princesa() 
		{
			Random gen = new Random();
			this.x =  gen.nextInt(300) + 1;
			this.y =  463;
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
			//entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.YELLOW);
			
		    entorno.dibujarImagen(this.im, this.x, this.y, this.angulo, 0.20);
		}
		
		
		public void mover() {
	         this.x = this.x + Math.cos(this.angulo)* 5;
	         this.y = this.y + Math.sin(this.angulo)* 5;                  
		}
		public void retroceder() {
	         this.x = this.x - Math.cos(this.angulo)* 5;
	         this.y = this.y - Math.sin(this.angulo)* 5;                 
		}
		public void saltar() {
	         this.x = this.x - Math.cos(this.angulo)* 5;
	         this.y = this.y - Math.sin(this.angulo)* 5;                 
		}
	
	
}

