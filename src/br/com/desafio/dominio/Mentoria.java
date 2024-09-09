package br.com.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    @Override
    public double calcularXp() {
        return XP_padrao + 20d;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }

}
