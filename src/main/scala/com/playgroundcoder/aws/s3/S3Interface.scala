package com.playgroundcoder.aws.s3

import software.amazon.awssdk.auth.credentials.{AwsCredentialsProvider, AwsSessionCredentials, DefaultCredentialsProvider}
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.http.SdkHttpResponse
import software.amazon.awssdk.http.apache.ApacheHttpClient
import software.amazon.awssdk.services.s3.model.{HeadBucketRequest, HeadBucketResponse, NoSuchBucketException}
import software.amazon.awssdk.regions.Region


object S3Interface {

  /**
   * Return the AWS Credentials Provider
   * AWS Doc: https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
   * @param awsProfileName Optional AWS profile name to retrieve credentials for.
   * @return
   */
  def getCredentialsProvider(awsProfileName: String = ""): AwsCredentialsProvider = {
    val awsCredentialsProvider = if (awsProfileName == "") {
      DefaultCredentialsProvider.builder().build()
    } else {
      DefaultCredentialsProvider.builder().profileName(awsProfileName).build()
    }
    awsCredentialsProvider
  }

  /**
   *
   * @param awsRegion
   * @return
   */
  def generateS3Client(awsRegion: String): S3Client = {
    val awsCredentialsProvider = getCredentialsProvider()
    val httpClient = ApacheHttpClient.builder().build()

    val s3Client = S3Client.builder()
      .credentialsProvider(awsCredentialsProvider)
      .region(Region.of(awsRegion))
      .httpClient(httpClient)
      .build()
    s3Client
  }

  /**
   *
   * @param awsRegion
   * @param awsProfileName
   * @return
   */
  def generateS3Client(awsRegion: String, awsProfileName: String): S3Client = {
    val awsCredentialsProvider = getCredentialsProvider(awsProfileName)
    val httpClient = ApacheHttpClient.builder().build()

    val s3Client = S3Client.builder()
      .credentialsProvider(awsCredentialsProvider)
      .region(Region.of(awsRegion))
      .httpClient(httpClient)
      .build()
    s3Client
  }

  /**
   *
   * @param s3Client
   * @param bucketName
   * @return
   */
  def checkBucketExists(s3Client: S3Client, bucketName: String): Boolean = {
    val headBucketRequest = HeadBucketRequest.builder()
      .bucket(bucketName)
      .build()

    val bucketExists = try {
      s3Client.headBucket(headBucketRequest)
      true
    } catch {
      case e: NoSuchBucketException => false
      case e: Throwable => throw e
    }
    bucketExists
  }

  def checkObjectExists(s3Client: S3Client, bucketName: String, objectKey: String): Boolean = {
    false
  }

}