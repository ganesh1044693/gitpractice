package com.jersey.series.spring.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.series.spring.hibernate.model.Book;

@Repository
public class BookDAOImpl {

	@PersistenceContext
	public EntityManager entityManager;

	
	@Transactional
	public List<Book> getBookInfo() {

		// retrieve book object based on the id supplied in the formal argument
		List<Book> book = (List<Book>)entityManager.createQuery("from Book b").getResultList();
		return book;
	}

	
}