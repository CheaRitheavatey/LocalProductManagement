const CategoryFilter = ({categories, onSelect}) => {
    return (
        <>
        <select className="form-control" id="categorySelect" onChange={(e) => onSelect(e.target.value)}>
            <option value="">All Categories</option>
            {category.map(categories => (<option key={category.id} value={category.id}>{category.name}</option>))}
        </select>
           
        </>
    )
}

export default ProductList