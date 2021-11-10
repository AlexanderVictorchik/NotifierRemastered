package sendnotification;

import command.CommandService;
import comparator.CompareService;
import model.Report;
import sender.SenderService;
import tracker.TimeTrackerService;
import command.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static command.CommandService.getFieldsFromString;

public class Notifier {

    public static void main(String[] args) {
      /*  LocalTime sendTime = LocalTime.of(22, 32, 00);

        while (true) {
            if (LocalTime.now().equals(sendTime)) {
                sendReport();
            }
        }*/
        sendNotification();

    }

    private static void sendNotification() {
        List<String> allUsers = CommandService.getAllUsers();
//        System.out.println(allUsers);
//        String [] x = getFieldsFromString(allUsers.get(0));
//        System.out.println(x[0]);
//        System.out.println(x[1]);
//        System.out.println(x[2]);
//        System.out.println(x[3]);
//        System.out.println(x[4]);
//        System.out.println(x[5]);
        List<User> USERS = CommandService.getUSERS();
        System.out.println(USERS);

        List<String> comm = CommandService.getUsersForLeadIds();
        List<Report> acc = TimeTrackerService.trackUsersId();
        List<String> convertReport = new ArrayList<>();
        for (Report r: acc) {
            convertReport.add(String.valueOf(r.getUserId()));
        }

        List<String> differenceIdList = CompareService.compare(convertReport, comm);
        for (int i = 0; i < differenceIdList.size(); i++) {            ;
            SenderService.send(Long.valueOf(CommandService.getLeadByIdGroup(differenceIdList.get(i))), "User with ID: " + differenceIdList.get(i) +
                    " (Name: " + USERS.getName + " " + ")" +
                    " didnt send the report today!");
        }
        System.out.println(CommandService.getLeadByIdGroup("777"));


        }
    }
//        for (int i = 0; i < result.size(); i++) {
//            SenderService.send(430627864l,"User with ID: " + result.get(i) +
//                    " didnt send the report today!");
//        }
//






//        String textmessage = "User with ID: " + splitter[0] +
//                " (Name: " + splitter[2] + " " + splitter[3] +
//                ")" + " didnt send the report today!";






//        System.out.println(CommandService.getUserById("430627864"));
//        String usersId = String.valueOf(CommandService.getUsersByRole("user"));
//        String [] userssplit = getFieldsFromString(usersId);
//        System.out.println(userssplit[1]);
//        TimeTrackerService.track()
//        String [] splitter = getFieldsFromString(alex2);
//        String textmessage = "User with ID: " + splitter[0] + " (Name: " + splitter[2] + " " + splitter[3] + ")" + " didnt send the report today!";
//        System.out.println("User with ID: " + splitter[0] +
//                " (Name: " + splitter[2] + " " + splitter[3] + ")" +
//                " didnt send the report today!");
//
//        SenderService.send(Long.valueOf(splitter[0]),textmessage);



