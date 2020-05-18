/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bbagent;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.LoggerFactory;

/**
 *
 * @author astha
 */
public class CustomCallback implements Callback {

    Callback orig = null;

    public CustomCallback(Callback cb) {
        orig = cb;
    }

    @Override
    public void onCompletion(RecordMetadata rm, Exception excptn) {
        LoggerFactory.getLogger("Super---Call-----Done").info("Calling super done");
        orig.onCompletion(rm, excptn);
    }

}
