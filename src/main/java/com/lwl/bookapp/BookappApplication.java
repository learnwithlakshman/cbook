package com.lwl.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;

import com.lwl.bookapp.domain.Book;
import com.lwl.bookapp.service.BookService;

import net.sf.ehcache.config.CacheConfiguration;

@SpringBootApplication
@EnableCaching
public class BookappApplication implements CommandLineRunner  {
		@Autowired
		private BookService bookService;
		@Autowired
		private CacheManager cacheManager;
		
//		@Autowired
//		private BookRepository bookRepository;
	
		public static void main(String... args) {
			SpringApplication.run(BookappApplication.class);
		}

		@Override
		public void run(String... args) throws Exception {
//			bookRepository.deleteAll();
//			Book book1 = new Book("Digital Marketing",560);
//			Book book2 = new Book("Let US Java",360);
//			Book book3 = new Book("Learn Spring in 30 Days",2060);
//			
//			book1 = bookService.addBook(book1);
//			bookService.addBook(book2);
//			bookService.addBook(book3);
			
			Cache cache = cacheManager.getCache("books");
			
			Book book = cache.get(4L, Book.class);
			if(book ==null) {
				book = bookService.findById(4L);
				cache.put(4L, book);
			}
			
			book = cache.get(4L, Book.class);
			System.out.println(book);	
			
			
			
		}
		
		
		@Bean
		public net.sf.ehcache.CacheManager ehCacheManager() {
			CacheConfiguration tenMinCache = new CacheConfiguration();
			tenMinCache.setName("books");
			tenMinCache.setMemoryStoreEvictionPolicy("LRU");
			tenMinCache.setMaxEntriesLocalHeap(1000);
			tenMinCache.setTimeToLiveSeconds(5);
	    	net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
			config.addCache(tenMinCache);
			return net.sf.ehcache.CacheManager.newInstance(config);
		}
		@Bean
		public CacheManager cacheManager() {
			return new EhCacheCacheManager(ehCacheManager());
		}
}
	
