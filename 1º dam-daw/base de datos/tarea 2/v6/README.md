# Tarea 2 base de datos 

Youtube: https://youtu.be/k_2QUvm4QXc

Si te ha servido este repositorio, no te olvides de darle una estrella.

# Enunciado

En la comunidad se organizan distintas vueltas, como, por ejemplo: la Vuelta Ciclista a Toledo, la Vuelta Ciclista Pueblos de Talavera, Vuelta Ciclista Campana de Oropesa, etc. Todas ellas se caracterizan por su nombre, el número de km en total, la fecha en la que da comienzo y la fecha en la que comienza.

Las vueltas tienes diferentes patrocinadores y un patrocinador puede serlo de varias vueltas. La cuantía con la que patrocina cada vuelta no es la misma y queremos almacenar dicha cuantía.

Las vueltas están compuestas por diferentes etapas. Cada etapa queda definida por un código único, de forma que nunca se repite. También se desea saber, los kilómetros de cada etapa, el punto de salida, el de llegada, la fecha y la hora de salida.

Una etapa tiene diferentes premios. (metas volantes, premios de la montaña, sprint especial, llegada a meta, etc.). Cada premio queda definido por un código único que nunca se repite, el nombre y una cuantía económica.

En cada vuelta, se inscriben diferentes equipos, de los que se guarda su nombre, el número de ciclistas que lo componen y una descripción.
Los equipos se componen de ciclistas. De los ciclistas, guardamos los datos personales. Durante un año los ciclistas no pueden cambiar de equipo.

Se desea saber qué ciclistas participan en cada etapa, teniendo en cuenta que un ciclista no tiene por qué participar en todas las etapas de una Vuelta. Se quiere guardar la posición y el tiempo que realiza el ciclista en cada etapa.
