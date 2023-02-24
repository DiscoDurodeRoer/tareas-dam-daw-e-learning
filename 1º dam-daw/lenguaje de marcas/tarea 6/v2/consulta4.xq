(: 4. Obtener cuántos libros hay que no disponen de formato digital almacenados en el XML.:)
let $x := 
  for $book in doc("Bookstore.xml")/bookstore/book
  return $book
let $y := 
  for $book in doc("Bookstore.xml")/bookstore/book/ebook
  return $book
return count($x) - count($y)