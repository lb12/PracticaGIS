<%@page import="java.util.ArrayList"%>
<%@page import="modeloControlador.Facultad"%>
<%@page import="modeloControlador.ModeloDatos"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Practica GIS</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />

        <!-- Leaflet -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
        <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>

        <!-- OSRM ROUTING -->
        <link rel="stylesheet" href="route-maching/leaflet-routing-machine.css" />
        <script src="route-maching/leaflet-routing-machine.js"></script>

        <!-- CSS y Scripts propios -->
        <link rel="stylesheet" href="css/styles.css" />
        <script src="scripts/jquery-3.1.1.min.js"></script>
        <script src="scripts/script.js"></script>    
    </head>

    <body>
        <div id="mapid"></div>
        <form id="formulario" action="">
            <input type="text" name="xn" id="x1" />
            <input type="text" name="yn" id="y1" />
            <input type="text" name="xn2" id="x2" />
            <input type="text" name="yn2" id="y2" />
            <input type="button" id="botonRuta" value="Trazar Ruta" />
            <input type="reset" id="botonReset" value="Reiniciar ruta" />
        </form>
    </body>

</html>
