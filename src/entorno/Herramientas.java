package entorno;

import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class Herramientas {
	/**
	 * Transforma un �ngulo de grados a radianes.
	 * @param grados El �ngulo a transformar, medido en grados.
	 * @return El valor del �ngulo medido en radianes.
	 */
	public static double radianes(double grados)
	{
		return (grados/360.0)*(2*Math.PI);
	}
	
	/**
	 * Transforma un �ngulo de radianes a grados
	 * @param radianes El �ngulo medido en radianes
	 * @return El �ngulo medido en grados
	 */
	public static double grados(double radianes)
	{
		return radianes*360/(2*Math.PI);
	}

	/**
	 * Levanta una imagen desde el archivo dado y devuelve un objeto de tipo Image con la misma.
	 * @param archivo Nombre de archivo que contiene la imagen
	 * @return Un objeto Image con la imagen cargada
	 */
	public static Image cargarImagen(String archivo) 
	{
		return new ImageIcon(ClassLoader.getSystemResource(archivo)).getImage();
		//return new ImageIcon(archivo).getImage();
	}
	
	/**
	 * Ejecuta el sonido almacenado en el archivo pasado como par�metro.
	 * @param file El archivo que contiene el sonido a ejecutar
	 */
	public static void play(String file)
	{
		cargarSonido(file).start();
	}

	/**
	 * Ejecuta en un ciclo el sonido almacenado en el archivo pasado como par�metro.
	 * @param file El archivo que contiene el sonido a ejecutar
	 */
	public static void loop(String file)
	{
		cargarSonido(file).loop(Clip.LOOP_CONTINUOUSLY);
	}

	/**
	 * Devuelve un objeto de tipo Clip que contiene el sonido (o m�sica) cargado 
	 * desde el archivo pasado como par�metro.
	 * 
	 * Para ejecutar una vez el un Clip se puede utilizar la funci�n start() de 
	 * este objeto. Por otro lado, para ejecutar el sonido en f�rma c�clica se
	 * puede utilizar la funci�n loop() de este objeto. La cual toma como 
	 * par�metro la cantidad de ejecuciones a realizar (para ciclar infinitamente
	 * usar loop(Clip.LOOP_CONTINUOUSLY)). 
	 * @param file El archivo que contiene el sonido a ejecutar
	 * @return Un objeto de tipo Clip con el sonido cargado.
	 */
	public static Clip cargarSonido(String file) {
		AudioInputStream audioIn;
        Clip clip = null;
		try 
		{
			//audioIn = AudioSystem.getAudioInputStream(new File(file));
			audioIn = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(file));			
			clip = AudioSystem.getClip();
	        clip.open(audioIn);     
		} 
		catch (Exception  e) {
			e.printStackTrace();
		}
		
		return clip;
	}
}
