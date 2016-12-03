package DataBase;

import Exceptions.BancoVazioException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class SongsManager
{
    private final String baseMusicas;

    public SongsManager()
    {
        this.baseMusicas = "baseMusicas.txt";
    }

    public boolean gerarDataBase()
    {
        try (FileWriter file = new FileWriter(baseMusicas);
            PrintWriter escrever = new PrintWriter(file);)
        {
            String registro = DataBaseSongsSingleton.getInstance().gerarRegistro();
            String[] registros = registro.split("\n");
            for (String str : registros)
            {
                escrever.println(str);
            }
            return true;
        } catch (IOException e1)
        {
            JOptionPane.showMessageDialog(null, "Erro no arquivo de musicas");
            return false;
        } catch (BancoVazioException e2)
        {
            JOptionPane.showMessageDialog(null, "Banco de musicas vazio");
            return false;
        }
    }

    public boolean carregarDataBase()
    {
        try (FileReader file = new FileReader(baseMusicas);
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
        } catch (IOException e1)
        {
            JOptionPane.showMessageDialog(null, "Erro no arquivo de musicas");
            return false;
        }
    }
}
