package lambda.demo;

import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.model.S3Event;
import com.amazonaws.services.lambda.runtime.Context;
public class LambdaDemo1 {
        public String myHandler(S3EventNotification notification, Context context) {
            try {
                for (S3EventNotification.S3EventNotificationRecord record : notification.getRecords()) {
                    System.out.println(record.getEventSource());
                    System.out.println(record.getEventName());
                    System.out.println(record.getS3().getBucket().getName());
                    System.out.println(record.getS3().getObject().getKey());
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return "Success" ;
        }

}
