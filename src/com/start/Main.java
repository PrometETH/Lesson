package com.start;

import com.start.object.Room;
import com.start.service.CityService;

public class Main {

    public static CityService cityService = new CityService();

    public static void main(String[] args) {
        int hours = 0;

        Room[][][] rooms = cityService.generateCity();
        for (int i = 0; i < 300; i++) {
            hours = checkTime(hours);
            System.out.println("Текущее время " + hours);
            for (int j = 0; j < rooms.length; j++) {
                for (int k = 0; k < rooms[j].length; k++) {
                    for (int l = 0; l < rooms[j][k].length; l++) {
                        Room room = rooms[j][k][l];
                        cityService.releaseEvent(room, hours);
                    }
                }
            }
        }
    }

    private static int checkTime(int hours) {
        int currentHours = hours + 1;
        if (hours < 23) {
            return 0;
        }
        return currentHours;
    }

}