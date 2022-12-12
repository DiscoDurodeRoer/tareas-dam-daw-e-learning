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
                    <p>Los datos de todos los departamentos de la empresa especificando:</p>
                    <ol>
                        <li>Nombre del departamento.</li>
                        <li>Número de empleados del mismo.</li>
                        <li>La suma de los sueldos de sus empleados con punto de millar, coma decimal y dos decimales.</li>
                        <li>Media aritmética de los sueldos de sus empleados con punto de millar, coma decimal y dos decimales.</li>
                    </ol>
                </div>

                <table>
                    <caption>
                        <xsl:value-of select="empresa/@nombre" />
                    </caption>
                    <tr>
                        <th>Departamiento</th>
                        <th>Empleados</th>
                        <th>Total sueldos</th>
                        <th>Media</th>
                    </tr>
                    <!-- Recorro los departamientos -->
                    <xsl:for-each select="empresa/departamento">
                        <tr>
                            <!-- Muestro el nombre del departamento -->
                            <td>
                                <xsl:value-of select="@nombre" />
                            </td>
                            <!-- Cuento el numero de empleados -->
                            <td class="number">
                                <xsl:value-of select="count(empleado)" />
                            </td>
                            <!-- Sumo los salarios de los empleados -->
                            <td class="number">
                                <xsl:value-of select="format-number(sum(empleado/sueldo), '#.###,00', 'custom-format')" />
                            </td>
                            <!-- Obtengo la medio de los saladios de los empleados -->
                            <td class="number">
                                <xsl:value-of select="format-number(sum(empleado/sueldo) div count(empleado), '#.###,00', 'custom-format')" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>

            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>