package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {

    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970, "nao sei");
        meuFilme.setDuracaoEmMinutos(180);
        System  .out.println("Duração do conteúdo: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());
        //meuFilme.somaDasAvaliacoes = 10;
        //meuFilme.totalDeAvaliacoes = 1;
        //System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("avatar", 2023, "nao sei");
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDaAna = new Filme("titanique", 1996, "nao sei");
        filmeDaAna.setDuracaoEmMinutos(300);
        filmeDaAna.avalia(8);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDaAna);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        System.out.println(lista.size());
        System.out.println("primeiro filme " + lista.get(0).getNome());
        System.out.println(lista);

        System.out.println("tostring do filme " + lista.get(0).toString());
        for (Titulo item: lista) {
            System.out.println(item);
            if (item instanceof Filme){
                Filme filme = (Filme) item;
                System.out.println("clacificação " + filme.getClassificacao());
            }
        }
    }
}
