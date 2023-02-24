(: 2. El nombre (sin etiquetas) de los artistas que nacieron antes de 1500 :)
for $artista in doc("artistas.xml")/artistas/artista
where $artista/nacimiento < 1500
return $artista/nombreCompleto/text()
