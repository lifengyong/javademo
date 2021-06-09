package com.neu.minio.demo;/*
 * MinIO Java SDK for Amazon S3 Compatible Cloud Storage, (C) 2015 MinIO, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static java.nio.file.StandardOpenOption.*;

import io.minio.MinioClient;
import io.minio.ServerSideEncryption;
import io.minio.ServerSideEncryptionCustomerKey;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.nio.file.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;

public class UploadObject {
  /** MinioClient.putObject() example. */
  public static void main(String[] args)
      throws IOException, NoSuchAlgorithmException, InvalidKeyException {
    try {
      /* play.min.io for test and development. */
      MinioClient minioClient =
          MinioClient.builder()
              .endpoint("http://172.16.16.175:9000")
              .credentials("minioadmin", "minioadmin")
              .build();

      /* Amazon S3: */
      // MinioClient minioClient =
      //     MinioClient.builder()
      //         .endpoint("https://s3.amazonaws.com")
      //         .credentials("YOUR-ACCESSKEY", "YOUR-SECRETACCESSKEY")
      //         .build();

      {
        // Upload 'my-filename' as object 'my-objectname' in 'my-bucketname'.
        minioClient.uploadObject(
            UploadObjectArgs.builder()
                .bucket("picture")
                .object("my-123-321.jpg")
                .filename("D:\\picture\\11_H.jpg")
                .build());
        System.out.println("my-filename is uploaded to my-objectname successfully");
      }

//      {
//        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//        keyGen.init(256);
//        ServerSideEncryptionCustomerKey ssec =
//            ServerSideEncryption.withCustomerKey(keyGen.generateKey());
//
//        // Upload 'my-filename' as object encrypted 'my-objectname' in 'my-bucketname'.
//        minioClient.uploadObject(
//            UploadObjectArgs.builder()
//                .bucket("my-bucketname")
//                .object("my-objectname")
//                .filename("my-filename")
//                .sse(ssec)
//                .build());
//        System.out.println("my-filename is uploaded to my-objectname successfully");
//      }
    } catch (MinioException e) {
      System.out.println("Error occurred: " + e);
    }
  }
}
