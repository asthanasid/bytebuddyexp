/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bbagent;

//import java.lang.instrument.Instrumentation;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.SuperMethodCall;
import static net.bytebuddy.matcher.ElementMatchers.*;
import net.bytebuddy.utility.JavaModule;

/**
 *
 * @author astha
 */
public class Agent {
    public static void premain(String arguments, Instrumentation instrumentation) {
        System.out.println("-------------------");
    new AgentBuilder.Default()
//        .type(named("com.mycompany.trybytebuddy.Foo"))
        .type(named("org.apache.kafka.clients.producer.KafkaProducer"))    
        .transform(new AgentBuilder.Transformer() {
      @Override
      public DynamicType.Builder transform(DynamicType.Builder builder,
                                              TypeDescription typeDescription,
                                              ClassLoader classloader,
                                              JavaModule jm) {
          System.out.println(")))))))))))))))" + typeDescription);
        return builder.method(named("toString"))
                      .intercept(FixedValue.value("transformeded"))
//                .method(named("sayHelloFoo"))
//                .intercept(FixedValue.value("transformededAnotherFoo"));
        .method(named("send"))        
        .intercept(MethodDelegation.to(KafkaSendInterceptor.class)
                                  .andThen(SuperMethodCall.INSTANCE)) ;
      }
    }).installOn(instrumentation);
  }
}
