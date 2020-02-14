package lab.aws.sqs;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueResult;

public class CreateQueue {
    static final String QUEUE_NAME = "abhijit-test-queue-1";
    static  final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
    public static void main(String... args) {


        try {
            CreateQueueResult create_result = sqs.createQueue(QUEUE_NAME);
            System.out.println("Queue creation successful , name : " + QUEUE_NAME);
        } catch (AmazonSQSException e) {
            if (!e.getErrorCode().equals("QueueAlreadyExists")) {
                System.out.println("Queue exists ");
                throw e;
            }
        }

    }

}
