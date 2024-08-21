# Book Library

This repository hosts the Livro Application project, developed as part of my studies at T-Academy. This project is a Spring Boot application that manages a book catalog, allowing [CRUD](https://pt.wikipedia.org/wiki/CRUD) operations.

## Central Repository

The central repository for this project can be found on GitHub: [T-Academy](https://github.com/thealexcesar/T-Academy).

## Features

- **List All Books**: Supports pagination and sorting of results.
- **Search Books by Genre**: Filters available books by genre.
- **Add a New Book**: Inserts a new book into the catalog.
- **Update an Existing Book**: Updates book information.
- **Delete a Book**: Removes a book from the catalog.

## API Documentation

### Endpoints

<details>
<summary>List All Books</summary>

- **Endpoint**: `GET /livro`
- **Description**: Retrieves a paginated and sorted list of all books in the catalog.
- **Parameters**:
    - `page` (optional): The page number (default: `1`).
    - `size` (optional): The number of items per page (default: `10`).
    - `sortBy` (optional): The field to sort by (default: `createdAt`).
- **Response**:
    - `200 OK`: Returns a paginated list of `LivroDTO` objects.
    - **Headers**:
        - `X-Total-Pages`: Total number of pages.
        - `X-Total-Elements`: Total number of elements.
        - `X-Current-Page`: Current page number.
        - `X-Page-Size`: Number of items per page.

```yaml
GET /livro:
  summary: "List All Books"
  parameters:
    - in: query
      name: page
      schema:
        type: integer
        default: 1
    - in: query
      name: size
      schema:
        type: integer
        default: 10
    - in: query
      name: sortBy
      schema:
        type: string
        default: createdAt
  responses:
    '200':
      description: "A paginated list of books"
      headers:
        X-Total-Pages:
          schema:
            type: integer
        X-Total-Elements:
          schema:
            type: integer
        X-Current-Page:
          schema:
            type: integer
        X-Page-Size:
          schema:
            type: integer
```
</details>

<details>
<summary>Search Books by Genre</summary>

**Endpoint**: `GET /livro/genero/{genero}`  
**Description**: Retrieves a list of books filtered by the specified genre.  
**Parameters**:
- `genero` (path): The genre to filter books by.  
  **Response**:
- `200 OK`: Returns a list of `LivroDTO` objects that match the specified genre.
- `404 Not Found`: If no books are found for the specified genre.

```yaml
GET /livro/genero/{genero}:
  summary: "Search Books by Genre"
  parameters:
    - in: path
      name: genero
      required: true
      schema:
        type: string
  responses:
    '200':
      description: "List of books filtered by genre"
    '404':
      description: "No books found for the specified genre"
```
</details>

<details>
<summary>Add a New Book</summary>

**Endpoint**: `POST /livro`  
**Description**: Inserts a new book into the catalog.  
**Request Body**:
- `LivroDTO`: Object containing the details of the book (e.g., title, author, genre, year).  
  **Response**:
- `201 Created`: Returns the created `LivroDTO` object with a `Location` header indicating the URL of the newly created book.
- `Location` header: URI of the newly created book.

```yaml
POST /livro:
  summary: "Add a New Book"
  requestBody:
    required: true
    content:
      application/json:
        schema:
          $ref: '#/components/schemas/LivroDTO'
  responses:
    '201':
      description: "Book created successfully"
      headers:
        Location:
          description: "URI of the newly created book"
          schema:
            type: string
```
</details>

<details>
<summary>Update an Existing Book</summary>

**Endpoint**: `PUT /livro/{id}`  
**Description**: Updates the information of an existing book.  
**Parameters**:
- `id` (path): The UUID of the book to update.  
  **Request Body**:
- `LivroUpdateDTO`: Object containing the updated details of the book.  
  **Response**:
- `200 OK`: Returns the updated `LivroDTO` object.
- `404 Not Found`: If the book with the specified ID is not found.

```yaml
PUT /livro/{id}:
  summary: "Update an Existing Book"
  parameters:
    - in: path
      name: id
      required: true
      schema:
        type: string
        format: uuid
  requestBody:
    required: true
    content:
      application/json:
        schema:
          $ref: '#/components/schemas/LivroUpdateDTO'
  responses:
    '200':
      description: "Book updated successfully"
    '404':
      description: "Book not found"
```
</details>

<details>
<summary>Delete a Book</summary>

**Endpoint**: `DELETE /livro/{id}`  
**Description**: Removes a book from the catalog.  
**Parameters**:
- `id` (path): The UUID of the book to delete.  
  **Response**:
- `200 OK`: Returns a confirmation message indicating the book was successfully deleted.
- `404 Not Found`: If the book with the specified ID is not found.

```yaml
DELETE /livro/{id}:
  summary: "Delete a Book"
  parameters:
    - in: path
      name: id
      required: true
      schema:
        type: string
        format: uuid
  responses:
    '200':
      description: "Book deleted successfully"
    '404':
      description: "Book not found"
```
</details>

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Maven**

## Project Structure

- **Controller**: Contains the classes responsible for handling HTTP requests.
- **Model**: Defines the database entities.
- **DTO**: Data Transfer Objects used for communication between the service layer and the presentation layer.
- **Repository**: Interfaces that handle data persistence.

## Environment Setup

### Requirements

- **Java 21+**
- **Maven 3.6+**
- **PostgreSQL** with database created.

### Configuration

Create a `.env` file at the project's resources/ with the following variables:

```plaintext
DB_NAME=your_database_name
DB_USER=your_database_user
DB_PASSWORD=your_database_password
DB_HOST=localhost
```

## Clone this Repository and Run Application
```bash
git clone https://github.com/thealexcesar/book-library.git && \ 
cd book-library && \

mvn clean install && mvn spring-boot:run
```

