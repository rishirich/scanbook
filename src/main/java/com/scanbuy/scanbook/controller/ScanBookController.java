package com.scanbuy.scanbook.controller;

import com.scanbuy.scanbook.beans.Book;
import com.scanbuy.scanbook.beans.Filter;
import com.scanbuy.scanbook.constants.FilterType;
import com.scanbuy.scanbook.constants.ScanBookConstants;
import com.scanbuy.scanbook.service.BookService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class ScanBookController {

	@Autowired
	private BookService bookService;

	@CrossOrigin(
			origins = "*",
			allowedHeaders = "*",
			methods = {RequestMethod.GET}
	)
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> fetchBooks() {
		return bookService.getBooks();
	}

	@CrossOrigin(
			origins = "*",
			allowedHeaders = "*",
			methods = {RequestMethod.GET}
	)
	@GetMapping(value = "/id/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> fetchBookById(@PathVariable Long barcode) {
		Filter barcodeFilter = new Filter(ScanBookConstants.BARCODE,String.valueOf(barcode),FilterType.EQUALS);
		return bookService.getBook(barcodeFilter);
	}

	@CrossOrigin(
			origins = "*",
			allowedHeaders = "*",
			methods = {RequestMethod.GET}
	)
	@GetMapping(value = "/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> fetchBookByTitle(@PathVariable String title) {
		Filter titleFilter = new Filter(ScanBookConstants.TITLE,title,FilterType.LIKE);
		return bookService.getBook(titleFilter);
	}

	@CrossOrigin(
			origins = "*",
			allowedHeaders = "*",
			methods = {RequestMethod.GET}
	)
	@GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> fetchBookByAuthor(@PathVariable String author) {
		Filter authorFilter = new Filter(ScanBookConstants.AUTHORS,author,FilterType.LIKE);
		return bookService.getBook(authorFilter);
	}

	@CrossOrigin(
			origins = "*",
			allowedHeaders = "*",
			methods = {RequestMethod.POST}
	)
	@PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> addBook(@NotNull @RequestParam Book book) {
		return bookService.addBook(book);
	}

	@CrossOrigin(
			origins = "*",
			allowedHeaders = "*",
			methods = {RequestMethod.POST}
	)
	@DeleteMapping(value = "/id/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> deleteBook(@NotNull @RequestParam Book book) {
		return bookService.deleteBook(book);
	}
}