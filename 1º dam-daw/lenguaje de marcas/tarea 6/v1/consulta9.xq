(: 9. Marca y modelo de las impresoras con tamaño A3 como único tamaño. :)
for $impresora in doc("impresoras.xml")/impresoras/impresora
where $impresora/tamanios/tamanio = 'A3' and count($impresora/tamanios/tamanio) = 1
return 
<impresora>
  <marca>{$impresora/marca/text()}</marca>
  <modelo>{$impresora/modelo/text()}</modelo>
</impresora>