package MediaPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import App.FileChooser;
import java.io.IOException;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MediaPlayer
{

    private Player mediaPlayer;
    private String path;
    private int frame;
    private int musicLength;
    FileInputStream stream;

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public void tocar()
    {
        try
        {
            if (this.path == null || this.path.equals(""))
            {
                this.path = new FileChooser().escolherArquivo("Selecione a musica a ser tocada");
            }
            if (this.frame == 0)
            {
                this.stream = new FileInputStream(this.path);
                this.musicLength = this.stream.available();
                this.mediaPlayer = new Player(this.stream);
                this.mediaPlayer.play();
            }
            else
            {
                this.resume();
            }

        } catch (JavaLayerException e1)
        {
            JOptionPane.showMessageDialog(null, "Erro do player");
        } catch (FileNotFoundException e2)
        {
            JOptionPane.showMessageDialog(null, "Arquivo invalido");
        } catch (IOException e3)
        {
            JOptionPane.showMessageDialog(null, "Erro no stream");
        }
    }

    public void resume()
    {
        try
        {
            this.stream = new FileInputStream(this.path);
            if (this.frame > 0)
            {
                this.stream.skip(this.musicLength - this.frame);
            }
            this.mediaPlayer = new Player(this.stream);
            this.mediaPlayer.play(this.frame);
        } catch (FileNotFoundException e1)
        {
            JOptionPane.showMessageDialog(null, "Arquivo invalido");
        } catch (JavaLayerException e2)
        {
            JOptionPane.showMessageDialog(null, "Erro do player");
        } catch (IOException e3)
        {
            JOptionPane.showMessageDialog(null, "Erro no stream");
        }
    }

    public void pause()
    {
        try
        {
            this.frame = this.stream.available();
            this.mediaPlayer.close();
        } catch (IOException e1)
        {
            JOptionPane.showMessageDialog(null, "Erro no stream");
        }
    }

    public void stop()
    {
        this.mediaPlayer.close();
        this.frame = 0;
        this.path = "";
    }

    public Runnable createRunnable()
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                tocar();
            }
        };
        return runnable;
    }
}
