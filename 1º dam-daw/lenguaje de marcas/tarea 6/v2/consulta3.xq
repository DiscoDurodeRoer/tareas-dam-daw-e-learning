(: 3.  Mostrar en una tabla de HTML la cantidad total de libros y precio medio entre todos los libros.:)
let $x := 
  for $book in doc("Bookstore.xml")/bookstore/book
  return $book
let $y :=
  for $book in doc("Bookstore.xml")/bookstore/book
  return $book/price
return
<table>
  <tr>
    <td>Total</td>
    <td>Media</td>
  </tr>
    <tr>
    <td>{count($x)}</td>
    <td>{avg($y)}</td>
  </tr>
</table>