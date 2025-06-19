import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

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
  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  const filterProducts = products
  .filter(product => {
    return (
      (selectedCategory ? product.category.id === selectedCategory : true)
      // && product.name.toLowerCase().includes(searchTerm.toLowerCase())
     
    )
  }).sort((a,b) => {
    if (sortOrder === "asc") {
      return a.price - b.price;
    } else {
      return b.price - a.price;
    }
  });

  return (
    <div>
      {/* after having the data we show in frontend */}
      <div className='container'>
        <h1 className='my-4'>Takeo Local Products</h1>

        <div className='row align-items-center mb-4'>

          {/* for category filter */}
          <div className='col-md-3 col-sm-12 mb-2'>
            <CategoryFilter categories={categories} onSelect={handleCategorySelect} />
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
        {filterProducts.length ? (
          // display product
          <ProductList products={filterProducts}/>
        ) : (
          <p>No Products Found</p>
        )}
      </div>
    </div>
  )
}

export default App
