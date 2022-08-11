# book-shop

## Description
This SpringBoot application is an automation software solution for purchasing and checkout process of a bookshop.

There will be two files consisting of below data,
1. List of all available books with their required details like title, price and year. (In JSON format)
2. List of book titles which are to be bought by customers.

There are two types of offers/discounts as well,
1. 10% discount for all books published after year - 2000.
2. 5% discount to books worth more than £30 in total.


## Assumptions
1. Book titles are distinct.
2. Currency is uniform across all books available.
3. A book to buy is always present in the list of available books.


## Requirements
- Java v1.8
- Apache Maven v3.8.6
- Unix environment


## How to Build / Test / Run
- Build
    ```
    cd PROJECT_DIRECTORY
    mvn clean install
    ```
- Test
    ```
    cd PROJECT_DIRECTORY
    mvn test
    ```
- Run
    ```
    cd PROJECT_DIRECTORY
    java -jar target/bookshop-0.0.1-SNAPSHOT.jar available_books.txt books_to_buy.txt
    ```
    In above command, 
    
    - available_books.txt - catalogue of all available books with required details
    
    - books_to_buy.txt - list of books to buy


## Sample Input/Output

### Input ( books_to_buy.txt )
  ```
  Still Life With Woodpecker
  Three Men in a Boat
  Great Expectations
  ```
### Output
<img width="541" alt="image" src="https://user-images.githubusercontent.com/30280454/184234201-b754b89c-b8ab-439d-940a-5eaa2503b8ea.png">


