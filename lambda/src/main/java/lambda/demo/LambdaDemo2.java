package lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.s3.model.S3Event;

public class LambdaDemo2 {
        public String myHandler(Object name, Context context) {
            System.out.println( "Resource Called");
            String json = "{ " +
                    "    'statusCode': 200," +
                    "    'body': \"Hello from Java\""  +
                    "}";
            System.out.println("Return value :" + json);
            return "Hi" ;
        }

}
