package lab.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab.aws.util.ParseJson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ListenToQueue {
    static final String QUEUE_NAME = "abhijit-test-queue-2";
    public static void main(String[] args) throws IOException {

        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();
        String val ;
                ObjectMapper objectMapper = new ObjectMapper();
        while(true) {
            // receive messages from the queue
            List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
            for ( Message msg:messages
                 ) {
                System.out.println(msg);
                Map<String, Object> map
                        = objectMapper.readValue(msg.getBody(), new TypeReference<Map<String, Object>>() {
                });
                val = (String) map.get("Message");
                ParseJson.main(val ) ;
                sqs.deleteMessage(queueUrl, msg.getReceiptHandle());
                System.out.println("Deleted : " + msg);
            }
        }
    }
}
