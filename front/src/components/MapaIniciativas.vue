<template>
    <l-map 
        ref="map" 
        style="height: 100%"
        :zoom="zoom"
        :center="center"
    >
        <template v-if="location">
            <l-circle-marker :lat-lng="location.latlng" :fillOpacity="1" :radius="0.1" />
            <l-circle-marker :lat-lng="location.latlng" :radius="location.accuracy/2" :stroke="false" />
        </template>
        <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
        <l-marker v-for="iniciativa in iniciativas" :key="iniciativa.nome" :lat-lng="iniciativa.latLong" :icon="markerIcon" >
            <l-popup>
                <h3>{{iniciativa.nome}}</h3><br>
                <p>{{iniciativa.end}}</p>
                <p>{{iniciativa.tel}}</p>
                <p>Cestas restantes:{{iniciativa.cestasRestantes}}</p>
            </l-popup>
        </l-marker>
    </l-map>
</template>
  
<script>
import { LMap, LTileLayer, LCircleMarker, LMarker, LPopup } from 'vue2-leaflet';
import markerIconPng from "leaflet/dist/images/marker-icon.png";
import { Icon } from 'leaflet';


export default {
    name: 'MapaIniciativas',
    components: {
        LMap,
        LTileLayer,
        LCircleMarker,
        LMarker,
        LPopup
    },
    data() {
        return {
            url: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
            attribution:
                '&copy; <a target="_blank" href="http://osm.org/copyright">OpenStreetMap</a> contributors',
            zoom: 30,
            center: [-23.575090, -46.734670],
            location: null,
            markerIcon: new Icon({iconUrl: markerIconPng}),
            iniciativas: [{
                nome: "Projeto Vida Feliz",
                end: "Rua Jonas Herculano Aquino, 90",
                tel: "(11) 91234-5678",
                latLong: [-23.575090, -46.734670],
                cestasRestantes: 50
            },
            {
                nome: "Projeto Boa Alimentação",
                end: "Rua Monte Caseiros, 35",
                tel: "(11) 91234-5678",
                latLong: [-23.574637,-46.733003],
                cestasRestantes: 3
            },
            {
                nome: "Dona Maria",
                end: "Rua Ary Ariovaldo Eboli, 10",
                tel: "(11) 91234-5678",
                latLong: [-23.575188,-46.735245],
                cestasRestantes: 1
            }
        ]
        };
    },
    methods: {
        onReady() {
            //this.$refs['map'].mapObject.locate()
        },
        onLocationFound(l) {
            console.log(l)
            //this.center = l.latlng
            //this.location = l;
        }
    }
}
</script>
  