package com.start.service;

import com.start.object.Person;
import com.start.object.Room;

import java.util.Random;

public class RoomService {

    private PersonService personService = new PersonService();
    private Random random = new Random();


    /*
   Генерация комнат
   */
    public Room generateRoom() {
        int personCount = random.nextInt(5);
        Person[] person = new Person[personCount];
        for (int i = 0; i < person.length; i++) {
            person[i] = personService.generatePerson();
    }
           return new Room(person);
}

}
