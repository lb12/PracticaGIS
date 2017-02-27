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

        <div id="titulo">
            <h1>Ruteador Facultades UAH</h1>            
        </div>

        <div id="cuerpo">            
            <div id="mapid"></div>

            <div id ="form">
                <form id="formulario" action="">
                    
                    <label>Origen: </label> <input type="text" name="ori" id="origen" size="40"/><br>
                    <input type="hidden" name="xn" id="x1" />
                    <input type="hidden" name="yn" id="y1" /> <br>
                    <label>Destino: </label> <input type="text" name="dest" id="destino" size="40"/><br>
                    <input type="hidden" name="xn2" id="x2" />
                    <input type="hidden" name="yn2" id="y2" />
                    <div class="btns">
                        <input type="button" id="botonRuta" value="Trazar Ruta" /> 
                        <input type="button" id="botonReset" value="Reiniciar ruta" />
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>
