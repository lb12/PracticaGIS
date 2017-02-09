/* global L */

$(document).ready(function () {
    var contadorPuntos = 0, contadorRutas = 0;
    var x1, y1, x2, y2;
    var mymap = L.map('mapid').setView([40.570154, -3.314120], 12); //Centrado en Azuqueca (mostamos facultades de Alcala y Guada)

    representarLayer();
    representarFacultades();

    //Al hacer click en el boton de trazar ruta, trazamos esta.
    $("#botonRuta").click(function () {
        if (contadorPuntos < 2) {
            alert("Todavia no has seleccionado un par de rutas: origen-destino.");
        } else {
            if (contadorRutas === 0) {
                enrutar();
                contadorRutas++;
            }
        }
    });

    //Al hacer click en el boton de reset, reseteamos los datos
    $("#botonReset").click(function () {
        contadorRutas = contadorPuntos = 0;
    });

    $("#x1").change(function () {
        alert("Ha cambiado x1");
    });

//Funcion que incluye las facultades de la universidad en el mapa con los marcadores
    function representarFacultades() {
        $.ajax({
            type: "get",
            url: "Servlet",
            assync: true,
            cache: false,
            success: function (resp) { /*Obtenemos aqui el JSON*/
                $.each(resp, function (indice, facultad) { /*Each tiene 2 args: el array con los objetos (resp) y una funcion con los indices de cada obj y un obj de la coleccion*/
                    L.marker(facultad.coordenadas).addTo(mymap).bindPopup(facultad.nombre + "<br>" + facultad.descripcion).on('click',
                            function () {
                                var coordenadas = facultad.coordenadas.toString();
                                var coordX = coordenadas.substring(0, facultad.coordenadas.toString().indexOf(","));
                                var coordY = coordenadas.substring(1 + facultad.coordenadas.toString().indexOf(","));
                                if (contadorPuntos === 0) {
                                    x1 = coordX;
                                    y1 = coordY;
                                    actualizarHidden(1, x1, y1);
                                } else if (contadorPuntos === 1) {
                                    x2 = coordX;
                                    y2 = coordY;
                                    actualizarHidden(2, x2, y2);
                                }
                                contadorPuntos++;
                            });
                });
            }
        });
    }
    
//Funcion que actualiza los input hidden
    function actualizarHidden(numeroHidden, x, y) {
        $("#x" + numeroHidden).val(x); //Coordenada x
        $("#y" + numeroHidden).val(y); //Coordenada y
    }

//Funcion que incluye el layer con la informacion del copyright en el mapa
    function representarLayer() {
        L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}{r}.png', {
            maxZoom: 18,
            attribution: '© OpenStreetMap contributors',
            id: 'mapbox.streets'
        }).addTo(mymap);
    }

//Funcion que traza la ruta entre dos puntos
    function enrutar() {
        L.Routing.control({
            waypoints: [L.latLng(x1, y1), L.latLng(x2, y2)]
        }).addTo(mymap);
    }
});
