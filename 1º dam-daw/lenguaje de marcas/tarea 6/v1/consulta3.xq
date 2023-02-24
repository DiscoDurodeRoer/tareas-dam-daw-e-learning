(: 3. Nombre de los artistas para los que no hay año de fallecimiento :)
for $artista in doc("artistas.xml")/artistas/artista
where not($artista/fallecimiento)
return $artista/nombreCompleto/text()