# ScanBook Service

ScanBook is an inventory management backend service that exposes APIs to maintain an inventory of books. User can query for books based on their title, barcode and authors that wrote them. Users can also create, update and delete books by barcode.

## Installation
1.Execute the SQL Script ``db/dbsetup.sql`` to initialize the database layer of this service.
2.Use ``mvn clean install -DskipTests`` to build the project and generate the WAR file. Deploy this WAR in a Tomcat web server and run ``catalina.sh``.

## APIs

1.``GET /books/``
Fetches all the books from the inventory.

2.``GET /books/id/123`` Gets the book matching having the barcode '123'.

3.``/books/title/Mur`` Gets the book having a title containing 'Sput'.

4.``/books/author/Mur`` Gets the book having an author whose name contains 'Mur'.


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
