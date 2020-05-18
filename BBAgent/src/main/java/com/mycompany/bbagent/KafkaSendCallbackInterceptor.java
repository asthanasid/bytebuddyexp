/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bbagent;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.LoggerFactory;

/**
 *
 * @author astha
 */
public class KafkaSendCallbackInterceptor {
    
//    public static Future<RecordMetadata> log( @SuperCall Callable<Future<RecordMetadata>> cl) {
//        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
//        LoggerFactory.getLogger("test").info(" called in was called");
//        try {
//            return cl.call();
//        } catch (Exception ex) {
//            Logger.getLogger(KafkaSendCallbackInterceptor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//
//    }
    
    public static Future<RecordMetadata> log( 
            ProducerRecord rd , 
            Callback cb, @Super KafkaProducer kp) {
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        LoggerFactory.getLogger("test").info(" called in was called");
        try {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(KafkaSendCallbackInterceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
//    public static Future<RecordMetadata> log(  ProducerRecord rd , 
//            Callback cb ) {
//        System.out.println("SSSSSSS");
//        LoggerFactory.getLogger("Super---Call-----").info("Calling super");
////        CustomCallback ccb = new CustomCallback(cb);
////        try {
////            return (Future < RecordMetadata >)kp.send(rd , ccb);
////        } catch (Throwable ex) {
////            Logger.getLogger(KafkaSendCallbackInterceptor.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        return new Future<RecordMetadata>(){
//            @Override
//            public boolean cancel(boolean mayInterruptIfRunning) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public boolean isCancelled() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public boolean isDone() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public RecordMetadata get() throws InterruptedException, ExecutionException {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public RecordMetadata get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//                
//            };
//
//    }
    
//    public static Future<RecordMetadata> log(  ProducerRecord rd , 
//            Callback cb , @Super(constructorParameters={java.util.Properties.class}) KafkaProducer kp) {
//        System.out.println("SSSSSSS");
//        LoggerFactory.getLogger("Super---Call-----").info("Calling super");
//        CustomCallback ccb = new CustomCallback(cb);
//        try {
//            return (Future < RecordMetadata >)kp.send(rd , ccb);
//        } catch (Throwable ex) {
//            Logger.getLogger(KafkaSendCallbackInterceptor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//
//    }
    
    
    
    
    
    public static class CustomCallback implements Callback{
        
        Callback cb = null;
        public CustomCallback(Callback c){
            this.cb = c;
        }

        @Override
        public void onCompletion(RecordMetadata rm, Exception excptn) {
            LoggerFactory.getLogger("Super---Call-----Done").info("Calling super done");
            cb.onCompletion(rm, excptn);
        }
    }
}
