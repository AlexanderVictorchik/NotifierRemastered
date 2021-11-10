package comparator;

import command.CommandService;
import tracker.TimeTrackerService;

import java.util.*;

public class CompareService {

    public static List<String> compare(List<String> listFromAccount, List<String> listFromCommand) {
        listFromAccount.retainAll(listFromCommand);
        listFromCommand.removeAll(listFromAccount);
        return listFromCommand;
    }

    public static void main(String[] args) {
        List<String> listOne = new ArrayList(Arrays.asList("hafil", "iga", "binga", "mike", "dingo"));
        List<String> listTwo = new ArrayList(Arrays.asList("hafil", "iga", "binga", "mike", "dingo", "neeta.peeta"));
        compare(listOne, listTwo);
        System.out.println(compare(listOne, listTwo));
    }
}