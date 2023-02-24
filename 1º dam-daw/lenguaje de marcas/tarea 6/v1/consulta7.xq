(: 7. Marca y modelo de las impresoras con más de un tamaño. :)
for $impresora in doc("impresoras.xml")/impresoras/impresora
where count($impresora/tamanios/tamanio) > 1
return 
<impresora>
  <marca>{$impresora/marca/text()}</marca>
  <modelo>{$impresora/modelo/text()}</modelo>
</impresora>
