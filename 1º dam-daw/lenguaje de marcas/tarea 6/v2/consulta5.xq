(: 5. Obtener todos los libros con un precio entre 20 y 40, ambos no incluidos, ordenados por el año de forma descendente.:)
for $book in doc("Bookstore.xml")/bookstore/book
where $book/price > 20 and $book/price < 40
order by $book/year descending
return $book