import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProductList from './ProductList';

function App() {
  const [products, setProducts] = useState([]);
  const [category, setCategory] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null)

  useEffect(() => {
    fetch('http://localhost:8080/api/product')
    .then(response => response.json())
    .then(data => setProducts(data))
  }, []);
  // api call to the backend

  return (
    <div>
      {/* after having the data we show in frontend */}
      <div>
        {products.length ? (
          // display product
          <ProductList products={products}/>
        ) : (
          <p>No Products Found</p>
        )}
      </div>
    </div>
  )
}

export default App
