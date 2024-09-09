package br.com.desafio.test;

import br.com.desafio.dominio.Bootcamp;
import br.com.desafio.dominio.Curso;
import br.com.desafio.dominio.Dev;
import br.com.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class DesafioTest01 {

    public static void main(String[] args) {

        Curso curso1 = criarCurso("Análise e Desenvolvimento De Sistemas.",
                "É uma área da tecnologia da informação que envolve o estudo, projeto, implementação e manutenção de sistemas computacionais.", 2400);

        Curso curso2 = criarCurso("Engenharia De Software.",
                "É uma área da computação que se dedica ao desenvolvimento, análise e manutenção de softwares, além da gestão de projetos e equipes.", 3300);

        Mentoria mentoria = criarMentoria("Mentoria de Java",
                "É um processo de acompanhamento e desenvolvimento de habilidades em POO");

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Java com Spring");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devGabriel = criarEInscreverDev("Gabriel Ventura", bootcamp);
        exibirProgressoDev(devGabriel, 3);

        System.out.println("-------------------------------------");

        Dev devGuilherme = criarEInscreverDev("Guilherme Araújo", bootcamp);
        exibirProgressoDev(devGuilherme, 1);
    }

    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    private static Mentoria criarMentoria(String titulo, String descricao) {
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(LocalDate.now());
        return mentoria;
    }

    private static Dev criarEInscreverDev(String nome, Bootcamp bootcamp) {
        Dev dev = new Dev();
        dev.setNome(nome);
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        return dev;
    }

    private static void exibirProgressoDev(Dev dev, int vezesProgresso) {
        for (int i = 0; i < vezesProgresso; i++) {
            dev.progredir();
        }
        System.out.println("---ATUALIZAÇÃO---");
        System.out.println("Conteúdos inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        System.out.println("Conteúdos concluídos " + dev.getNome() + ": " + dev.getConteudosConcluidos());
        System.out.println("XP: " + dev.calcularXP());
    }
}
