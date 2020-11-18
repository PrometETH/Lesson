package com.start.service;

import com.start.object.Person;

import java.util.Random;

public class PersonService {

    private String[] womanNames = {"Ulya", "Olya", "Mary"};
    private String[] manNames = {"Jack", "Alexander", "Michael"};
    private Random random = new Random();

    /*
    Метод генирирует жильца
    * */

    public Person generatePerson() {
        boolean male = random.nextBoolean();
        int age = random.nextInt(80);
    return new Person(male, getName(male), age);

    }
/*
    Метод генинрирует имя (женское или мужское )
 */
    private String getName(boolean mail) {
        if (mail) {
            int randomArrayPosition = random.nextInt(womanNames.length - 1);
            return manNames[randomArrayPosition];
        } else {
            int randomArrayPosition = random.nextInt(manNames.length - 1);
            return womanNames[randomArrayPosition];
        }
    }

}
