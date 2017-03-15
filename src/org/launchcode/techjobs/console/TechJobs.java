package org.launchcode.techjobs.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by LaunchCode
 */
public class TechJobs {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Initialize our field map with key/name pairs
        HashMap<String, String> columnChoices = new HashMap<>();
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("name", "Name");
        columnChoices.put("all", "All");

        // Top-level menu options
        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        System.out.println("Welcome to LaunchCode's TechJobs App!");

        // Allow the user to search until they manually quit
        while (true) {

            String actionChoice = getUserSelection("View jobs by:", actionChoices);

            if (actionChoice.equals("list")) {

                String columnChoice = getUserSelection("List", columnChoices);

                if (columnChoice.equals("all")) {
                    printJobs(JobData.findAll());
                } else {

                    ArrayList<String> results = JobData.findAll(columnChoice);

                    System.out.println("\n*** All " + columnChoices.get(columnChoice) + " Values ***");

                    // Print list of skills, employers, etc
                    for (String item : results) {
                        System.out.println(item);
                    }
                }
            } else { // choice is "search"

                // How does the user want to search (e.g. by skill or employer)
                String searchField = getUserSelection("Search by:", columnChoices);

                // What is their search term?
                System.out.println("\nSearch term: ");
                String searchTerm = in.nextLine();
// use for search     (aValue.toLowerCase ().contains (value.toLowerCase ()))
                if (searchField.equals("all")) {

                    printJobs(JobData.findAll());
//                    System.out.println(("?"));
                } else {//this is the hash map
                    printJobs(JobData.findByColumnAndValue(searchField, searchTerm));
                }
            }
        }
    }

    // ﻿Returns the key of the selected item from the choices Dictionary
    private static String getUserSelection(String menuHeader, HashMap<String, String> choices) {
        Integer choiceIdx;
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];

        // Put the choices in an ordered structure so we can
        // associate an integer with each one
        Integer i = 0;
        for (String choiceKey : choices.keySet()) {
            choiceKeys[i] = choiceKey;
            i++;
        }
        do {
            System.out.println("\n" + menuHeader);
            // Print available choices
            for (Integer j = 0; j < choiceKeys.length; j++) {
                System.out.println("" + j + " - " + choices.get(choiceKeys[j]));
            }
            choiceIdx = in.nextInt();
            in.nextLine();

            // Validate user's input
            if (choiceIdx < 0 || choiceIdx >= choiceKeys.length) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }
        } while (!validChoice);
        return choiceKeys[choiceIdx];
    }
    // Print a list of jobs
    private static void printJobs(ArrayList<HashMap<String, String>> someJobs) {
//        arrayList is a collection
//        HashMap<String, String> columnChoices = new HashMap<>();
//        String columnChoice = findByValue("Wings", columnChoices);
        for (HashMap<String, String> job : someJobs ) {

            System.out.println("\n*******") ;
//            System.out.println(columnChoices.get(columnChoice) + job.get("position type"));
            System.out.println("Name: " + (job.get("name")));
                System.out.println("Employer: " + job.get("employer"));
            System.out.println("Location: " + job.get("location"));
                System.out.println("Core competency: " + job.get("core competency") );
            System.out.println("*******") ;




//            System.out.println("all");
                //        String search;
//                String[] search = new String[someJobs.size()];
//        do {
//            System.out.print("Search: ");
//            search = in.next();
//            if (!search.equals("")) {
//                System.out.print("");
//                String result = in.next();
//
//                in.nextLine();
//            }
//        }while (!search.equals(""));
//        System.out.println("\n search Result:");
//        for (HashMap.Entry<String, String> some : job.entrySet()) {
//                        System.out.println(some.getKey() + " (" + some.getValue() + ")");


//        for (someJobs){
//            System.out.println(search +  " (" + search + ")");

//        HashMap<String, String> map = new HashMap<String, String>();
//        String value = map.get("searchField");
//        for (columnChoice:
//       String.equals("");
//        for (String searchTerm : map.keySet()) {
//            searchKey[i] = searchTerm;
//            i++;
////        } key  HashMap (searchTerm); {
                //  System.out.println(("\n" + "pass" + ":" + searchTerm));
// each loop
// use for search
                //      (searchTerm.toLowerCase ().contains (value.toLowerCase ());
//find by value
            }
        }
    }


