///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.bbagent;
//
//import org.objectweb.asm.ClassVisitor;
//import org.objectweb.asm.FieldVisitor;
//import org.objectweb.asm.Opcodes;
//import org.objectweb.asm.Type;
//
///**
// *
// * @author astha
// */
//public class AddFieldAdapter extends ClassVisitor {
//
//    private String fieldName;
//    private String fieldType;
//    private String fieldDefault;
//    private int access = org.objectweb.asm.Opcodes.ACC_PUBLIC;
//    private boolean isFieldPresent;
//
//    public AddFieldAdapter(
//            String fieldName, int fieldAccess, ClassVisitor cv) {
//        super(Opcodes.ASM4, cv);
//        this.cv = cv;
//        this.fieldName = fieldName;
//        this.access = fieldAccess;
//    }
//
//    @Override
//    public FieldVisitor visitField(
//            int access, String name, String desc, String signature, Object value) {
//        if (name.equals(fieldName)) {
//            isFieldPresent = true;
//        }
//        return cv.visitField(access, name, desc, signature, value);
//    }
//
//    @Override
//    public void visitEnd() {
//        if (!isFieldPresent) {
//            FieldVisitor fv = cv.visitField(
//                    access, fieldName, Type.BOOLEAN_TYPE.toString(), null, null);
//            if (fv != null) {
//                fv.visitEnd();
//            }
//        }
//        cv.visitEnd();
//    }
//}
