package sender;

public class SenderService {
    public  static void send(Long id,String message)
    {
        TimeTrackingSenderServiceImpl trackingSenderService =
                new TimeTrackingSenderServiceImplService()
                        .getPort(TimeTrackingSenderServiceImpl.class);


        trackingSenderService.sendMessage(id, message);

    }




}
