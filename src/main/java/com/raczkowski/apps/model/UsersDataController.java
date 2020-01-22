package com.raczkowski.apps.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsersDataController {
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
        return new Users(id, name);
    }

    public void userWriter(ArrayList<Users> UsersList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Users.csv"), "UTF-8"));
            for (Users user : UsersList) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(user.getId());
                String CSV_SEPARATOR = ",";
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(user.getName());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ignored) {
        }
    }
}
