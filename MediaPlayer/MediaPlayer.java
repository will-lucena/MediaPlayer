package MediaPlayer;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import App.FileChooser;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MediaPlayer 
{
	private Player mediaPlayer;
	
	public void tocar()
	{
		try
		{
			String str = new FileChooser().escolherArquivo("Selecione a musica a ser tocada");
			FileInputStream stream = new FileInputStream(str);
			mediaPlayer = new Player(stream);
			mediaPlayer.play();
		} catch (JavaLayerException e1)
		{
			
		} catch (FileNotFoundException e2)
		{
			e2.printStackTrace();
		}
	}
}
