(: 4. Una lista HTML con el nombre de los artistas nacidos en España. :)
<ul>
  {
    for $artista in doc("artistas.xml")/artistas/artista
    where $artista/pais = 'España'
    return 
    <li>
      {$artista/nombreCompleto/text()}
    </li>
  }
</ul>
