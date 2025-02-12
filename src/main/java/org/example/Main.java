package org.example;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.bson.conversions.Bson;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb://ravenclaw:27017/";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            Bson command = new BsonDocument("ping", new BsonInt64(1));

            MongoDatabase database = mongoClient.getDatabase("admin");
            Publisher<Document> MonoPublisher = database.runCommand(command);
            Mono.from(MonoPublisher)
                    .doOnSuccess(x -> System.out.println("Pinged your deployment. You successfully connected to MongoDB!"))
                    .doOnError(err -> System.out.println("Error: " + err.getMessage()))
                    .block();
            //other application code
        }
    }
}