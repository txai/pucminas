<template>
    <v-btn 
        x-large
        fab
        bottom
        right
        fixed
        color="secondary"
        @click="onClick"
        >
        <v-icon>mdi-plus</v-icon>
    </v-btn>
</template>

<script>
    export default {
        data: () => { return {} },
        methods: {
            onClick() {
                this.$emit('clicked');
            }
        }
    }
</script>

