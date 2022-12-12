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
                
                <div class="info">Los datos de todos los empleados y el total de todos sus sueldos con dos decimales</div>

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
                        <tr>
                            <!-- Nombre del empleado -->
                            <td>
                                <xsl:value-of select="nombre" />
                            </td>
                            <!-- Trabajo del empleado -->
                            <td>
                                <xsl:value-of select="trabajo" />
                            </td>
                            <!-- Sueldo del empleado -->
                            <td class="number">
                                <xsl:value-of select="sueldo" />
                            </td>
                        </tr>
                    </xsl:for-each>
                    <!-- Total del sueldo de todos los empleados -->
                    <tr>
                        <td colspan="2">TOTAL DE SUELDOS</td>
                        <td class="number">
                            <xsl:value-of select="format-number(sum(empresa/departamento/empleado/sueldo), '#.00')" />
                        </td>
                    </tr>
                </table>

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>