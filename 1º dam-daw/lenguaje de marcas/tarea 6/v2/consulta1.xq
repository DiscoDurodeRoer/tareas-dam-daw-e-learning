(: 1. Obtener el título de aquellos libros que hayan tenido alguna venta el 2020 o 2021.:)
for $sale in doc("Bookstore.xml")/bookstore/sale
where contains($sale/date, "2020") or contains($sale/date, "2021")
return $sale/refbook/text()