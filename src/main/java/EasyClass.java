import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by alynch on 1/18/2016 AD.
 */
public class EasyClass {
    public static void main(String[] args) throws InterruptedException {
        Vector<Long> v = new Vector<Long>();
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        long l2 = System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    long l = System.currentTimeMillis();
                    String text = getText("http://localhost:8080/api/hotel/920363/reviews/score?travelerTypeId=1&providerIds=332");
//                    String text = getText("http://localhost:8080/api/hotel/920363/reviews/comment?travelerTypeId=1&providerIds=332");
                    long e = System.currentTimeMillis();
                    v.add(e - l);
                    return text;
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.MINUTES);
        System.out.println("Total time " + (System.currentTimeMillis() - l2));
        for (Long o : v) {
//            System.out.println(o);
        }

        DescriptiveStatistics stats = new DescriptiveStatistics();

// Add the data from the array
        for (Long aV : v) {
            stats.addValue(aV);
        }

// Compute some statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        double median = stats.getPercentile(50);
        double m75 = stats.getPercentile(75);
        double m95 = stats.getPercentile(95);
//        double m95 = stats.getPercentile(95);
        System.out.println("mean = " + stats.getMean());
        System.out.println("median = " + median);
        System.out.println("m75 = " + m75);
        System.out.println("m95 = " + m95);
    }

    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        return response.toString();
    }
}
