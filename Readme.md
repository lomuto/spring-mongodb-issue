## Before Start

To start the project, only one step needed,
- Update `MONGO_URL` in [MongoConfig](./src/main/java/com/lomuto/query/example/demo/MongoConfig.java)   

No need to create collection for test. See [initMongoTemplate](./src/main/java/com/lomuto/query/example/demo/DemoApplication.java)   
  
## Start

After start project with

``` shell
./gradlew bootRun
```

Request to `/test` with `GET` method as   
```shell
curl localhost:8080/test
```
   
## Issue
   
You can witness SpringBoot log with   
``` text
 find using query: { "_id" : { "$oid" : ${randomObjectId}}}} fields: Document{{name=1, _id=1}} for class: class com.lomuto.query.example.demo.User in collection: user
```   
   
And there is no information for `Sort`
