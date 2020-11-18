package com.start.service;

import com.start.object.Person;
import com.start.object.Room;

import java.util.Random;

public class CityService {

    private RoomService roomService = new RoomService();
    private Random random = new Random();

    public Room[][][] generateCity() {
        Room[][][] rooms = new Room[10][20][30];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                for (int k = 0; k < rooms[i][j].length; k++) {
                    rooms[i][j][k] = roomService.generateRoom();
                }
            }
        }
        return rooms;
    }

    public void releaseEvent(Room room, int hours) {
        int delivery = random.nextInt(100); //Процент захода
        int goOut = random.nextInt(100);
        if (goOut < 60 && hours == 8) {
            goOut(room);
        }
        if (hours == 18) {
            goIn(room);
        }
        if (delivery < 3 && (hours > 9 && hours < 19)) {
            delivery(room);
        }
    }

    /**
     * 20% шанс что ожидается посылка
     *
     * @param room
     */

    public void delivery(Room room) {
        if (room.getPersons().length > 0) {                      //Проверяем если в квартире есть жельцы
            for (int i = 0; i < room.getPersons().length; i++) {   // Проходим по всем жильцам
                if (room.getPersons()[i].isAtHome()) { // Проверяем что кто-то дома
                    if (room.getPersons()[i].getAge() > 14) {
                        System.out.println("Посылка доставлена " + room.getPersons()[i].getName()); // Доставляем посылку
                        return;
                    }
                }
            }
        }
    }

    public void goOut(Room room) {
        if (room.getPersons().length > 0) {                      //Проверяем если в квартире есть жельцы
            for (int i = 0; i < room.getPersons().length; i++) {   // Проходим по всем жильцам
                if (room.getPersons()[i].isAtHome()) { // Проверяем что кто-то дома
                    if (room.getPersons()[i].getAge() > 25) {
                        Person person = room.getPersons()[i];
                        person.setAtHome(false);
                        System.out.println(person.getName() + " ушел на работу");
                        return;
                    }
                }
            }
        }
    }

    public void goIn(Room room) {
        if (room.getPersons().length > 0) {                      //Проверяем если в квартире есть жельцы
            for (int i = 0; i < room.getPersons().length; i++) {   // Проходим по всем жильцам
                if (!room.getPersons()[i].isAtHome()) { // Проверяем что кто-то дома
                    Person person = room.getPersons()[i];
                    person.setAtHome(true);
                    System.out.println(person.getName() + " вырнулся с работы");
                    return;
                }
            }
        }
    }
}



