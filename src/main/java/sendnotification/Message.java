package sendnotification;

import command.CommandService;
import command.User;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
public class Message {
    String text;

//    public Message() {
//        StringBuilder message = new StringBuilder();
//        List<User> students = CommandService.getUSERS();
//        for (User user : students) {
//            message.append("On date " + LocalDate.now() + "\n");
//            message.append("User with ID " + user.getId() + "\n");
//            message.append(user.getFirstName() + " " + user.getLastName() + "\n");
//            message.append("from " + user.getGroup() + " team" + "\n");
//            message.append("didn't send the report" + "\n");
//            message.append("==============================" + "\n");
//        }
//        {
//        }
//        this.text = message.toString();
//    }

}

