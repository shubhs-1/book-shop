package com.assignment.bookshop;

import com.assignment.bookshop.service.CheckoutService;
import com.assignment.bookshop.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BookShopApplication implements ApplicationRunner {

	@Autowired
	CheckoutService checkoutService;

	@Autowired
	FileService fileService;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(BookShopApplication.class);
		application.setHeadless(false);
		application.run(args);
	}

	/**
	 * Run method to initiate log processing
	 * @param args command line arguments
	 */
	@Override
	public void run(ApplicationArguments args) {
		String[] arguments = args.getSourceArgs();
		if(ObjectUtils.isEmpty(arguments)) {
			throw new IllegalArgumentException("Illegal or Inappropriate arguments passed.");
		}

		fileService.extractAllBooksAvailable(arguments[0]);
		String filePath = arguments[1];
		System.out.println("file1: " +arguments[0]+ " file2: " +arguments[1]);
		List<String> books = fileService.extractBooksToBuy(filePath);
		System.out.println("books: " +books);
		BigDecimal finalAmount = checkoutService.calculateFinalAmount(books);
		System.out.println("Total amount to be paid: " +finalAmount);
	}
}
