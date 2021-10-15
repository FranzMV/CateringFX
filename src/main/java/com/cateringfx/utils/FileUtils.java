package com.cateringfx.utils;

import com.cateringfx.model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    private static final String FILENAME_ALIMENTS = "aliments.txt";
    private static final String FILENAME_DISHES = "dishes.txt";
    private static final String SEPARATOR = ";";

    //to load the aliments and dishes stored in aliments.txt and dishes.txt.
    public static List<MenuElement> loadElements(){

        List<MenuElement> elements = new ArrayList<>();

        if(new File(FILENAME_ALIMENTS).exists() && new File(FILENAME_DISHES).exists()){

            try (Stream<String> streamAliments = Files.lines(Paths.get(FILENAME_ALIMENTS));
            Stream<String> streamDishes = Files.lines(Paths.get(FILENAME_DISHES));
            ){
                elements = streamAliments
                        .map(line -> new Aliment(
                                line.split(SEPARATOR)[0],
                                line.split(SEPARATOR)[1],
                                line.split(SEPARATOR)[2],
                                Boolean.parseBoolean(line.split(SEPARATOR)[3]),
                                Boolean.parseBoolean(line.split(SEPARATOR)[4]),
                                Boolean.parseBoolean(line.split(SEPARATOR)[5]),
                                Boolean.parseBoolean(line.split(SEPARATOR)[6]),
                                Double.parseDouble(line.split(SEPARATOR)[7]),
                                Double.parseDouble(line.split(SEPARATOR)[8]),
                                Double.parseDouble(line.split(SEPARATOR)[9])


                        )).collect(Collectors.toList());

                elements.addAll(streamDishes.map(line-> {
                    String[] parts = line.split(SEPARATOR);
                    Dish dish = new Dish(parts[0], parts[1]);
                    for (int i = 2; i< parts.length; i +=11){
                        dish.addIngredient(new Ingredient(Double.parseDouble(parts[i]),
                                new Aliment(parts[i +1], parts[i+2], parts[i+3],
                                        Boolean.parseBoolean(parts[i+4]),
                                        Boolean.parseBoolean(parts[i+5]),
                                        Boolean.parseBoolean(parts[i+6]),
                                        Boolean.parseBoolean(parts[i+7]),
                                        Double.parseDouble(parts[i+8]),
                                        Double.parseDouble(parts[i+9]),
                                        Double.parseDouble(parts[i+10]))));
                    }
                    return dish;
                }).collect(Collectors.toList()));

            }catch (FileNotFoundException e1){
                System.out.println("No se ha encontrado el fichero");
                e1.printStackTrace();
            }catch (IOException e2){
                System.out.println("Se ha producido un error.");
                e2.printStackTrace();
            }
        }
        return elements;
    }

    //to store a new Aliment defined in the application.
    public static void storeAliment(Aliment a){
        try(PrintWriter pw = new PrintWriter(new FileWriter(Paths.get(FILENAME_ALIMENTS).toAbsolutePath().toString(),
                true)))
        {
            pw.println(a);

        }catch(IOException e1){
            System.out.println("Error escribiendo");
            e1.printStackTrace();
        }

    }

    //to store a new Dish defined in the application.
    public static void storeDish(Dish d){
        try(PrintWriter pw = new PrintWriter(new FileWriter(Paths.get(FILENAME_DISHES).toAbsolutePath().toString(),
                true)))
        {
            pw.println(d);

        }catch(IOException e1){
            System.out.println("Error escribiendo");
            e1.printStackTrace();
        }
    }

    //to store a menu in the file called dateOfTheMenu.menu
    /*
        And the structure of the text file containing the menu(dateOfTheMenu.menu) will be:
        Date;aliments of dishes in the same format that before.
     */
    public static void storeMenu(Menu m){
        try(PrintWriter pw = new PrintWriter(
                new FileWriter(Paths.get(m.getDate().toString()).toAbsolutePath()+ ".menu.txt")))
        {
            pw.println(m);

        }catch(IOException e1){
            System.out.println("Error escribiendo");
            e1.printStackTrace();
        }
    }
}
