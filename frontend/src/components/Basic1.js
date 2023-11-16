import React, { useState } from 'react'

const Basic1 = () => {

    const [product, setProduct] = useState({name: '', price: ''});

    return (
        <>
            <form>
                <input type="text" value={product.name}
                onChange={evt => setProduct({...product, name: evt.target.value})}/>

                <input type="text" value={product.price}
                onChange={evt => setProduct({...product, price: evt.target.value})}/>
            </form>
            <h3>Product name is {product.name}</h3>
            <h3>Product price is {product.price}</h3>
        </>
    )
}

export default Basic1