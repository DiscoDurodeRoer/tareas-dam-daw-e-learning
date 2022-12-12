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
                    <!-- Busco la plantila que coincida su select y match -->
                    <xsl:apply-templates select="empresa/departamento" />
                </table>

            </body>
        </html>
    </xsl:template>

    <!-- Plantilla para recorrer los empleados -->
    <xsl:template match="empresa/departamento">
        <!-- Recorro los empleados -->
        <xsl:for-each select="empleado">
            <!-- Si el trabajo es igual a Programador -->
            <xsl:if test="trabajo = 'Programador'">
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
            </xsl:if>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>