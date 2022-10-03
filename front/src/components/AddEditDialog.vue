<template>
    <v-dialog
        :fullscreen=$vuetify.breakpoint.xsOnly
        hide-overlay
        v-model="show"
        width="auto"
    >
        <v-card>
            <v-toolbar color="secondary">
                <v-spacer />
                <v-toolbar-title>{{title}}</v-toolbar-title>
                <v-spacer />
                <v-btn icon @click="show = false"><v-icon>mdi-close</v-icon></v-btn>
                <v-btn icon @click="onSave"><v-icon>mdi-check</v-icon></v-btn>
            </v-toolbar>
            <v-card-text><v-container><slot></slot></v-container></v-card-text>
        </v-card>
    </v-dialog>
</template>

<script>
    export default {
        data() {
            return {
            }
        },
        props: {
            value: Boolean,
            title: String
        },
        computed: {
            show: {
                get() {
                    return this.value
                },
                set(value) {
                    this.$emit('input', value)
                }
            }
        },
        methods: {
            onSave(obj) {
                this.$emit('save', obj)
            }
        }
    }
</script>