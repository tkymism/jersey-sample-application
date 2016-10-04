package com.fujitsu.hope.labs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fujitsu.hope.labs.messages.Book;

class LibraryResource {
	private static final LibraryResource singleton = new LibraryResource();
	private Map<Integer, Book> bookmap = new HashMap<Integer, Book>();
	private LibraryResource(){ init(); }
	static LibraryResource getInstance(){ return singleton;}
	private void init() {
		for (int i=0; i<100; i++) this.bookmap.put(i,create(i));
	}
	private Book create(Integer id){
		return create(id, 
				String.format("hogehoge%1$03d", id), 
				String.format("fugafuga%1$03d", id));
	}
	private Book create(Integer id, String title, String auther){
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setAuthor(auther);
		return book;
	}
	Map<Integer, Book> asMap(){ return this.bookmap; }
	List<Book> asList(){
		return new ArrayList<Book>(this.asMap().values());
	}
}
