(: 6. Modelo de las impresoras de tipo “láser”. :)
for $impresora in doc("impresoras.xml")/impresoras/impresora
where $impresora/@tipo = 'láser'
return $impresora/modelo/text()