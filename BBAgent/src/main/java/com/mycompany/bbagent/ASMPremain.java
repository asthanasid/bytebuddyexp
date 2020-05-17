/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bbagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 *
 * @author astha
 */
public class ASMPremain {
    public static void premain(String agentArgs, Instrumentation inst) {
//        inst.addTransformer(new ClassFileTransformer() {
//            @Override
//            public byte[] transform(
//              ClassLoader l,
//              String name,
//              Class c,
//                    ProtectionDomain d,
//              byte[] b)
//              throws IllegalClassFormatException {
//                if(name.equals("java/lang/Integer")) {
//                    CustomClassWriter cr = new CustomClassWriter();
//                    return cr.addField();
//                }
//                return b;
//            }
//        });
    }
}
