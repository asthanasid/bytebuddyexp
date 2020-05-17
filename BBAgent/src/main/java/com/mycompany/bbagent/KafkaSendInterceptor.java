/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bbagent;

import java.lang.reflect.Method;
import net.bytebuddy.implementation.bind.annotation.Origin;
//import net.bytebuddy.asm.Advice;
import org.slf4j.LoggerFactory;

/**
 *
 * @author astha
 */
public class KafkaSendInterceptor {

    public static void log(@Origin Method method) {
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        LoggerFactory.getLogger("test").info(method + " was called");

    }
//    public static void logthis() {
//        LoggerFactory.getLogger("test").info("--test");
//
//    }
//    public static void main(String[] args) {
//        KafkaSendInterceptor.logthis();
//    }
}
