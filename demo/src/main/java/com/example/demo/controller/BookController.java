package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.entity.Student;
import com.example.demo.service.BookService;
import com.example.demo.service.StudentService;

@RequestMapping("/book")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private StudentService studentService;
	
//	
//	@Autowired
//	private StudentRepository studentRepository;

	@PostMapping("/addBook")
	Books add(@RequestBody Books books) {
		return bookService.addBook(books);

	}

	@PutMapping("/updateBook/{bookId}")
	Books update(@PathVariable int bookId, @RequestBody Books book) throws Exception {
		return bookService.updateBook(bookId, book);
	}
	@DeleteMapping("deleteBook/{bookId}")
	public List<Books> delete(@PathVariable int bookId) throws Exception{
		bookService.deleteBook(bookId);
		return bookService.getAllBook();
	}
	
	@GetMapping("/getByBookId/{bookId}")
	Books getByBooks(@PathVariable int bookId) throws Exception {
		
		return bookService.getByBookId(bookId);
		}
	
	@GetMapping("/getAllBook")
	List<Books> getAllBook(){
		return bookService.getAllBook();
	}
//	@PutMapping("/assignBookToStudent/{sId}/{bookId}")
//	Books assignBookToStudent(@PathVariable int sId,@PathVariable int bookId) throws Exception {
//		
//		Books book = bookService.getByBookId(bookId) ;
//		Student student = studentService.getByStudentId(sId);
//		
//		book.setBookId(null)
//		return null;
//		
//	}
	
	@PutMapping("/assignBookToStudent/{sId}/{bookId}")
	public Student assignBookToStudent(@PathVariable int sId,@PathVariable int bookId) throws Exception {
		Student student=studentService.getByStudentId(sId);
		//System.out.println(student);
		Books books=bookService.getByBookId(bookId);
		books.setStudent(student);
		//System.out.println(books);
		student.getBooks().add(books);
		studentService.addStudent(student);
		return student;
	}
	@DeleteMapping("/book/deassignBookToStudent/{stuId}/{bookId}")
	public Student deassignBookToStudent(@PathVariable int stuId,@PathVariable int bookId ) throws Exception {
		Student student = studentService.getByStudentId(stuId);
		Books books = bookService.getByBookId(bookId);
		student.getBooks().remove(books);
		
		return student;
		
	}

	/*
	 * @DeleteMapping("/delete/{bookId}") List<Books> delete(@PathVariable int
	 * bookId) throws Exception {
	 * 
	 * //service.delete(bookId).removeAll(); return service.delete(bookId); }
	 * 
	 * @GetMapping("/get/{bookId}") Books get(@PathVariable int bookId) throws
	 * Exception { return service.getById(bookId); }
	 * 
	 * // @GetMapping("/student/get/{sId}") // Student getbyStudent(@PathVariable
	 * int subId)throws Exception{ // return service.getById(sId); // }
	 * 
	 * @GetMapping("/student/getAll") List<Books> getAll() { return
	 * service.getAll(); }
	 * 
	 * @SuppressWarnings("unlikely-arg-type")
	 * 
	 * @DeleteMapping("/deleteAssignedBookToStudent/{bookId}") public Books
	 * deassignBookToStudent(@PathVariable int bookId) throws Exception { Books
	 * book=service.getById(bookId); List<Student> students=studentService.getAll();
	 * List<Student> result=new ArrayList<>(); for(Student student:students) {
	 * if(student.getBooks().equals(book)) { continue; } result.add(student); }
	 * System.out.println(students); studentService.saveAll(result); Student student
	 * = studentService.getById(bookId); student.getBooks().remove(student);
	 * 
	 * return book; }
	 */
}
