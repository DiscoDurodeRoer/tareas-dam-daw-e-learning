<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" />

    <!-- Usado para el formateo de decimales y separadores de miles -->
    <xsl:decimal-format name="custom-format" decimal-separator="," grouping-separator="." />
    <xsl:template match="/">
        <html>
            <head>
                <title>
                    <xsl:value-of select="empresa/@nombre" />
                </title>
                <link rel="stylesheet" href="../CSS/style.css" />
            </head>
            <body>
                
                <div class="info">
                    <p>Los datos de todos los empleados teniendo en cuenta</p>
                    <ol>
                        
                        <li>Los que disponen de sueldo superior a 2.700 con fondo #66CCFF y el resto con fondo #00CC99.</li>
                        <li>Los sueldos con punto de millar, coma decimal y dos decimales.</li>
                        <li>La salida clasificada por nombre del empleado descendentemente.</li>
                        <li>En el caso de que el empleado disponga del atributo nacionalidad, aparecerá
                            delante del nombre del empleado en mayúsculas, negrita y cursiva.</li>
                    </ol>
                </div>

                <table>
                    <caption>
                        <xsl:value-of select="empresa/@nombre" />
                    </caption>
                    <tr>
                        <th>Nombre</th>
                        <th>Trabajo</th>
                        <th>Sueldo</th>
                    </tr>
                    <!-- Recorro los empleados -->
                    <xsl:for-each select="empresa/departamento/empleado">
                        <!-- Ordeno el resultado descendentemente por nombre -->
                        <xsl:sort select="nombre" order="descending"></xsl:sort>
                        <tr>
                            <!-- Si el sueldo es mayor de 2700, pongo la clase "gt-2700" al tr, sino pongo la clase "lt-2700"-->
                            <xsl:choose>
                                <xsl:when test="sueldo &gt; 2700">
                                    <xsl:attribute name="class">gt-2700</xsl:attribute>
                                </xsl:when>
                                <xsl:when test="sueldo &lt; 2700">
                                    <xsl:attribute name="class">lt-2700</xsl:attribute>
                                </xsl:when>
                            </xsl:choose>
                            <td>
                                <!-- Si tiene el atributo nacionalidad, muestro el atributo nacionalidad -->
                                <xsl:if test="@nacionalidad">
                                    <span class="nationality">
                                        <xsl:value-of select="@nacionalidad" />
                                    </span>
                                </xsl:if>
                                <!-- Muestro del nombre del empleado -->
                                <xsl:value-of select="nombre" />
                            </td>
                            <!-- Trabajo del empleado -->
                            <td>
                                <xsl:value-of select="trabajo" />
                            </td>
                            <!-- Sueldo del empleado -->
                            <td class="number">
                                <xsl:value-of select="format-number(sueldo, '#.###,00', 'custom-format')" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>