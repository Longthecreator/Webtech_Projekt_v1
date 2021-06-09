// Create a Vue application
const app = Vue.createApp({})
// const app = {
app.component('dynamic-form', {
    template: `
    <div>
        <input v-model="nameField" placeholder="Name" ref="nameInput">
        <input v-model="priceField" placeholder="Price" @keyup.enter="save()">
        <button type="button" @click="save()">Save</button>
    </div>
    <div>
           <h4>Trade Vorschau:</h4>
            <table class="table">
            <thead>
            <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Creationdate</th>
            <th scope="col">P/L</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{ nameField  }}</td>
                <td>{{ priceField  }}€</td>
                <td>Exchangerate / {{ priceField  }}</td>
                <td> 01.01.2021T10:49:1222</td>
                <td> -100 €</td>
            </tr>
            </tbody>
            </table>
        
        <h3>Here are all your trades:</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <tr v-if="items.length === 0">
                <td colspan="2">No trades -> no balls</td>
            </tr>
            <tr v-for="product in items">
                <td>{{product.name}}</td>
                <td>{{product.price}}</td>
            </tr>
            </tbody>
            </table>
    </div>
    `,
    data() {
        return {
            items: [],
            nameField: '',
            priceField: '',
        };
    },

    methods: {
        loadProducts() {
            axios.get('/allproducts')
                .then(response => (this.items = response.data))
        },
        save() {
            axios.post('/addProduct?name='+this.nameField+'&price='+this.priceField, {
                name: this.nameField,
                price: this.priceField
            })
                .then((response) => {
                    this.nameField = '';
                    this.priceField = '';
                    this.$refs.nameInput.focus();
                    this.loadProducts();
                }, (error) => {
                    console.log('Could not create trade');
                });

        },
    },
    mounted: function () {
        this.loadProducts();
    }
});
app.mount('#dynamic-form');