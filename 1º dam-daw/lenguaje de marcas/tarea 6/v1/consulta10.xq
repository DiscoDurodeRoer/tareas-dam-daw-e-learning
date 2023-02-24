(: 10. Modelo de las impresoras en red. :)
for $impresora in doc("impresoras.xml")/impresoras/impresora
where exists($impresora/enred)
return $impresora/modelo/text()