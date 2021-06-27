const app = Vue.createApp({})

app.component('history', {
    template: `
    <h1> History</h1>
    <h2>Total profit/loss: {{ total }}$</h2>
    
    <table class="table">
        <thead>
            <tr>
                <th>id</th>
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
                <td colspan="2">No closed trades yet</td>
            </tr>
            <tr v-for="(product, index) in items">
                <td>{{ product.tradeId }}</td>
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
        `,
    data(){
        return {
            items: [],
            total: []
        };
    },

    methods:{
        totalClosed(){
            axios.get('/getTotalClosedTrades')
                .then(response =>(this.total = response.data))
        },
        loadProducts() {
            axios.get('/getAllClosedTrades')
                .then(response => (this.items = response.data))
        }

    },
    mounted: function () {
        this.loadProducts();
        this.totalClosed();
    }
});
app.mount('#history');