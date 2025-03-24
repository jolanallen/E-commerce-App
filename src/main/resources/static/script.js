fetch('http://localhost:3000/api/products')//fetch data with the back end
    .then(response => response.json()) //convert the response to json
    .then(products => { //handles the products data
        const productList = document.getElementById('product-list'); //handles the products data

        products.forEach(product => {
            const card = document.createElement('div');
            card.className = 'product-card';

            card.innerHTML = `
        <h2>Product ID: ${product.productID}</h2>
        <p>${product.productDetails}</p>
      `; //here you have the product data

            productList.appendChild(card);
        });
    })
    .catch(error => {
        console.error('Error fetching products:', error);
    }); //handling errors