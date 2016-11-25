package MediaPlayer;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MediaPlayer 
{
	private Player mediaPlayer;
	
	public void tocar()
	{
		try
		{
			String str = "";
			JFileChooser chooser = new JFileChooser();
		    if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
		    {
		       System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
		       str = chooser.getSelectedFile().getAbsolutePath();
		    }
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
