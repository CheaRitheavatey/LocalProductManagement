import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProductList from './ProductList';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategory] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    fetch('http://localhost:8080/api/product')
    .then(response => response.json())
    .then(data => setProducts(data));

    fetch('http://localhost:8080/api/categories')
    .then(response => response.json())
    .then(data => setCategory(data));
  }, []);
  // api call to the backend

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };
  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  };

  return (
    <div>
      {/* after having the data we show in frontend */}
      <div className='container'>
        <h1 className='my-4'>Product Catalog</h1>

        <div className='row align-items-center mb-4'>

          {/* for category filter */}
          <div className='col-md-3 col-sm-12 mb-2'>
            <p>Category Filter</p>
          </div>

          {/* search function */}
          <div className='col-md-5 col-sm-12 mb-2'>
            <input type="text" className='form-control' placeholder='Search for products'onChange={handleSearchChange}/>
          </div>

          <div className='col-md-4 col-sm-12 mb-2'>
            <select className='form-control' onChange={handleSortChange}>
              <option value="asc">Sort by Price: Low to High</option>
              <option value="dsc">Sort by Price: High to Low</option>
            </select>
          </div>
 

        </div>
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
