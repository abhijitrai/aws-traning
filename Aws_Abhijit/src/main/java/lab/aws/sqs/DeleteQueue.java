package lab.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public class DeleteQueue {
    static final String QUEUE_NAME = "abhijit-test-queue-1";
    static  final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

    public static void main(String[] args) {
        // Get the URL for a queue
        String queue_url = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();

        // Delete the Queue
        sqs.deleteQueue(queue_url);
        System.out.println("Queue deleted , name : " + QUEUE_NAME );
    }
}
