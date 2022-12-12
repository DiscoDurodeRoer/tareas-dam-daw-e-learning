<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" />

    <xsl:template match="/">
        <html>
            <head>
                <title>
                    <xsl:value-of select="empresa/@nombre" />
                </title>
                <link rel="stylesheet" href="../CSS/style.css" />
            </head>
            <body>
                
                <div class="info">Datos del primer primer empleado</div>

                <table>
                    <caption>
                        <xsl:value-of select="empresa/@nombre" />
                    </caption>
                    <tr>
                        <th>Nombre</th>
                        <th>Trabajo</th>
                        <th>Sueldo</th>
                    </tr>
                    <tr>
                        <!-- Nombre del primer empleado -->
                        <td>
                            <xsl:value-of select="empresa/departamento/empleado[1]/nombre" />
                        </td>
                        <!-- Trabajo del primer empleado -->
                        <td>
                            <xsl:value-of select="empresa/departamento/empleado[1]/trabajo" />
                        </td>
                        <!-- Sueldo del primer empleado -->
                        <td class="number">
                            <xsl:value-of select="empresa/departamento/empleado[1]/sueldo" />
                        </td>
                    </tr>
                </table>

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>