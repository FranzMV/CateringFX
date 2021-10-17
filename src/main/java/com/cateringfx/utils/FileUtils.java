package com.cateringfx.utils;

import com.cateringfx.model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * It is in charge of managing all the Input/Output corresponding to the writing and reading of text files.
 * @author Francisco David Manzanedo Valle.
 * @version 1.0
 */
public class FileUtils {

    /**Name corresponding to the aliments text file.*/
    private static final String FILENAME_ALIMENTS = "aliments.txt";
    /**Name corresponding to the dishes text file.*/
    private static final String FILENAME_DISHES = "dishes.txt";
    /**The separator to use when reading all lines of text .*/
    private static final String SEPARATOR = ";";

    /**
     * Load the aliments and dishes stored in {@link FileUtils#FILENAME_ALIMENTS} and {@link FileUtils#FILENAME_DISHES}.
     * @return A list of aliments and dishes.
     * @see MenuElement
     * @see Aliment
     * @see Dish
     * @see List
     */
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
                System.out.println("File not found.");
                e1.printStackTrace();
            }catch (IOException e2){
                System.out.println("An error has occurred.");
                e2.printStackTrace();
            }
        }
        return elements;
    }


    /**
     * Save a new Aliment defined in the application.
     * @param a The Aliment to be saved.
     * @see Aliment
     */
    public static void storeAliment(Aliment a){
        try(PrintWriter pw = new PrintWriter(
                new FileWriter(
                        Paths.get(FILENAME_ALIMENTS).toAbsolutePath().toString(),
                        true)))
        {
            pw.println(a);

        }catch(IOException e1){
            System.out.println("An error occurred while write the Aliment.");
            e1.printStackTrace();
        }

    }


    /**
     *Save a new Dish defined in the application.
     * @param d The Dish to be saved.
     * @see Dish
     */
    public static void storeDish(Dish d){
        try(PrintWriter pw = new PrintWriter(
                new FileWriter(
                        Paths.get(FILENAME_DISHES).toAbsolutePath().toString(),
                        true)))
        {
            pw.println(d);

        }catch(IOException e1){
            System.out.println("An error occurred while write the Dish.");
            e1.printStackTrace();
        }
    }

    /**
     * Save a new Menu defined in the application.
     * @param m The Menu to be saved.
     * @see Menu
     */
    public static void storeMenu(Menu m){
        final String MENU_FILENAME = m.getDate()+".menu.txt";
        try(PrintWriter pw = new PrintWriter(
                new FileWriter(
                        Paths.get(MENU_FILENAME).toAbsolutePath().toString(),
                        true)))
        {
            pw.println(m);

        }catch(IOException e1){
            System.out.println("An error occurred while write the Menu.");
            e1.printStackTrace();
        }
    }
}
