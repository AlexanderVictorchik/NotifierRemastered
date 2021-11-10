package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandService {

    private static UserService getService() {
        UserService userService = new UserServiceImplementationService()
                .getPort(UserService.class);
        return userService;
    }


    public static List<User> getUSERS() {
        return getService().findAll();
    }

    public static String getUsernameById() {
        List<User> users = getService().findAll();

    }

    public static List<String> getAllUsers() {
        List<User> users = getService().findAll();
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            stringUsers.add(
                    u.getId() + "|"
                            + u.getUsername() + "|"
                            + u.getFirstName() + "|"
                            + u.getLastName() + "|"
                            + u.getRole() + "|"
                            + u.getGroup()
            );
        }

        return stringUsers;
    }


    public static List<String> getUsersByGroup(String group) {
        List<User> users = getService().findByGroup(group);
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            stringUsers.add(
                    u.getId() + "|"
                            + u.getUsername() + "|"
                            + u.getFirstName() + "|"
                            + u.getLastName() + "|"
                            + u.getRole() + "|"
                            + u.getGroup()
            );
        }

        return stringUsers;
    }

    public static List<String> getUsersByRole(String role) {
        List<User> users = getService().findByRole(role);
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            stringUsers.add(
                    u.getId() + "|");
        }

        return stringUsers;
    }

    public static List<String> getUsersByRoleAndGroup(String role, String group) {
        List<User> users = getService().findByRoleAndGroup(role, group);
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            stringUsers.add(
                    u.getId() + "|"
                            + u.getUsername() + "|"
                            + u.getFirstName() + "|"
                            + u.getLastName() + "|"
                            + u.getRole() + "|"
                            + u.getGroup()
            );
        }

        return stringUsers;
    }

    public static List<String> getNotAdminUsers() {
        List<User> users = getService().findAll();
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            if (u.getRole().equals("user") || u.getRole().equals("lead")) {
                stringUsers.add(
                        String.valueOf(u.getId())
                );
            }
        }

        return stringUsers;
    }

    public static List<String> getUsersForLeadIds() {
        List<User> users = getService().findAll();
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            if (u.getRole().equals("user")) {
                stringUsers.add(
                        String.valueOf(u.getId())
                );
            }
        }

        return stringUsers;
    }

    public static List<String> getUsersForLeadFull() {
        List<User> users = getService().findAll();
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            if (u.getRole().equals("user")) {
                stringUsers.add(
                        u.getId() + "|"
                                + u.getUsername() + "|"
                                + u.getFirstName() + "|"
                                + u.getLastName() + "|"
                                + u.getRole() + "|"
                                + u.getGroup()
                );
            }
        }

        return stringUsers;
    }

    public static List<String> getLeadUserByGroupName(String group) {
        List<User> users = getService().findAll();
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            if (u.getGroup().equals(group) & u.getRole().equals("lead")) {
                stringUsers.add(
                        u.getId() + "|"
                                + u.getUsername() + "|"
                                + u.getFirstName() + "|"
                                + u.getLastName() + "|"
                                + u.getRole() + "|"
                                + u.getGroup()
                );
            }
        }

        return stringUsers;
    }

    public static List<String> getLeadIdByGroupName(String group) {
        List<User> users = getService().findAll();
        List<String> stringUsers = new ArrayList<>();
        for (User u : users) {
            if (u.getGroup().equals(group) & u.getRole().equals("lead")) {
                stringUsers.add(
                        String.valueOf(u.getId())
                );
            }
        }

        return stringUsers;
    }

    public static String getUserById(String userId){
        User user = getService().findById(userId);
        String stringUser=user.getId() + "|"
                + user.getUsername() + "|"
                + user.getFirstName() + "|"
                + user.getLastName() + "|"
                + user.getRole() + "|"
                + user.getGroup();

        return stringUser;
    }


    public static String getLeadByIdGroup(String userId){
        User user = getService().findById(userId);
        String stringUser= user.getGroup();
   List<String> list = getUsersByRoleAndGroup("lead", stringUser);
   String s = list.get(0);
   String [] split = getFieldsFromString(s);
        return split[0];
    }

    public static String[] getFieldsFromString(String ingoing){
        String[] result = ingoing.split("\\|");
        return result;
    }
}
