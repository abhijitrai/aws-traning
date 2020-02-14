package lab.aws;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.cloudwatch.model.*;

import java.util.ArrayList;

public class CreateMetrics {

    public static void main(String[] args) {


        AmazonCloudWatch amazonCloudWatch =
                AmazonCloudWatchClientBuilder.standard().withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("monitoring.us-east-2.amazonaws.com","us-east-2")).
                        build();

        PutMetricDataRequest putMetricDataRequest = new PutMetricDataRequest();
        putMetricDataRequest.setNamespace("AbhijitNamespace");

        MetricDatum metricDatum1 = new MetricDatum()
                                .withMetricName("MessageCount")
                            .withDimensions(new Dimension().withName("Personalization").withValue("123"));
        metricDatum1.setValue(-1.00);
        metricDatum1.setUnit(StandardUnit.Count);
        putMetricDataRequest.getMetricData().add(metricDatum1);

        PutMetricDataResult result = amazonCloudWatch.putMetricData(putMetricDataRequest);




    }
}
