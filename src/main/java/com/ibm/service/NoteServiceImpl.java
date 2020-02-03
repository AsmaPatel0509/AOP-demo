package com.ibm.service;

import org.springframework.stereotype.Service;

import com.ibm.exception.NoteNotFoundException;

@Service
public class NoteServiceImpl {

	public boolean addNote() {
		System.out.println("Adding Note Business Functionality");
		return false;
	}
	public void deleteNote(int noteId) throws NoteNotFoundException {
		if(noteId < 0) {
			System.out.println("Exception thrown");
			throw new NoteNotFoundException();
		}
		System.out.println("Deleted Note");
	}
	public boolean checkNote() {
		System.out.println("Checking");
		return true;
	}
}
