package com.raczkowski.apps.model;

import java.io.*;
import java.util.ArrayList;

public class UsersDataController {
    final private File file = new File("Users.csv");

    public ArrayList<Users> usersReader() {
        ArrayList<Users> listOfReadedUsers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Users.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                Users user = createUser(attributes);
                listOfReadedUsers.add(user);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfReadedUsers;
    }

    private static Users createUser(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        String lastName = metadata[2];
        return new Users(id, name, lastName);
    }

    public void userWriter(ArrayList<Users> UsersList) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (Users user : UsersList) {
                String CSV_SEPARATOR = ",";
                String oneLine = (user.getId() +
                        CSV_SEPARATOR +
                        user.getName()
                        + CSV_SEPARATOR
                        + user.getLastName());
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
