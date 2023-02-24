(: 2.  Obtener el autor, año y precio de cada libro perteneciente a la categoría WEB.:)
for $book in doc("Bookstore.xml")/bookstore/book
where $book/@category = 'WEB'
return 
<book>
  {$book/author}
  {$book/year}
  {$book/price}
</book>