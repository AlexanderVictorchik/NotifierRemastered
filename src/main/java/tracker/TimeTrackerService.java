package tracker;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import model.Report;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TimeTrackerService {

    public List<Report> getTimingReport() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet("http://localhost:8083/");

        System.out.println("Request Type: " + httpget.getMethod());

        HttpResponse httpresponse = httpclient.execute(httpget);

        ObjectMapper mapper = new ObjectMapper();
        String result = IOUtils.toString(httpresponse.getEntity().getContent(), StandardCharsets.UTF_8);

        List<Report> reports = Arrays.asList(mapper.readValue(result, Report[].class));
        return reports;
    }


    public static void main(String[] args) throws Exception {
        TimeTrackerService timeTrackerService = new TimeTrackerService();
//        List<Report> rep = timeTrackerService.getTimingReport();
//        for (int i = 0; i < rep.size(); i++) {
//            System.out.println(rep.get(i).getUserId());
//        }
    }

    @SneakyThrows
    public static List<Report> trackUsersId() {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet("http://localhost:8083/");

        System.out.println("Request Type: " + httpget.getMethod());

        HttpResponse httpresponse = httpclient.execute(httpget);

        ObjectMapper mapper = new ObjectMapper();
        String result = IOUtils.toString(httpresponse.getEntity().getContent(), StandardCharsets.UTF_8);

        List<Report> tracks = Arrays.asList(mapper.readValue(result, Report[].class));

        return tracks;
    }
}
