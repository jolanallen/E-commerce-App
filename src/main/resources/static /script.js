fetch('http://localhost:3000/api/products')
    .then(response => response.json())
    .then(products => {
        const productList = document.getElementById('product-list');

        products.forEach(product => {
            const card = document.createElement('div');
            card.className = 'product-card';

            card.innerHTML = `
        <h2>Product ID: ${product.productID}</h2>
        <p>${product.productDetails}</p>
        <p>Price: $${product.price}</p>
      `;

            productList.appendChild(card);
        });
    })
    .catch(error => {
        console.error('Error fetching products:', error);
    });