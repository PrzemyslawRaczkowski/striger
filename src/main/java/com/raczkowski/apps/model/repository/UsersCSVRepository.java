package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.TemporaryUser;
import com.raczkowski.apps.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersCSVRepository implements UsersRepository {

    final private File file;

    public UsersCSVRepository(String filename) {
        this.file = new File(filename);
    }

    @Override
    public void addUser(TemporaryUser user) {
        userWriter(user);
    }

    @Override
    public List<User> loadUsers() {
        return usersReader();
    }

    private ArrayList<User> usersReader() {
        ArrayList<User> listOfReadedUsers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                User user = createUser(attributes);
                listOfReadedUsers.add(user);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return listOfReadedUsers;
    }

    private static User createUser(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        String lastName = metadata[2];
        String eMail = metadata[3];
        String password = metadata[4];
        return new User(id, name, lastName, eMail, password);
    }

    private void userWriter(TemporaryUser user) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String CSV_SEPARATOR = ",";
            String oneLine = (usersReader().size() + 1 +
                    CSV_SEPARATOR +
                    user.getName()
                    + CSV_SEPARATOR
                    + user.getLastName()
                    + CSV_SEPARATOR
                    + user.geteMail()
                    + CSV_SEPARATOR
                    + user.getPassword()
            );
            bw.write(oneLine);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
