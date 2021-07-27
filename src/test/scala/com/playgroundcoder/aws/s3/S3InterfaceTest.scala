package com.playgroundcoder.aws.s3

import org.scalatest.propspec.AnyPropSpec

class S3InterfaceTest extends AnyPropSpec {
  val region = "us-east-1"

  property("checkBucketExists test") {
    val bucketName = "dichaela-storage-east"
    val s3Client = S3Interface.generateS3Client(region)
    val checkBucketExistsResponse = S3Interface.checkBucketExists(s3Client, bucketName)
    print(checkBucketExistsResponse)

  }
}