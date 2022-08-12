package com.assignment.bookshop;

import com.assignment.bookshop.service.CheckoutService;
import com.assignment.bookshop.service.FileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Main application entry point class
 * @author Shubham Kalaria
 */
@Log4j2
@SpringBootApplication
public class BookShopApplication implements ApplicationRunner {

	@Autowired
	CheckoutService checkoutService;

	@Autowired
	FileService fileService;

	/**
	 * Main method to initiate application execution
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(BookShopApplication.class);
		application.setHeadless(false);
		application.run(args);
	}

	/**
	 * Application run method.
	 * It prints the final amount to be paid after applying offers/discounts for books ordered.
	 * @param args command line arguments
	 */
	@Override
	public void run(ApplicationArguments args) {
		String[] arguments = args.getSourceArgs();
		if(ObjectUtils.isEmpty(arguments)) {
			log.error("Illegal or Inappropriate arguments passed.");
			throw new IllegalArgumentException("Illegal or Inappropriate arguments passed.");
		}

		try {
			fileService.extractAllBooksAvailable(arguments[0]);
			String filePath = arguments[1];
			List<String> books = fileService.extractBooksToBuy(filePath);
			BigDecimal finalAmount = checkoutService.calculateFinalAmount(books);
			System.out.println("#######################################");
			System.out.println("Final amount to be paid: " + finalAmount);
			System.out.println("#######################################");
		} catch (Exception exception) {
			log.error("Exception occurred during application execution, exception: {}", exception);
		}
	}
}
