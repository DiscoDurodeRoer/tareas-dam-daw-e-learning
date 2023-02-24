(: 1. Nombre y país de todos los artistas :)
for $artista in doc("artistas.xml")/artistas/artista
return 
<artista>
  {$artista/nombreCompleto}
  {$artista/pais}
</artista>