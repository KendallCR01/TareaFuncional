package org.example;

import java.util.*;
import java.util.stream.Collectors;
class Pelicula
{
    private String titulo;
    private String director;
    private int estreno;

    public Pelicula(String titulo, String director, int estreno)
    {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getDirector()
    {
        return director;
    }

    public int getEstreno()
    {
        return estreno;
    }

    @Override
    public String toString()
    {
        return titulo + " (" + director + ", " + estreno + ")";
    }
}

class EjercicioSeccion3
{
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));
        System.out.println("  ");

        List<Pelicula> pelisEstreno = peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .collect(Collectors.toList());

        System.out.println("Películas estrenadas en el siglo XXI (a partir del año 2000, inclusive):");
        for(Pelicula p: pelisEstreno)
        {
            System.out.println(p);
        }

        System.out.println(" ");
        System.out.println("Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg");
        String pelis = peliculas.stream()
                .filter(p -> p.getDirector() == "Steven Spielberg")
                .map(p -> p.getTitulo())
                .collect(Collectors.joining(", ",
                        "películas de Steven Spielberg: ", ""));
        System.out.println(pelis);

        System.out.println("  ");
        System.out.println("Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente");


        List<Pelicula> pelisAlfabetico = peliculas.stream().sorted(Comparator.comparing(Pelicula::getTitulo))
                .collect(Collectors.toList());


        for(Pelicula p: pelisAlfabetico)
        {
            System.out.println(p);
        }

    }
}