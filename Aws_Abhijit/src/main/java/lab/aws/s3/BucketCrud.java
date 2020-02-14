package lab.aws.s3;

import java.io.IOException;

public class BucketCrud {

    public static void main(String[] args) throws IOException {
        CreateBucket.main();
        UploadObject.main();
        DeleteBucket.main();

    }
}
