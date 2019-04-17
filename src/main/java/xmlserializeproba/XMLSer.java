package xmlserializeproba;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLSer {
    public static void main(String[] args) {

        List<Person> philispherDirector = new ArrayList<Person>();
        philispherDirector.add(new Person("Chris", "columbus"));
        List<Person> hpmaincast = new ArrayList<Person>();
        hpmaincast.add(new Person("Daniel", "Radcliffe"));
        hpmaincast.add(new Person("Rupert", "Grint"));
        hpmaincast.add(new Person("Emma", "Watson"));
        Movie philisiphers_stone = new Movie("Harry Potter and the Philisopher's Stone",
                2001, 146, 7.6,
                philispherDirector, hpmaincast, Genre.Fantasy, 81);

        Movie chamber = new Movie("Harry Potter and the Chamber of Secrets",
                2002, 155, 7.4,
                philispherDirector, hpmaincast, Genre.Fantasy, 82);
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(philisiphers_stone);
        movies.add(chamber);
        MovieSaga harryPotter = new MovieSaga(movies);
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("saga.xml")));

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
        encoder.writeObject(harryPotter)
        ;
        encoder.close();


        XMLDecoder decoder = null;
    try{
        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("saga.xml")));
    }catch (FileNotFoundException e){
        System.out.println("error");
    }
    MovieSaga deserialized = (MovieSaga) decoder.readObject();
        System.out.printf(deserialized.toString());
       // System.out.println(deserialized);
}}


