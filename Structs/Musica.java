package Structs;

public class Musica
{
    private String path;
    private String nome;
    
    public Musica(String path, String nome)
    {
        this.path = path;
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
}
