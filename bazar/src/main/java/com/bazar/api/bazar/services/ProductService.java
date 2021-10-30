package com.bazar.api.bazar.services;

import com.bazar.api.bazar.Cart;
import com.bazar.api.bazar.entities.ItemsSale;
import com.bazar.api.bazar.entities.Product;
import com.bazar.api.bazar.entities.Sale;
import com.bazar.api.bazar.repositories.ItemsSaleRepository;
import com.bazar.api.bazar.repositories.ProductPage;
import com.bazar.api.bazar.repositories.ProductRepository;
import com.bazar.api.bazar.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final Cart cart = new Cart();
    private final Pageable pageable = PageRequest.of(0, 10);
    private final Sale sale = new Sale();
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPage productPage;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ItemsSaleRepository itemsSaleRepository;

    public ResponseEntity<Optional<Product>> getId(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.isPresent() ? ResponseEntity.ok().body(product) : ResponseEntity.notFound().build();
    }

    public Page<Product> getAllProduct() {
        Page<Product> page = productRepository.findAll(pageable);
        if (page.getContent().size() > 0) {
            return page;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto foi cadastrado ainda.");
    }

    public Page<Product> getAllProductName(String productName) {
        Page<Product> page = productPage.findAllProductName(productName, pageable);
        if (page.getContent().size() > 0) {
            return page;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado.");
    }

    public Product getProduct(String productName) {
        return productRepository.findOneProduct(productName);
    }

    // verifica se um produto existe antes de adicionar no carrinho de compras.
    public Optional checkProductExists(Product product) {
        return productRepository.verifyProduct(product.getProductId(), product.getQuantity());
    }

    public void addItemsCart(Product newProduct) {
        if (this.checkProductExists(newProduct).isPresent()) {
            cart.setProducts(newProduct);
            throw new ResponseStatusException(HttpStatus.OK, "Produto adicionado no carrinho de compras.");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O Produto selecionado está indisponível.");
        }
    }

    public Cart getCart() {
        return cart;
    }

    public ItemsSale finallySale() {
        ItemsSale listSale = new ItemsSale();
        List<ItemsSale> listSaleP = new ArrayList<>();

        listSale.setProduct(cart.getProducts().get(0));
        listSaleP.add(listSale);
        sale.setItems_sale(listSaleP);

        listSale.setSale(sale.getItems_sale().get(0).getSale());

        sale.setTotal(cart.getTotal());

        saleRepository.save(sale);
        ItemsSale items = new ItemsSale(cart.getProducts().get(0), sale, cart.getProducts().get(0).getQuantity(), cart.getProducts().get(0).getValueSale());
        itemsSaleRepository.save(items);
        this.updateProduct();
        return items;
    }

    private void updateProduct() {
        productRepository.updateProduct(cart.getProducts().get(0).getProductId(), cart.getProducts().get(0).getQuantity());
    }

    public Product newProduct(Product product) {
        return productRepository.save(product);
    }
}