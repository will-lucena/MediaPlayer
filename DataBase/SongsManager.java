package DataBase;

import Exceptions.BancoVazioException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SongsManager
{
    private String path;
    
    public SongsManager(String path)
    {
        this.path = path;
    }
    
    public boolean gerarDataBase()
    {
        try (FileWriter file = new FileWriter(path);
                PrintWriter escrever = new PrintWriter(file);)
        {
            String registro = DataBaseSongsSingleton.getInstance().gerarRegistro();
            String[] registros = registro.split("\n");
            for (String str : registros)
            {
                escrever.println(str);
            }
            return true;
        } catch (IOException | BancoVazioException e)
        {
            return false;
        }
    }
    
    public boolean carregarDataBase()
    {
        try (FileReader file = new FileReader(path);
                BufferedReader buffer = new BufferedReader(file);)
        {
            DataBaseSongsSingleton.getInstance();
            String linha = buffer.readLine();
            
            while (linha != null && !linha.equals(""))
            {
                DataBaseSongsSingleton.getInstance().inserir(linha);
                linha = buffer.readLine();
            }
            return true;
        } catch (IOException ex)
        {
            return false;
        }
    }
}
