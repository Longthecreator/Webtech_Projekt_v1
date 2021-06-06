package Webtech.Projekt.Controller;

public class Vue {
// ich mach das hier mal extra wir koennen es ja wenn alles funktioniert kopieren
    const app =Vue.createApp({})

            app.componenet('buttton-counter',

    {
        data() {
        return {count:0}},
        template:`
        <button @click="count++" >
            Du hast {
        {
            count
        }
    } mal geklickt.
        </button >`
    })
            app.mount('#components-demo')

// bin nicht sicher wo der aufruf hingehoert
<div id="components-demo">
    <button-counter></button-counter>
    </div>
}