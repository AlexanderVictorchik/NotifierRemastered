package sendnotification;

import command.CommandService;
import comparator.CompareService;
import accountant.Report;
import sender.SenderService;
import accountant.TimeTrackerService;
import command.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Notifier {

    public static void main(String[] args) throws IOException {
        LocalTime sendTime = LocalTime.of(19, 30, 00);

        while (true) {
            if (LocalTime.now().equals(sendTime)) {
                sendNotification();
            }
        }

    }

    private static void sendNotification() throws IOException {
        List<String> comm = CommandService.getNotAdminUsers();
        List<Report> acc = TimeTrackerService.getTimingReport();
        List<String> convertReport = new ArrayList<>();
        for (Report r : acc) {
            convertReport.add(String.valueOf(r.getUserId()));
        }
        List<String> differenceIdList = CompareService.compare(convertReport, comm);
        for (int i = 0; i < differenceIdList.size(); i++) {
            SenderService.send(Long.valueOf(CommandService.getLeadByIdGroup(differenceIdList.get(i))),
                    "User with ID " + differenceIdList.get(i) + "\n" +
                            "Name : " + CommandService.getFirstNameById(differenceIdList.get(i)) + " "
                            + CommandService.getLastNameById(differenceIdList.get(i)) + "\n" +
                            "from " + CommandService.getGroupById(differenceIdList.get(i)) + " team" + "\n" +
                            "didn't send the report" + "\n" +
                            "on date " + LocalDate.now() + "\n" +
                            "==============================" + "\n");
        }
    }
}