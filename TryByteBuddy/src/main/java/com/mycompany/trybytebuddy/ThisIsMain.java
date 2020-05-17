/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trybytebuddy;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 *
 * @author astha
 */
public class ThisIsMain {

    public static void main(String[] args) {
        Object ob = new ThisIsMain();
        System.out.println("obs: " + ob.toString());
        Foo ob2 = new Foo();
        System.out.println("foobs" + ob2.toString());
        System.out.println("foohello" + ob2.sayHelloFoo());
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ThisIsMain().startConsumer();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ThisIsMain().startProducer();
            }
        }).start();
    }

    private void startProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                Thread.sleep(500);
                kafkaProducer.send(new ProducerRecord("test", Integer.toString(i), "test message - " + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }
    }

    private void startConsumer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "test-group");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer(properties);
        List topics = new ArrayList();
        topics.add("test");
        kafkaConsumer.subscribe(topics);
        try {
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(10);
                records.forEach(record -> {
                    System.out.println("Record Key " + record.key());
                    System.out.println("Record value " + record.value());
                    System.out.println("Record partition " + record.partition());
                    System.out.println("Record offset " + record.offset());
                });
                // commits the offset of record to broker. 
                kafkaConsumer.commitAsync();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            kafkaConsumer.close();
        }
    }

//    @Override
//    public String toString(){
//        return "dfdfdfghahaha";
//    }
}
