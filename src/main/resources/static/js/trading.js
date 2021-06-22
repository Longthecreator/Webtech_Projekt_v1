
const app = Vue.createApp({})

app.component('trading-dynamic-exchange', {
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
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{ nameField  }}</td>
                <td>{{ priceField  }}€</td>
                <td>Exchangerate / {{ priceField  }}</td>
            </tr>
            </tbody>
            </table>
        
        <h3>Here are all your trades:</h3>
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Price $</th>
                <th>Quantity</th>
                <th>Bought at $</th>
                <th>%</th>
                <th>P/L</th>
                <th>Created at</th>
            </tr>
            </thead>
            <tbody>
            <tr v-if="items.length === 0">
                <td colspan="2">No trades -> no balls</td>
            </tr>
            <tr v-for="product in items">
                <td>#</td>
                <td>{{product.name}}</td>
                <td>{{product.price}}</td>
                <td>{{product.quantity}}</td>
                <td>{{product.boughtAt}}</td>
                <td>{{product.changeInPercentage}}%</td>
                <td>{{product.profit}}</td>
                <td>{{product.creationDate}}</td>
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
            axios.get('/getActualTrades')
                .then(response => (this.items = response.data))
        },
        save() {
            axios.post('/doTrade?name='+this.nameField+'&price='+this.priceField, {
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
app.mount('#trading-dynamic-exchange');