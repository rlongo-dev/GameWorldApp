package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@Table(name="item")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal availability;

	@Column(name="base_price")
	private BigDecimal basePrice;

	private String description;

	private String name;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="item")
	private List<Item> items;

	public Item() {
	}


	public Item(Integer id, String name, double availability, double basePrice,
			String description) {
		super();
		this.id = id;
		this.availability = BigDecimal.valueOf(availability);
		this.basePrice = BigDecimal.valueOf(availability);
		this.description = description;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAvailability() {
		return this.availability;
	}

	public void setAvailability(BigDecimal availability) {
		this.availability = availability;
	}

	public BigDecimal getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setItem(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setItem(null);

		return item;
	}

}