// Create a Vue application
const app = Vue.createApp({})

// Define a new global component called button-counter
app.component('button-counter', {
    data() {
        return {
            count: 0
        }
    },
    template: `
    <button @click="count++">
      You clicked me {{ count }} times.
    </button>`
})
app.mount('#components-demo')

<div id="components-demo">
    <button-counter></button-counter>
</div>