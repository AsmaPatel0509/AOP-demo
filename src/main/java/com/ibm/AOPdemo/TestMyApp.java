package com.ibm.AOPdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ibm.config.AppConfig;
import com.ibm.exception.NoteNotFoundException;
import com.ibm.service.NoteServiceImpl;

public class TestMyApp {

	public static void main(String[] args) throws NoteNotFoundException{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		NoteServiceImpl service= ctx.getBean(NoteServiceImpl.class);
		service.addNote();
//		service.deleteNote(1);
//		service.deleteNote(-1);
		service.checkNote();
	}
}
