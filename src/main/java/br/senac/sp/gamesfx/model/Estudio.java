package br.senac.sp.gamesfx.model;

public class Estudio {

    private int id;
    private String nome_estudio;
    private String nome_fundador;
    private int ano_fundacao;
    private String pais_origem;

    public Estudio(int id, String nome_estudio, String nome_fundador, int ano_fundacao, String pais_origem) {
        this.id = id;
        this.nome_estudio = nome_estudio;
        this.nome_fundador = nome_fundador;
        this.ano_fundacao = ano_fundacao;
        this.pais_origem = pais_origem;
    }

    // Construtor Default/Padrão
    public Estudio()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome_estudio()
    {
        return nome_estudio;
    }

    public void setNome_Estudio(String nome_estudio)
    {
        this.nome_estudio = nome_estudio;
    }

    public String getNome_fundador()
    {
        return nome_fundador;
    }

    public void setNome_fundador(String nome_fundador)
    {
        this.nome_fundador = nome_fundador;
    }

    public int getAno_fundacao()
    {
        return ano_fundacao;
    }

    public void setAno_fundacao(String ano_fundacao)
    {
        this.ano_fundacao = Integer.parseInt(ano_fundacao);
    }

    public String getPais_origem()
    {
        return pais_origem;
    }

    public void setPais_origem(String pais_origem)
    {
        this.pais_origem = pais_origem;
    }

    @Override
    public String toString() {
        return "Estudio{" +
                "id= " + id +
                ", nome_estudio= " + nome_estudio + '\'' +
                ", nome_fundador= " + nome_fundador + '\'' +
                ", ano_fundacao= " + ano_fundacao + '\'' +
                ", pais_origem= " + pais_origem + '\'' +
                '}';
    }
}
