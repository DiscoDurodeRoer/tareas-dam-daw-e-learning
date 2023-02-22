<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <!-- Metodo de salida -->
    <xsl:output method="html" />

    <!-- Template -->
    <xsl:template match="/">
        <!-- Html -->
        <html>
            <head>
                <meta charset="UTF-8" />
                <title>Tabla de artistas</title>
            </head>
            <body>
                <!-- Tabla -->
                <table>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Año de nacimiento</th>
                        <th>Año de fallecimiento</th>
                        <th>País</th>
                        <th>Página web</th>
                    </tr>
                    <!-- Recorremos los artistas -->
                    <xsl:for-each select="artistas/artista">
                        <!-- Ordenamos los artistas por nacimiento -->
                        <xsl:sort select="nacimiento" order="ascending" />
                        <!-- Solo mostramos los mayores a 1500 -->
                        <xsl:if test="nacimiento &gt; 1500">
                            <tr>
                                <td>
                                    <!-- Mostramos el valor del atributo cod -->
                                    <xsl:value-of select="@cod" />
                                </td>
                                <td>
                                    <!-- Mostramos el valor de la etiqueta nombreCompleto -->
                                    <xsl:value-of select="nombreCompleto" />
                                </td>
                                <td>
                                    <!-- Mostramos el valor de la etiqueta nacimiento -->
                                    <xsl:value-of select="nacimiento" />
                                </td>
                                <td>
                                    <!-- Mostramos el valor de la etiqueta fallecimiento -->
                                    <!-- Sino existe mostramos "Desconocido" -->
                                    <xsl:choose>
                                        <xsl:when test="fallecimiento">
                                            <xsl:value-of select="fallecimiento" />
                                        </xsl:when>
                                        <xsl:otherwise>Desconocido</xsl:otherwise>
                                    </xsl:choose>
                                    
                                </td>
                                <td>
                                    <!-- Mostramos el valor de la etiqueta pais -->
                                    <xsl:value-of select="pais" />
                                </td>
                                <td>
                                    <!-- Creamos un enlace con el atributo href con el valor de fichaCompleta -->
                                    <a>
                                        <xsl:attribute name="href">
                                            <xsl:value-of select="fichaCompleta" />
                                        </xsl:attribute>
                                        Saber más
                                    </a>
                                </td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>