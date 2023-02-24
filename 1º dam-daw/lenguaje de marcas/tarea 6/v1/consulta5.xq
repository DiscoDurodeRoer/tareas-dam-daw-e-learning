(: 5. El número de artistas nacidos antes de 1600 :)
let $artistas := 
  for $artista in doc("artistas.xml")/artistas/artista
  where $artista/nacimiento < 1600
  return $artista/nombreCompleto/text()
return count($artistas)