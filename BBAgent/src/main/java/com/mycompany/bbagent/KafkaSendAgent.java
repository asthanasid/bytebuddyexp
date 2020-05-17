/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bbagent;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.matcher.ElementMatchers;

/**
 *
 * @author astha
 */
public class KafkaSendAgent {
    public static void premain(String args, Instrumentation inst) {
//    new AgentBuilder.Default()
//      .rebase(ElementMatchers.any())
//      .transform( builder -> return builder
//                              .method(ElementMatchers.isAnnotatedWith(Log.class))
//                              .intercept(MethodDelegation.to(LogInterceptor.class)
//                                  .andThen(SuperMethodCall.INSTANCE)) )
//      .installOn(inst);
  }
}
