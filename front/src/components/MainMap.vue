<template>
    <l-map @ready="onReady" @locationfound="onLocationFound" ref="map" style="height: 100%" :zoom="zoom"
        :center="center">
        <template v-if="location">
            <l-circle-marker :lat-lng="location.latlng" :fillOpacity="1" :radius="0.1" />
            <l-circle-marker :lat-lng="location.latlng" :radius="location.accuracy/2" :stroke="false" />
        </template>
        <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
    </l-map>
</template>
  
<script>
import { LMap, LTileLayer, LCircleMarker } from 'vue2-leaflet';

export default {
    name: 'MainMap',
    components: {
        LMap,
        LTileLayer,
        LCircleMarker
    },
    data() {
        return {
            url: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
            attribution:
                '&copy; <a target="_blank" href="http://osm.org/copyright">OpenStreetMap</a> contributors',
            zoom: 30,
            center: [0, 0],
            location: null
        };
    },
    methods: {
        onReady() {
            this.$refs['map'].mapObject.locate()
        },
        onLocationFound(l) {
            this.center = l.latlng
            this.location = l;
        }
    }
}
</script>
  