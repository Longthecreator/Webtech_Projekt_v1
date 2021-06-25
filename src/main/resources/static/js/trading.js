
const app = Vue.createApp({})

app.component('trading-dynamic-exchange', {
    template: `
<!--    <div>-->
<!--        <input v-model="nameField" placeholder="Name" ref="nameInput">-->

<!--        <input v-model="priceField" placeholder="Price" @keyup.enter="save()">-->
<!--        <button type="button" @click="save()">Save</button>-->
<!--    </div>-->
    <div>
<!--        Test Anfang-->
        <select v-model="selected" ref="coinNameInput">
          <option disabled value="">Choose a coin</option>
          <option>Bitcoin</option>
          <option>Litecoin</option>
          <option>Dogecoin</option>
          <option>Ethereum</option>
          <option>Cardano</option>
        </select>
        <span>Selected: {{ selected }}</span>
        <input v-model="priceField2" placeholder="Price" @keyup.enter="save()">
        <button class="btn btn-success" type="button" @click="saveButton()">TRADE!</button>
<!--        test ende-->
    </div>
    <div>
        <select v-model="selectClose" ref="closeInput">
        <option disabled value="">Close a trade</option>
        <option v-for="trade in items">{{ trade.tradeId }}</option>
        </select>
        <button class="btn btn-danger" type="button" @click="closeButton()">CLOSE!</button>
    </div>
    <div>
           <h4>Trade Vorschau:</h4>
            <table class="table">
            <thead>
            <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
<!--            <th scope="col">test</th>-->
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{ selected  }}</td>
                <td>{{ priceField2  }}$</td>
                <td v-if="selected === Bitcoin">{{ priceField2/list[0].currentPrice }}</td>
<!--                <td v-if="selected===Bitcoin">{{ priceField2*list[0].currentPrice}}</td>-->
            </tr>
            </tbody>
            </table>
        
        <div>
        <h2 class="text-center">Total profit/loss:    {{ total }}$ </h2>
        
        </div>
        <h3>Open positions:</h3>
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
                <td colspan="2">No trades -> no balls</td>
            </tr>
<!--            v-if="product.status==='true'"-->
            <tr v-for="product in items">
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
    </div>
    `,
    data() {
        return {
            items: [],
            list:[],
            total:[],
            selected: '',
            priceField2: '',
        };
    },

    methods: {
        loadProducts() {
            axios.get('/getActualTrades')
                .then(response => (this.items = response.data))
        },
        getAllData(){
            axios.get('/getCoinData')
                .then(response =>(this.list = response.data))
        },
        closeButton(){
          axios.post('/closeTrade?tradeId='+this.selectClose,{
              tradeId: this.selectClose
        })
            .then((response) => {
                this.selectClose = '';
                this.$refs.closeInput.focus();
                this.loadProducts();
            }, (error) =>{
                console.log('Could not close trade')
            });
        },
        // save() {
        //     axios.post('/doTrade?name='+this.nameField+'&price='+this.priceField, {
        //         name: this.nameField,
        //         price: this.priceField
        //     })
        //         .then((response) => {
        //             this.nameField = '';
        //             this.priceField = '';
        //             this.$refs.nameInput.focus();
        //             this.loadProducts();
        //         }, (error) => {
        //             console.log('Could not create trade');
        //         });
        //
        // },
        saveButton(){
            axios.post('/doTrade?name='+this.selected+'&price='+this.priceField2, {
                name: this.selected,
                price: this.priceField2
            })
                .then((response) => {
                    this.selected = '';
                    this.priceField2 = '';
                    this.$refs.coinNameInput.focus();
                    this.loadProducts();
                }, (error) => {
                    console.log('Could not create trade');
                });
        },
        totalOpen(){
            axios.get('/getTotalOpenTrades')
                .then(response =>(this.total = response.data))
        }
    },
    mounted: function () {
        this.loadProducts();
        this.getAllData();
        this.totalOpen();
    }
});
app.mount('#trading-dynamic-exchange');