package sendnotification;

import command.CommandService;
import comparator.CompareService;
import model.Report;
import sender.SenderService;
import accountant.TimeTrackerService;
import command.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Notifier {

    public static void main(String[] args) throws IOException {
      /*  LocalTime sendTime = LocalTime.of(22, 32, 00);

        while (true) {
            if (LocalTime.now().equals(sendTime)) {
                sendReport();
            }
        }*/
        sendNotification();
    }

    private static void sendNotification() throws IOException {
        StringBuilder msg = new StringBuilder();
        List<String> comm = CommandService.getNotAdminUsers();
        List<Report> acc = TimeTrackerService.getTimingReport();
        List<String> convertReport = new ArrayList<>();
        for (Report r : acc) {
            convertReport.add(String.valueOf(r.getUserId()));
        }
        List<String> differenceIdList = CompareService.compare(convertReport, comm);
        System.out.println(differenceIdList);
        System.out.println(differenceIdList.get(0));
        System.out.println(CommandService.getGroupById(differenceIdList.get(0)));
        System.out.println(CommandService.getFirstNameById(differenceIdList.get(0)));
        System.out.println(CommandService.getLastNameById(differenceIdList.get(0)));
        System.out.println(CommandService.getLeadByIdGroup(differenceIdList.get(0)));
        for (String s : differenceIdList) {
            msg.append("On date " + LocalDate.now() + "\n");
            msg.append("User with ID " + s + "\n");
            msg.append("Name : " + CommandService.getFirstNameById(s) + " " + CommandService.getLastNameById(s) + "\n");
            msg.append("from " + CommandService.getGroupById(s) + " team" + "\n");
            msg.append("didn't send the report" + "\n");
            msg.append("==============================" + "\n");
            String leadId = CommandService.getLeadByIdGroup(s);
            if (leadId.length() != 0) {
                SenderService.send(Long.valueOf(leadId), String.valueOf(msg));
            }
        }
    }
}



