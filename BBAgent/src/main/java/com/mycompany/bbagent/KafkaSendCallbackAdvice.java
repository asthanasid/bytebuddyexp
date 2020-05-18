/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bbagent;

import net.bytebuddy.asm.Advice;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.LoggerFactory;

/**
 *
 * @author astha
 */
public class KafkaSendCallbackAdvice {
    /**
     * From this  enter method we start the timer and pass that value to exit method and the we getting the time
     * speed for each method
     * @param record
     * @param cb
     */
    @Advice.OnMethodEnter
    public static long enter(
            @Advice.Argument(value = 0, readOnly = false) ProducerRecord record,
            @Advice.Argument(value = 1, readOnly = false) Callback cb) throws Exception {

        LoggerFactory.getLogger("Advice").info( "called + with callback"  );
        long start = System.currentTimeMillis();
        cb = new CustomCallback(cb);
        return start;
    }

    @Advice.OnMethodExit
    public static void exit(@Advice.Origin String method, @Advice.Enter long start) throws Exception {

        long end = System.currentTimeMillis();
        System.out.println(method + " took " + (end - start) + " milliseconds ");
        LoggerFactory.getLogger("Advice").info(method + "exited");
    }
    
}
